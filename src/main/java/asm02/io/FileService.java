package asm02.io;

public interface FileService {
    void  writeToFile(String path, String content);
    double[] readFromFile(String path);
}
