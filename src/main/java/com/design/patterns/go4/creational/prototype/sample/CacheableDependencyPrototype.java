package com.design.patterns.go4.creational.prototype.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.BuildDependency;

/**
 * An improvement requested is - All dependency must check if the dependency is registered
 * already and downloaded, use it instead of downloading again. i.e Cache the already downloaded
 * Dependency instead of downloading them again.
 *
 * The base BuildDependency is not supporting this type of caching. Hence we start to
 * build from the prototype instance
 * Created by idiculab on 10/31/16.
 */
public class CacheableDependencyPrototype extends BuildDependency implements Cloneable{

    public Object clone() throws CloneNotSupportedException{
        CacheableDependencyPrototype prototype = (CacheableDependencyPrototype)super.clone();
        return prototype;
    }
}


