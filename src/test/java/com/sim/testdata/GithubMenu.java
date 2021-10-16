package com.sim.testdata;

public enum GithubMenu {
    CODE("Code"), ISSUES("Issues");

    private String desc;

    GithubMenu(String desc) {
        this.desc  = desc;
    }

    public String getDesc() {
        return desc;
    }
}
