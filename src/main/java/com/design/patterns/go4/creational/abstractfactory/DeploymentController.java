package com.design.patterns.go4.creational.abstractfactory;

import com.design.patterns.go4.creational.sample.DeploymentStage;

/**
 * Created by idicula on 15/10/2015.
 */
public abstract class DeploymentController {
    public abstract void addDeploymentStage(DeploymentStage stage);
}

class ChefDeploymentController extends DeploymentController {
    @Override
    public void addDeploymentStage(DeploymentStage stage) {

    }
}

class AnsibleDeploymentController extends DeploymentController {
    @Override
    public void addDeploymentStage(DeploymentStage stage) {

    }
}

class FabricDeploymentController extends DeploymentController {
    @Override
    public void addDeploymentStage(DeploymentStage stage) {

    }
}

class PupperDeploymentControler extends DeploymentController {
    @Override
    public void addDeploymentStage(DeploymentStage stage) {

    }
}

class SaltStackDeploymentController extends DeploymentController {
    @Override
    public void addDeploymentStage(DeploymentStage stage) {

    }
}