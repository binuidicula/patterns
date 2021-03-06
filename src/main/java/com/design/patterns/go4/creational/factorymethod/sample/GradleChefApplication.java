package com.design.patterns.go4.creational.factorymethod.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.BuildController;
import com.design.patterns.go4.creational.library.buildanddeploy.ChefDeploymentController;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;
import com.design.patterns.go4.creational.library.buildanddeploy.GradleBuildController;

/**
 * Created by idiculab on 10/29/16.
 *
 * The factory method from the base class Application is implemented in this
 * child application class to give specific Build and Deployer.
 *
 */
public class GradleChefApplication extends BuildAndDeployApplication {

    @Override
    public BuildController createBuildController(){
        return  new GradleBuildController();
    }

    @Override
    public DeploymentController createDeploymentController(){
        return new ChefDeploymentController();
    }
}
