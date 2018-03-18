package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOCopy {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void nioCopy() throws URISyntaxException, IOException {
        Path filePathSource;
        Path filePathDestination;

        ClassLoader classLoader = getClass().getClassLoader();
        filePathSource = Paths.get(classLoader.getResource("nio-folder/source.txt").toURI());


        String fileString = classLoader.getResource("nio-folder").toURI().toString() + "/destination.txt";
        filePathDestination = Paths.get(new URI(fileString));

        Files.copy(filePathSource, filePathDestination, StandardCopyOption.REPLACE_EXISTING);
    }
}
