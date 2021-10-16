package com.sim.pages;

import com.codeborne.selenide.Condition;
import com.sim.testdata.GithubMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubProjectPage {
    public static final String URL = "https://github.com/mihailovpn/QAGuruLesson8";
    public static final String NAME = "QAGuruLesson8";
    public GithubProjectPage switchToMenuItem(GithubMenu githubMenu)  {
        $$(".UnderlineNav-body li").find(Condition.text(githubMenu.getDesc())).click();
//        if (githubMenu == GithubMenu.CODE) {
//            $$(".UnderlineNav-body li").find(Condition.text(githubMenu.getDesc())).click();
//        } else if(githubMenu == GithubMenu.ISSUES) {
//            $$(".UnderlineNav-body li").find(Condition.text(githubMenu.getDesc())).click();
//        } else {
//            throw new IllegalAccessException("Enum: " + githubMenu + " does not exist");
//        }
        return this;
    }

}
