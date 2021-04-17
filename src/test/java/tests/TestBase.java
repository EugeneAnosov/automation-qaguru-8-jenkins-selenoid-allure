package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class TestBase {

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide() );
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @AfterEach
    void afterEach() {
        attachScreenshot("Last Screenshot");
        attachPageSource();
        attachAsText("Browser Consol Logs", getConsoleLogs());
    }
}
