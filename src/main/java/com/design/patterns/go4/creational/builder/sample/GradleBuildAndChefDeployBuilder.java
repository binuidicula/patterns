package com.design.patterns.go4.creational.builder.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.*;


/**
 * Created by idiculab on 10/29/16.
 */
public class GradleBuildAndChefDeployBuilder extends BuildAndDeploymentBuilder{

    public GradleBuildAndChefDeployBuilder(){
        super(new GradleBuildController(),new ChefDeploymentController());
    }

    public BuildController injectDependency(BuildDependency dependency){
        buildController.addDependency(dependency);
        return buildController;
    }

    public  BuildController addReposiory(Repository repository){
        buildController.addRepository(repository);
        return buildController;
    }

    @Override
    public DeploymentController addStage(DeploymentStage stage) {
        deploymentController.addDeploymentStage(stage);
        return deploymentController;
    }
}
