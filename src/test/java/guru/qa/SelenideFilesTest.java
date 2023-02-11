package guru.qa;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelenideFilesTest {



    @Test
    void selenideDownloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadFile = $("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadFile)){
            byte[] bytes = is.readAllBytes();
            String textContent = new String(bytes, StandardCharsets.UTF_8);
            assertThat(textContent).contains("This repository is the home of the next generation of JUnit, _JUnit 5_.");
        }
    }

    @Test
    void selenideUploadFile(){
        open("https://fineuploader.com/demos.html");
        $("input[type='file']").uploadFromClasspath("example/cat.png");
        System.out.println();
    }
}
