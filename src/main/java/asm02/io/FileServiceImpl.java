package asm02.io;

import asm02.exception.FileWriteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileServiceImpl implements FileService {

    private final Scanner scanner;

    public FileServiceImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void writeToFile(String path, String value) {
        Path filePath = Path.of(path);
        try {
            Files.write(filePath, value.getBytes());
        } catch (IOException e) {
            throw new FileWriteException("Error writing to " + path, e);
        }
    }

    @Override
    public double[] readFromFile(String path) {

        return new double[0];
    }
}
