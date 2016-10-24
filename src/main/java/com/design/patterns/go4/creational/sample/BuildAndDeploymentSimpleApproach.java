package com.design.patterns.go4.creational.sample;

/**
 * Created by idicula on 15/10/2015.
 *
 * This is the client which is expected to solve challenges in
 * designing a flexible Build and Deployment process
 */
public class BuildAndDeploymentSimpleApproach {

    BuildController buildController = null;
    DeploymentController deploymentController = null;

    /**
     * Challenge 1 - Approach 1.
     * Create a Build and Deploy process with Gradle Build and Chef Deplyment
     * 1. Ask is specific and we usually go directly and create the specific implementation
     * So here is a very simple implementation and usage.
     */
    public void createBuildAndDeploymentControllers(){
        buildController = new GradleBuildController();
        deploymentController = new ChefDeploymentController();
    }


}
