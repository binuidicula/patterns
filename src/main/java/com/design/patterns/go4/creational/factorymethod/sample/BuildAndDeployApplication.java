package com.design.patterns.go4.creational.factorymethod.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.BuildController;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;

/**
 * Created by idiculab on 10/29/16.
 * This is an Application whose job is to handle Build and Deployment. However there
 * are many predicted variations like which Build and which Deployment to use.
 *
 * As per GRASP - Protected Variations, it is better to abstract the variation. So the
 * application class assumes the role of handling the abstraction for the specific Build
 * and Deployment.
 *
 * As per GRASP - Polymorphic variations can be used to hide abstractions by type. So we
 * let the exact decisions of which Build system and which Deployment system to instantiate
 */
public abstract class BuildAndDeployApplication {

    BuildController buildController;
    DeploymentController deploymentController;

    protected abstract BuildController createBuildController();
    protected abstract DeploymentController createDeploymentController();

    public void createBuildAndDeploymentController(){
        this.buildController = createBuildController();
        this.deploymentController = createDeploymentController();

    }

    public BuildController getBuildController() {
        return buildController;
    }

    public void setBuildController(BuildController buildController) {
        this.buildController = buildController;
    }

    public DeploymentController getDeploymentController() {
        return deploymentController;
    }

    public void setDeploymentController(DeploymentController deploymentController) {
        this.deploymentController = deploymentController;
    }
}
