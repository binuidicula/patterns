package com.design.patterns.go4.creational.abstractfactory;

/**
 * Created by idicula on 8/10/2015.
 * Abstract Factory provides an interface to create families of related objects
 * without specifying the concrete classes.
 *
 *
 * Important class relations
 *
 * Abstract Factory - Concrete Factories
 * Abstract Products - Concrete Products
 *
 * Known also as Kit
 */

public abstract class AbstractFactory {
    abstract AbstractProduct1 createProduct1();
    abstract AbstractProduct2 createProduct2();
}

class ConcreteFactory1 extends AbstractFactory{
    @Override
    AbstractProduct1 createProduct1() {
        return new ConcreteProduct1();
    }

    @Override
    AbstractProduct2 createProduct2() {
        return new ConcreteProduct3();
    }
}

class ConcreteFactory2 extends AbstractFactory{
    @Override
    AbstractProduct1 createProduct1() {
        return new ConcreteProduct2();
    }

    @Override
    AbstractProduct2 createProduct2() {
        return new ConcreteProduct4();
    }
}

class AbstractProduct1{
    public void doSomething(){
        System.out.printf("%s","I did my job!");
    }
}

class ConcreteProduct1 extends AbstractProduct1{}

class ConcreteProduct2 extends AbstractProduct1{}

class AbstractProduct2{
    public void doSomething(){
        System.out.printf("%s","I did my job too!!");
    }
}

class ConcreteProduct3 extends AbstractProduct2{}

class ConcreteProduct4 extends AbstractProduct2{}


class ClientWithoutFactory{

    public static void main(String... args){
        AbstractProduct1 product1 = new ConcreteProduct1();
        product1.doSomething();

        AbstractProduct2 product2 = new ConcreteProduct3();
        product2.doSomething();
    }
}

