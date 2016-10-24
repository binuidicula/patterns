package com.design.patterns.go4.creational.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idiculab on 10/22/16.
 */
public abstract class BuildAndDeploymentBuilder {

    protected  BuildController buildController;
    protected  DeploymentController deploymentController;

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

class GradleBuildAndChefDeployBuilder extends BuildAndDeploymentBuilder{

    GradleBuildAndChefDeployBuilder(){
        super(new GradleBuildController(),new ChefDeploymentController());
    }

    public  BuildController injectDependency(BuildDependency dependency){
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

class BuildAndDeploymentDirector{

    BuildAndDeploymentBuilder builder = null;

    public BuildAndDeploymentDirector(BuildAndDeploymentBuilder builder){
        this.builder = builder;
    }

    private List<BuildDependency> readAllDependecies(){
        //TODO : read from the build system parameter file, the dependencies
        //and return the list of repositories.
        return new ArrayList<BuildDependency>();
    }

    private List<Repository> readAllRepositories(){
        //TODO : read from the build system parameter file, the repositories
        //and return a sorted list of repositories.
        return new ArrayList<Repository>();
    }

    private List<DeploymentStage> readAllDeploymentStages(){
        //TODO : read from the build system parameter file, the stages
        //and return a sorted list of repositories.
        return new ArrayList<DeploymentStage>();
    }

    public void initializeBuildSteps(){
        // Step 1 : Ask the builder to inject dependencies
        List<BuildDependency> dependencyList = readAllDependecies();
        for (BuildDependency dependency: dependencyList) {
            builder.injectDependency(dependency);
        }
        // Step 2 : Ask the builder to initialize Repositories
        List<BuildDependency> repositoryList = readAllDependecies();
        for (BuildDependency dependency: dependencyList) {
            builder.injectDependency(dependency);
        }
    }

    public void initializeDeploymentSteps(){
        // Step 1 : Ask the builder to inject dependencies
        List<DeploymentStage> deploymentStages = readAllDeploymentStages();
        for (DeploymentStage stage: deploymentStages) {
            builder.addStage(stage);
        }

    }

    public BuildController getBuildController(){
        return builder.getBuildController();
    }



    public DeploymentController getDeploymentController(){
        return  new ChefDeploymentController();
    }



}