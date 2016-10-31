package com.design.patterns.go4.creational.builder;

import com.design.patterns.go4.creational.builder.sample.BuildAndDeploymentBuilder;
import com.design.patterns.go4.creational.builder.sample.BuildAndDeploymentDirector;
import com.design.patterns.go4.creational.builder.sample.GradleBuildAndChefDeployBuilder;
import com.design.patterns.go4.creational.library.buildanddeploy.BuildController;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;

/**
 * Created by idiculab on 10/22/16.
 */
public class BuildAndDeploymentUsingBuilder {
    BuildController buildController = null;
    DeploymentController deploymentController = null;


    /**
     * Challenge 1 - Approach 3.
     * Are the build systems going to be very simple just as above, or more specifics might be
     * coming? Example, use the specific version of a unit testing, use specific BOM of a dependency
     * use asynchrounouse repository downloading -- and finally create a specific package which
     * must is supported by the deployment system.
     *
     * Oops.. now the need of creation is becoming interestingly complex. Nevermind, the intricasies
     * and interconnecting can be done by Builder - who does much more than creating, but assembling
     * a ready to use factory, step by step, part by part.
     *
     * Its better for those needs where factory made ready made versus tailor made!
     */
    public void createBuildAndDeploymentControllers(BuildAndDeploymentBuilder builder){
        BuildAndDeploymentDirector director = new BuildAndDeploymentDirector(builder);
        director.initializeBuildSteps();
        director.initializeDeploymentSteps();
        buildController = director.getBuildController();
        deploymentController = director.getDeploymentController();
    }

    public void createGradleChefUsingBuilder(){
        BuildAndDeploymentBuilder builder = new GradleBuildAndChefDeployBuilder();
        createBuildAndDeploymentControllers(builder);

    }


}
