package com.sim.pages;

import com.codeborne.selenide.Condition;
import com.sim.testdata.GithubMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexPage {
    public static final String URL = "https://yandex.ru/";
    public YandexPage search (String searchArgument)  {
        $("#text").setValue(searchArgument).pressEnter();
        return this;
    }
}
