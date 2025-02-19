package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSearchEnterprizeTest {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "2160x1440";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void changesRectangles() {

        // открыть главную страницу
        open("");

        // выбор solutions и enterprize
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("a[href='https://github.com/enterprise']").click();

        // поиск текста

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));


    }

}
