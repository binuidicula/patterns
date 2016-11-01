package com.design.patterns.go4.creational.library.buildanddeploy;

/**
 * Created by idiculab on 10/22/16.
 */
public class BuildDependency{

    public enum BuildDependencyType { COMPILE_TIME_ONLY,COMPILE_AND_DEPLOY }
    private String packagename;
    private String version;
    private DownloadState downloadState = DownloadState.UNKNOWN;

    public enum DownloadState {UNKNOWN, DOWNLOAD_IN_PROGRESS, DOWNLOAD_COMPLETED, DOWNLOAD_FAILED}

    private BuildDependencyType dependencyType;

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public DownloadState getDownloadState() {
        return downloadState;
    }

    public void setDownloadState(DownloadState downloadState) {
        this.downloadState = downloadState;
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
