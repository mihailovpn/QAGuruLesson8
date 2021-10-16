package com.sim;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.sim.pages.GithubProjectPage;
import com.sim.testdata.GithubMenu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedTest {
    GithubProjectPage githubProjectPage = new GithubProjectPage();

    @CsvSource({
            "https://github.com/mihailovpn/QAGuruLesson6, QAGuruLesson6",
            "https://github.com/mihailovpn/QAGuruLesson7, QAGuruLesson7",
            "https://github.com/mihailovpn/QAGuruLesson8, QAGuruLesson8"
    })

    @ParameterizedTest(name = "Try opening repository: {0}")
    void testWithComplexName(String baseUrl, String searchText) {
        Selenide.open(baseUrl);
        Configuration.startMaximized = true;
        $("article > h1").shouldHave(Condition.text(searchText));


    }

    @EnumSource(value = GithubMenu.class)
    @ParameterizedTest(name = "{1}")
    void menuGithubTest(GithubMenu githubMenu) {
        Selenide.open(GithubProjectPage.URL);
        githubProjectPage.switchToMenuItem(githubMenu);
        System.out.println();

    }


    @ValueSource(strings = {
            "https://github.com/mihailovpn/QAGuruLesson6",
            "https://github.com/mihailovpn/QAGuruLesson7",
            "https://github.com/mihailovpn/QAGuruLesson8"
    })

    @ParameterizedTest(name = "Try opening repository: {0}")
    void openRepositoriesTests() {
        Selenide.open("https://github.com/mihailovpn/QAGuruLesson8");
        Configuration.startMaximized = true;


    }
}
