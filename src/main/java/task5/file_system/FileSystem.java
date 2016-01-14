package task5.file_system;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Elizaveta Kapitonova on 14.01.16.
 */
public class FileSystem {

    public void addToFile(String path1, String text) {
        Path path = Paths.get(path1);
        byte[] fileArray;
        try {
            fileArray = Files.readAllBytes(path);
            byte[] bytes = text.getBytes();
            byte[] result = new byte[fileArray.length + bytes.length];
            System.arraycopy(fileArray, 0, result, 0, fileArray.length);
            System.arraycopy(bytes, 0, result, fileArray.length, bytes.length);
            Files.write(path, result);
        } catch (OutOfMemoryError error) {
            System.err.format("Not enough memory to add this text to %s%n", path1);
        } catch (SecurityException e) {
            System.err.format("No permission to edit %s file%n", path1);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }

    public void createTextFile(String path1, String text) {
        Path path = Paths.get(path1);
        byte[] bytes = text.getBytes();
        try {
            Files.write(path, bytes);
        } catch (SecurityException e) {
            System.err.format("No permission to create %s file%n", path1);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void removeFile(String path1) {
        Path path = Paths.get(path1);
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void showFile(String path1) {
        Path path = Paths.get(path1);
        List<String> text;
        try {
            text = Files.readAllLines(path);
            for (String line : text) {
                System.out.println(line);
            }

        } catch (NoSuchFileException x) {
            System.err.format("No such file %s%n", path);
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public void ls(String path) {
        Path dir = Paths.get(path);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                System.out.println(file.getFileName());
            }
        } catch (NotDirectoryException e)
        {
            System.err.format("%s is not a directory%n", path);
        }
        catch (IOException | DirectoryIteratorException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        final String ROOT_FOLDER = "src/main/resources/FileSystem";
        final String THIRD_DOC = "src/main/resources/FileSystem/third_doc";
        final String FIRST_FOLDER = "src/main/resources/FileSystem/FirstFolder";
        final String FIRST_DOC = "src/main/resources/FileSystem/FirstFolder/first_doc";
        final String FIRSTFIRST_FOLDER = "src/main/resources/FileSystem/FirstFolder/FirstFirstFolder";
        final String FOURTH_DOC = "src/main/resources/FileSystem/FirstFolder/FirstFirstFolder/fourth_doc";
        final String SECOND_FOLDER = "src/main/resources/FileSystem/FirstFolder/FirstFirstFolder/second_doc";

        FileSystem fileSystem = new FileSystem();
        fileSystem.ls(ROOT_FOLDER);
        fileSystem.ls(THIRD_DOC);
        fileSystem.createTextFile(FOURTH_DOC, "I like cats and dogs!");
        fileSystem.ls(FIRSTFIRST_FOLDER);
        fileSystem.showFile(FOURTH_DOC);
        fileSystem.showFile(FIRSTFIRST_FOLDER);
        fileSystem.removeFile(FOURTH_DOC);
        fileSystem.ls(FIRSTFIRST_FOLDER);
        fileSystem.showFile(FIRST_DOC);
        fileSystem.addToFile(FIRST_DOC, " little frog");
        fileSystem.showFile(FIRST_DOC);
    }
}