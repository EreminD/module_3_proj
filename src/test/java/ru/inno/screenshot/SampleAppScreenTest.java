package ru.inno.screenshot;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SeleniumJupiter.class)
public class SampleAppScreenTest {

    public static final String url = "http://www.uitestingplayground.com/sampleapp";

    @Test
    public void arraysDiffer(ChromeDriver driver) throws IOException {
        driver.get(url);

        byte[] asIs = driver.getScreenshotAs(OutputType.BYTES);
        byte[] toBe = Files.readAllBytes(Path.of("tobe1.png"));

        assertArrayEquals(asIs, toBe);
    }

    @Test
    public void saveScreenshot(ChromeDriver driver) throws IOException {
        driver.get(url);

        Screenshot screen = new AShot().takeScreenshot(driver);
        BufferedImage image = screen.getImage();
        saveToFile(image, "ashot.png");
    }

    @Test
    public void compareScreens(ChromeDriver driver) throws IOException {
        driver.get(url);

        BufferedImage asIs = new AShot().takeScreenshot(driver).getImage();
        BufferedImage toBe = ImageIO.read(Path.of("tobe1.png").toFile());

        ImageDiff imageDiff = new ImageDiffer()
                .withDiffMarkupPolicy(new ImageMarkupPolicy().withDiffColor(Color.blue))
                .makeDiff(asIs, toBe);

        if (imageDiff.hasDiff()) {
            saveToFile(imageDiff.getMarkedImage(), "marketImage.png");
            saveToFile(imageDiff.getDiffImage(), "diff.png");
        }

        assertFalse(imageDiff.hasDiff());
    }




    private static void saveToFile(BufferedImage markedImage, String fileName) throws IOException {
        ImageIO.write(markedImage, "png", Path.of(fileName).toFile());
    }

}
