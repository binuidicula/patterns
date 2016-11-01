package com.design.patterns.go4.creational.prototype.sample;

import com.design.patterns.go4.creational.library.buildanddeploy.BuildDependency;
import com.design.patterns.go4.creational.library.buildanddeploy.DeploymentController;
import javafx.concurrent.Task;
import static com.design.patterns.go4.creational.library.buildanddeploy.BuildDependency.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Created by idiculab on 10/31/16.
 */
public class DependencyCacheRegistry {

    private Map<String, CacheableDependencyPrototype> dependencyRegistry = null;
    private static DependencyCacheRegistry instance = null;

    private DependencyCacheRegistry(){
        dependencyRegistry = new HashMap<String, CacheableDependencyPrototype>();
    }

    public static synchronized DependencyCacheRegistry getInstance(){
        if(instance == null){
            instance = new DependencyCacheRegistry();
        }
        return instance;
    }

    public CacheableDependencyPrototype registerDependency(String packageName, String version){
        String uniqueKey = packageName + version;
        if(!dependencyRegistry.containsKey(uniqueKey)) {
            CacheableDependencyPrototype dependency = new CacheableDependencyPrototype();
            dependency.setPackagename(packageName);
            dependency.setVersion(version);
            /*CompletableFuture<DownloadState> downloadState =
                    download(dependency);*/
            dependency.setDownloadState(DownloadState.DOWNLOAD_IN_PROGRESS);

        }
        try {
            CacheableDependencyPrototype dependency =
                    (CacheableDependencyPrototype)dependencyRegistry.get(uniqueKey).clone();
            return dependency;
        }catch(CloneNotSupportedException ce){

        }
        return  null;
    }


    private void download(CacheableDependencyPrototype dependency){
        // TODO download to the configured repository.
        //CompletableFuture.supplyAsync()
    }
}
