package com.design.patterns.go4.creational.abstractfactory;

import com.design.patterns.go4.creational.abstractfactory.sample.BuildAndDeploymentKit;
import com.design.patterns.go4.creational.library.buildanddeploy.BuildController;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;

/**
 * Created by idiculab on 10/22/16.
 */
public class BuildAndDeploymentUsingAbstractFactory {

    BuildController buildController = null;
    DeploymentController deploymentController = null;

    /**
     * Challenge 1 - Approach 2.
     * In challenge 1 - Approach 1, the ask was specific - use Gradle and Chef.
     * And since the ask was simple, we created specific implementations in the controller.
     * <li>
     * <a>1.But we are directly fixing one among the choice. That is, from a family of products.</a>
     * <a>2.In future, more specific demands may come in the ask, with more specific to each product.
     * say for example, use a particular version of gradle, or add a default version to chef</a>
     * </li>
     *
     * If the controller has many other things to do (lets say controlling a workflow),
     * focussing on specifics of creation of an object may become too silly for him and can make him bulky.
     *
     * A designers job is to make sure controller remains focussed on his task, so he might
     * think of offloading the creation job to an extendable factory which can
     * have space for unknowns in the build and deployment systems.
     *
     * However this approach is still not intuitive with specific to the problem.
     * So a combinatorial explotion of factories is going to be implemented
     * for each build, deployment combination.
     *
     * Amd more they evolve, the factories will become a beweldering set of choices
     * - the one who knows how to create is the Kit, and is passed in as a parameter.
     */
    public void createBuildAndDeploymentControllers(BuildAndDeploymentKit kit){
        buildController = kit.getBuildController();
        deploymentController = kit.getDeploymentController();
    }


}
