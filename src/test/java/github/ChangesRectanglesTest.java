package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ChangesRectanglesTest {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "2160x1440";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void ChangesRectanglesTest() {

        // открыть главную страницу
        open("/drag_and_drop");

        // проверить, что прямоугольники находятся в исходном положении

        $("#column-a").shouldHave(text("A"));

        // перемещение местами прямоугольников
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();

        // проверка, что прямоугольники поменялись

        $("#column-a").shouldHave(text("B"));

    }

    @Test
    void dragDropWithElementsTest() {

        // открыть главную страницу
        open("/drag_and_drop");

        // проверить, что прямоугольники находятся в исходном положении

        $("#column-a").shouldHave(text("A"));

        // перемещение местами прямоугольников

        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));

        // проверка, что прямоугольники поменялись

        $("#column-b header").shouldHave(text("A"));
    }
}



