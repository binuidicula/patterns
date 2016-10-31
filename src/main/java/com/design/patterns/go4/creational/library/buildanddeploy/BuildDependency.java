package com.design.patterns.go4.creational.library.buildanddeploy;

/**
 * Created by idiculab on 10/22/16.
 */
public class BuildDependency{

    enum BuildDependencyType { COMPILE_TIME_ONLY,COMPILE_AND_DEPLOY }
    private String packagename;
    private String version;
    private BuildDependencyType dependencyType;

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BuildDependencyType getDependencyType() {
        return dependencyType;
    }

    public void setDependencyType(BuildDependencyType dependencyType) {
        this.dependencyType = dependencyType;
    }
}
