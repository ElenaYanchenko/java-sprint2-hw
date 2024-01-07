import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class FileReaderRep {
        public ArrayList<String> readFileContents(String fileName) {
            String path = "D:\\Users\\" + fileName;
            System.out.println("Загружается файл:" + " " + path);
            try {
                return new ArrayList<>(Files.readAllLines(Path.of(path)));
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла");
                return new ArrayList<>();
            }
        }
}


