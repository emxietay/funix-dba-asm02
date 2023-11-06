package asm02.io;
import asm02.exception.FileReadException;
import asm02.exception.FileWriteException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
public class FileServiceImpl implements FileService {
    private static final FileServiceImpl instance = new FileServiceImpl();
    private final Scanner scanner;
    private FileServiceImpl() {
        this.scanner = new Scanner(System.in);
    }
    public static FileServiceImpl getInstance() {
        return instance;
    }
    /**
     * Writes the given value to the specified file.
     * If the file does not exist, it creates a new file.
     *
     * @param path the path of the file to write to
     * @param value the value to write to the file
     * @throws FileWriteException if an error occurs during file write operation
     */
    @Override
    public void writeToFile(String path, String value) {
        Path filePath = Path.of(path);
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            Files.write(filePath, value.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new FileWriteException("Error writing to " + path, e);
        }
    }
    /**
     * Reads data from the specified file and returns an array of doubles.
     *
     * @param path the path of the file to read from
     * @return an array of doubles read from the file
     */
    @Override
    public double[] readFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            double[] result = new double[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                result[i] = Double.parseDouble(lines.get(i));
            }
            return result;
        } catch (IOException e) {
            throw new FileReadException("Error reading from " + path, e);
        } catch (NumberFormatException e) {
            throw new FileReadException("Error reading from " + path, e);
        }
    }
}