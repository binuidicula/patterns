package com.design.patterns.go4.creational.builder;

/**
 * Created by idiculab on 10/23/15.
 */
public abstract class Builder {
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract void buildPart3();
    public abstract Product getProduct();
}

class ConcreteBuilder extends  Builder{

    Product product = null;

    public void buildPart1() {

    }

    public void buildPart2() {

    }

    public void buildPart3() {

    }

    public Product getProduct() {
        return product;
    }
}

class Director{
    private Builder builder;

    Director(Builder builder){
        this.builder = builder;
    }

    public void constructTheProduct(){
        builder.buildPart1();

    }
}


class Product{

}