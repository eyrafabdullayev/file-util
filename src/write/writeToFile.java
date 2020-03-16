package write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author eyraf
 */
public class writeToFile {

    public static void usingFileWriter(String fileName, String text, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            bw.write(text);
        }//auto-close
    }

    public static void usingFileOutputStream(String fileName, byte[] data) throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
            fos.write(data);
            fos.flush();//accept
        }
    }

    public static void writeToFileUsingNIO(String fileName, byte[] byteArr) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, byteArr);
    }

    public static boolean usingObjectOutputStream(String fileName, Object obj) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(obj);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
