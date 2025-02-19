package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSearchTest {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "2160x1440";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    @Disabled ("Some reason")
    void shouldFindSelenideRepositoryAtTheTop() {

        // открыть главную страницу
        open("/selenide/selenide");

        // перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$(byText("SoftAssertions")).shouldBe(visible).click();

        // Проверьте что внутри есть пример кода для JUnit5

        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}