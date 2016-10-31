package com.design.patterns.go4.creational.library.buildanddeploy;

/**
 * Created by idiculab on 10/22/16.
 */
public class Repository {

    private String repositoryUrl;
    private boolean refreshAlways;
    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }


    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public boolean isRefreshAlways() {
        return refreshAlways;
    }

    public void setRefreshAlways(boolean refreshAlways) {
        this.refreshAlways = refreshAlways;
    }
}
