package com.design.patterns.go4.creational.factorymethod;

import com.design.patterns.go4.creational.builder.sample.BuildAndDeploymentBuilder;
import com.design.patterns.go4.creational.builder.sample.BuildAndDeploymentDirector;
import com.design.patterns.go4.creational.builder.sample.GradleBuildAndChefDeployBuilder;
import com.design.patterns.go4.creational.factorymethod.sample.BuildAndDeployApplication;
import com.design.patterns.go4.creational.factorymethod.sample.GradleChefApplication;
import com.design.patterns.go4.creational.library.buildanddeploy.BuildController;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;

/**
 * Created by idiculab on 10/22/16.
 */
public class ClientUsingFactoryMethod {
    BuildController buildController = null;
    DeploymentController deploymentController = null;


    /**
     * Challenge 1 - Approach 4.
     * It is a Build And Deploy Application. Many different applications may come across
     * but all of them are going to build a BuildController and another DeploymentControler
     *
     * At the time of Application, it doesnot know, which is the Build And Deploy it needs
     * to initiate. So the Application let the decision to be made by specific Application
     * subclasses itself.
     *
     * Factory Method - versus - Abstract Factory - is the decision about who is abstracting
     * the variation. If the application itself assumes abstracting the variation with a template
     * method, it becomes Factory Method. If the application let use another Factory to
     * create specific instances, it becomes Abstract Factory.
     */

    public void createGradleChefUsingBuilder(){
        BuildAndDeployApplication application = new GradleChefApplication();
        application.createBuildAndDeploymentController();
    }


}
