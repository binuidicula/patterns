package com.design.patterns.go4.creational.builder.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by idiculab on 10/29/16.
 */
public class BuildAndDeploymentDirector{

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
