package com.design.patterns.go4.creational.library.buildanddeploy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idiculab on 10/22/16.
 */
public class DeploymentStage {

    private List<DeploymentStage> predecessorStages;

    DeploymentStage(){
        predecessorStages = new ArrayList<DeploymentStage>();
    }
    public void addStageAsPredecessor(DeploymentStage stage){
        predecessorStages.add(stage);
    }
}
