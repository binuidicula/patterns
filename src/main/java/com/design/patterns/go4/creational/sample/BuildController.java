package com.design.patterns.go4.creational.sample;

/**
 * Created by idicula on 15/10/2015.
 */
public class BuildController {
    public void addDependency(BuildDependency dependency){}
    public void addRepository(Repository repository){}
}



class GradleBuildController extends BuildController{

}

class MavenBuildController extends  BuildController{

}

class AntPlusIvyBuildController extends BuildController{}