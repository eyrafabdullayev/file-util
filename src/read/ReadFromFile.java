package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author eyraf
 */
public class ReadFromFile {
    public static String usingFileReader(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader bw = new BufferedReader(new FileReader(fileName))) {
            String line;
            String text = "";
            while ((line = bw.readLine()) != null) {
                text += line;
            }
            return text;
        }
    }

    public static byte[] usingFileInputStream(String fileName) throws IOException, IOException {
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return data;
        }
    }

    public static byte[] readFromFileUsingNIO(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        byte[] byteArr = Files.readAllBytes(filePath);
        return byteArr;
    }

    public static Object usingObjectInputStream(String fileName) {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ois.readObject();
        } finally {
            return obj;
        }
    }
}
