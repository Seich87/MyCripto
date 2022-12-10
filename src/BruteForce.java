import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BruteForce {

    public void bruteForce() {
        try {
            System.out.println("Введите путь к текстовому файлу с зашифрованным текстом");
            Scanner scanner = new Scanner(System.in);
            String strPath = scanner.next();
            Path path = Paths.get(strPath);

            if (!(path.toFile().isFile())) {
                System.out.println("Введенный файл отсутствует по указанному пути на диске");
                return;
            }
            keySelection(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void keySelection(Path path) {

    }
}

