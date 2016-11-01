package com.design.patterns.go4.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by idiculab on 10/31/16.
 * Prototypes avoids Subclassing of creator by using cloneable concrete products.
 *
 * The logic relies on two principles
 * 1. A product must be cloneable, hence all its specific variations as well.
 * 2. As long as the product and its heirarchy is cloneable, the creator is not bound to any specific
 * instances.
 *
 * Advantages
 * 1. Reduced Sublcassing at creator
 * 2. Adding or removing dependency at runtime.
 * 3. New behavior through composition
 *
 * In this example, we assume the Prototype is an improvement of an existing
 * non-cloneable class.
 */
public abstract class Prototype extends NonCloneable implements Cloneable{

    protected String nameOfPrototype = "Base Prototype";
    protected Helper helper = null;

    /**
     * It is mandatory to override the clone in Prototype in order for the
     * prototype registry or manager to call a clone from the context of a client.
     *
     * It is also important that the child classes override the way the shallow copied
     * instances has to be modified before giving to the external context. For example
     * one child class may override clone for implementing a deep clone or another child may
     * override the clone it to nullify certain associations.
     * @return Cloned shallow cloned Object from super.clone();
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public void setHelper(Helper helper){
        this.helper = helper;
    }

    public Helper getHelper(){
        return  this.helper;
    }

    public void setNameOfPrototype(String nameOfPrototype) {
        this.nameOfPrototype = nameOfPrototype;
    }

    public String getNameOfPrototype() {
        return nameOfPrototype;
    }
}


class DeepClonePrototype extends  Prototype{

    /**
     * This implements a deep clone. The Helper object is cloned as well
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException{
        DeepClonePrototype prototype1 = (DeepClonePrototype) super.clone();
        if(prototype1.getHelper()!=null){
            Helper clonedHelper = (Helper)prototype1.getHelper().clone();
        }
        String newName = nameOfPrototype;
        if(newName!= null && !newName.isEmpty()){
            newName = new String(newName + " - Cloned");
        }
        prototype1.setNameOfPrototype(newName);
        prototype1.setHelper(new Helper());
        return prototype1;
    }

}

/**
 * This Concrete prototype implements shallow cloning, ie leaves implementation
 * as by default. The associated components are not cloned. But they remain same as
 * the base object.
 *
 * The overriding of Clone - is a shallow copy.
 */
class ShallowClonePrototype extends  Prototype{

    @Override
    public Object clone() throws CloneNotSupportedException{
        ShallowClonePrototype clone = (ShallowClonePrototype)super.clone();
        return clone;
    }
}

/**
 * This concrete prototype just extends the Prototype and there by it
 * also becomes cloneable - even though explicitly it is not overriding
 * a clone, it does allow shallow copy from the base.
 *
 * If no overriding is done for clone, it calls the base class clone,
 * which is still a shallow copy of this object - In reality no difference
 * between ShallowClonePrototype and DefaultClonePrototype other than one
 * overriding and following simple super.clone, other implicitly assuming
 * and relying on its parent class clone.
 */
class DefaultClonePrototype extends  Prototype{

}


/**
 * A superclass which is provided by someone, and is not cloneable.
 * Hence there are certain limitations in cloneing. The states
 * of the clone may not be exactly as with the base.
 */
class  NonCloneable{

    private int markup;
    private int nextMarkUp;


    public int getMarkup() {
        return markup;
    }

    public void setMarkup(int markup) {
        this.markup = markup;
    }

    public int getNextMarkUp() {
        return nextMarkUp;
    }

    public void setNextMarkUp(int nextMarkUp) {
        this.nextMarkUp = nextMarkUp;
    }
}

/**
 * Helper class to showcase the difference between immutable
 * String parameters and mutable objects in clone.
 */
class Helper implements  Cloneable{
    private String nameOfHelper = "Helper";


    public String getNameOfHelper() {
        return nameOfHelper;
    }

    public void setNameOfHelper(String nameOfHelper) {
        this.nameOfHelper = nameOfHelper;
    }

    public Object clone() throws CloneNotSupportedException{
        return  super.clone();
    }
}

/**
 * A registry of clones which can be used to
 * 1. Register Cloneabe Prototypes, with their type.
 */
class PrototypeRegistry{

    private Map<String, Prototype> prototypeMap = null;
    private static PrototypeRegistry instance = null;


    private PrototypeRegistry(){
        this.prototypeMap = new HashMap<String, Prototype>();
    }

    public synchronized  static PrototypeRegistry getInstance(){
        if(instance == null){
            instance = new PrototypeRegistry();
        }
        return instance;
    }

    public void registerPrototype(String prototypeName, Prototype prototype){
        prototypeMap.put(prototypeName,prototype);
    }

    public Prototype getProduct(String productName){
        Prototype type = null;
        try {
            if (prototypeMap.containsKey(productName)) {
                type = (Prototype) prototypeMap.get(productName).clone();
            }
        }catch (CloneNotSupportedException e){
            // CloneNotSupportedException, which is not
            // going to be thrown from Prototypes - clone supported objects.
            // Hence suppressing this exception from going further up in call chain.
            e.printStackTrace();
        }
        return type;
    }
}

class Client{

    public static void main(String... args) throws CloneNotSupportedException {
        PrototypeRegistry registry = PrototypeRegistry.getInstance();

        DeepClonePrototype prototype1 = new DeepClonePrototype();
        prototype1.setHelper(new Helper());
        prototype1.setNameOfPrototype("Deep");
        registry.registerPrototype("Deep",prototype1);

        ShallowClonePrototype prototype2 =  new ShallowClonePrototype();
        prototype2.setHelper(new Helper());
        prototype2.setNameOfPrototype("Shallow");
        registry.registerPrototype("Shallow",prototype2);

        DefaultClonePrototype prototype3 =  new DefaultClonePrototype();
        prototype3.setHelper(new Helper());
        prototype3.setNameOfPrototype("Wrong");
        registry.registerPrototype("Wrong",prototype3);

        System.out.printf("The Original Helper:%s%n",prototype1.getHelper());
        System.out.printf("The Name of Original:%s%n",prototype1.nameOfPrototype);
        Prototype prototype1Clone = registry.getProduct("Deep");
        System.out.printf("The Cloned Object:%s%n",prototype1Clone.getHelper());
        System.out.printf("The Name of Cloned Object:%s%n",prototype1Clone.nameOfPrototype);


        System.out.printf("The Original helper:%s%n",prototype2.getHelper());
        System.out.printf("The Name of Original:%s%n",prototype2.nameOfPrototype);
        Prototype prototype2Clone = registry.getProduct("Shallow");
        System.out.printf("The Cloned Object:%s%n",prototype2Clone.getHelper());
        System.out.printf("The Name of Cloned Object:%s%n",prototype2Clone.nameOfPrototype);



        System.out.printf("The Original helper:%s%n",prototype3.getHelper());
        System.out.printf("The Name of Original:%s%n",prototype3.nameOfPrototype);
        Prototype prototype3Clone = registry.getProduct("Wrong");
        System.out.printf("The Cloned Object:%s%n",prototype3Clone.getHelper());
        System.out.printf("The Name of Cloned Object:%s%n",prototype3Clone.nameOfPrototype);

        prototype3.setNameOfPrototype("Shallow Changed");
        prototype3.getHelper().setNameOfHelper("Helper changed");
        // Will print Shallow Changed
        System.out.println(prototype3.nameOfPrototype);
        // Will print Helper Changed
        System.out.println(prototype3.getHelper().getNameOfHelper());

        // Will print as Wrong!! - Remember the String as immutables
        System.out.println(prototype3Clone.nameOfPrototype);
        // Will print Helper Changed!
        System.out.println(prototype3Clone.getHelper().getNameOfHelper());

    }
}