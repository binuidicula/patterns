package com.design.patterns.go4.creational.abstractfactory.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.BuildController;
import com.design.patterns.go4.creational.library.buildanddeploy.ChefDeploymentController;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;
import com.design.patterns.go4.creational.library.buildanddeploy.GradleBuildController;

/**
 * Created by idiculab on 10/22/16.
 */
public abstract class BuildAndDeploymentKit {

    public abstract BuildController getBuildController();
    public abstract DeploymentController getDeploymentController();
}

class GradleChefKit extends BuildAndDeploymentKit {

    @Override
    public BuildController getBuildController() {
        return new GradleBuildController();
    }

    @Override
    public DeploymentController getDeploymentController() {
        return new ChefDeploymentController();
    }
}