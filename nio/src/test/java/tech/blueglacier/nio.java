package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class nio {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void readFile() {
        int count;
        Path filePath = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            filePath = Paths.get(classLoader.getResource("nio-folder/test.txt").toURI());
        } catch (InvalidPathException | URISyntaxException e) {
            System.out.println("Path error :" + e);
        }
        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(filePath)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(128);

            do {
                count = seekableByteChannel.read(byteBuffer);
                if (count != -1) {
                    byteBuffer.rewind();
                    for (int ch : byteBuffer.array()) {
                        System.out.print((char) ch);
                    }

                }
            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            System.out.println("IO error : " + e);
        }
    }
}
