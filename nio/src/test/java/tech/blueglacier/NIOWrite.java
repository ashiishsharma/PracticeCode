package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;

public class NIOWrite {

    @BeforeMethod
    public void init() {

    }

    @Test
    public void fileWrite() {
        Path filePath = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String fileString = classLoader.getResource("nio-folder").toURI().toString() + "/test.txt";
            filePath = Paths.get(new URI(fileString));
        } catch (InvalidPathException | URISyntaxException e) {
            System.out.println("Path error :" + e);
        }
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);

            for (int i = 0; i < 26; i++) {
                byteBuffer.put(((byte) ('A' + i)));
            }
            byteBuffer.rewind();

            fileChannel.write(byteBuffer);
            System.out.println();
        } catch (IOException e) {
            System.out.println("IO error : " + e);
        }
    }

    @Test
    public void mappedWrite() {
        Path filePath = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String fileString = classLoader.getResource("nio-folder").toURI().toString() + "/test.txt";
            filePath = Paths.get(new URI(fileString));
        } catch (InvalidPathException | URISyntaxException e) {
            System.out.println("Path error :" + e);
        }
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(filePath,
                StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);

            for (int i = 0; i < 26; i++) {
                mappedByteBuffer.put(((byte) ('A' + i)));
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("IO error : " + e);
        }
    }
}
