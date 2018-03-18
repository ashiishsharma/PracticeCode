package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOShowFile {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void showFile() throws URISyntaxException {
        Path filePathSource;
        ClassLoader classLoader = getClass().getClassLoader();
        filePathSource = Paths.get(classLoader.getResource("nio-folder/source.txt").toURI());

        int i;
        // Open the file and obtain a stream linked to it.
        try (InputStream fin = Files.newInputStream(filePathSource)) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (InvalidPathException | IOException e) {
            System.out.println("Error : " + e);
        }
    }
}
