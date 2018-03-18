package tech.blueglacier;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIORead {

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

    @Test
    public void mappedChannelRead() {
        long fileSize;
        Path filePath = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            filePath = Paths.get(classLoader.getResource("nio-folder/test.txt").toURI());
        } catch (InvalidPathException | URISyntaxException e) {
            System.out.println("Path error :" + e);
        }
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(filePath)) {
            fileSize = fileChannel.size();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) mappedByteBuffer.get());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}