package ru.inno.screenshot;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.galenframework.api.Galen.checkLayout;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


//https://galenframework.com/docs/reference-java-tests/
@ExtendWith(SeleniumJupiter.class)
public class SampleAppSpecTest {
    public static final String url = "http://www.uitestingplayground.com/sampleapp";

    @Test
    public void myCssChecker(ChromeDriver driver) {
        // get rules from file
        // soft-assert
        driver.get(url);

        Map<String, String> css = new HashMap<>();
        css.put("color", "rgba(23, 162, 184, 1)");
        css.put("font-size", "15px");
        css.put("font-family", "-apple-system, \"system-ui\", \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\"");

        String locator = "#loginstatus";
        css.forEach((key, val) -> checkCssProperty(driver, locator, key, val));
    }

    private void checkCssProperty(WebDriver driver, String locator, String key, String val) {
        String val2 = driver.findElement(By.cssSelector(locator)).getCssValue(key);
        assertEquals(val, val2);
    }

    @Test
    public void galenDemo(ChromeDriver driver) throws IOException {
        driver.get("https://github.com/login");
        driver.manage().window().setSize(new Dimension(1280, 980));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        LayoutReport report = checkLayout(driver, "src/test/resources/specs/github.spec", List.of("desktop"));

        List<GalenTestInfo> tests = new LinkedList<>();
        GalenTestInfo test = GalenTestInfo.fromString("Github login test");
        test.getReport().layout(report, "check layout on desktop");
        tests.add(test);

        new HtmlReportBuilder().build(tests, "target/galen-html-reports");

        if (report.errors() > 0){
            report.getValidationErrorResults().forEach(validationResult -> {
                System.out.println(validationResult.getError());
            });

            fail();
        }
    }
}
