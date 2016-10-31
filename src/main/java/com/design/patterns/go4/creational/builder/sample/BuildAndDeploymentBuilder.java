package com.design.patterns.go4.creational.builder.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.*;
import com.design.patterns.go4.creational.library.buildanddeploy.*;

/**
 * Created by idiculab on 10/22/16.
 */
public abstract class BuildAndDeploymentBuilder {

    protected BuildController buildController;
    protected DeploymentController deploymentController;

    public BuildController getBuildController() {
        return buildController;
    }

    public DeploymentController getDeploymentController() {
        return deploymentController;
    }

    BuildAndDeploymentBuilder(BuildController buildController,
                              DeploymentController deploymentController){
        this.buildController = buildController;
        this.deploymentController = deploymentController;
    }

    public  abstract BuildController injectDependency(BuildDependency dependency);

    public  abstract BuildController addReposiory(Repository repository);

    public abstract DeploymentController addStage(DeploymentStage stage);

}

