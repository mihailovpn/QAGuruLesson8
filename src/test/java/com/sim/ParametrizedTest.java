package com.sim;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.sim.pages.GithubProjectPage;
import com.sim.pages.YandexPage;
import com.sim.testdata.GithubMenu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedTest {
    GithubProjectPage githubProjectPage = new GithubProjectPage();
    YandexPage yandexPage = new YandexPage();

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

    @EnumSource(value = GithubMenu.class, names = {"CODE", "ISSUES"})
    @ParameterizedTest(name = "{0}")
    void menuGithubTest(GithubMenu githubMenu) {
        Selenide.open(GithubProjectPage.URL);
        githubProjectPage.switchToMenuItem(githubMenu);
        $("[itemprop='name']").shouldHave(Condition.text(GithubProjectPage.NAME));
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        "1", "Первый канал"
                ),
                Arguments.of(
                        "2", "Карта городов России"
                )
        );
    }

    @MethodSource
    @ParameterizedTest
    void testWithMethodSource(String searchText, String expectedResult) {
        Selenide.open(YandexPage.URL);
        yandexPage.search(searchText);
        $("[accesskey='1']").shouldHave(Condition.text(expectedResult));
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
