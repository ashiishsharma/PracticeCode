package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOStreamWrite {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void streamWrite() throws URISyntaxException {
        Path filePathDestination;
        ClassLoader classLoader = getClass().getClassLoader();
        String fileString = classLoader.getResource("nio-folder").toURI().toString() + "/nioStreamWrite.txt";
        filePathDestination = Paths.get(new URI(fileString));

        // Open the file and obtain a stream linked to it.
        try (OutputStream fout =
                     new BufferedOutputStream(
                             Files.newOutputStream(filePathDestination))) {
            // Write some bytes to the stream.
            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }
        } catch (InvalidPathException | IOException e) {
            System.out.println("Error : " + e);
        }
    }
}
