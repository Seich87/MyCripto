import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Encryption {
    Scanner scanner = new Scanner(System.in);
    private int key = keySet();
    private Path path = filePath();

    public int getKey() {
        return key;
    }

    public Path getPath() {
        return path;
    }

    private int keySet() {
        do {
            System.out.println("Введите ключ от 1 до 74");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите число");
                scanner.next();
            }
            key = scanner.nextInt();
            if (key < 1 || key > 74) System.out.println("Введите число от 1 до 74 включительно");
        } while (key < 1 || key > 74);
        return key;
    }

    private Path filePath() {
        String strPath = "";
        while (true) {
            System.out.println("Введите путь к текстовому файлу с исходным текстом");
            strPath = scanner.next();
            if (!(Paths.get(strPath).toFile().isFile())) {
                System.out.println("Данный файл отсутствует");
            } else if (Paths.get(strPath).toFile().isFile()) {
                break;
            }
        }
        return Path.of(strPath);
    }


    void encryptionToFile(Path path, int key) {
        String allStr = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя.,\":-!? ";

        char[] allChar = allStr.toCharArray();
        ArrayList<Character> arrAll = new ArrayList<>();
        for (char a : allChar) {
            arrAll.add(a);
        }

        ArrayList<Character> arrInFile = new ArrayList<>();

        try (FileReader fileReader = new FileReader(String.valueOf(path));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.ready()) {
                char a = (char) bufferedReader.read();
                arrInFile.add(a);
            }

            ArrayList<Character> arrCode = new ArrayList<>();

            for (int i = 0; i < arrInFile.size(); i++) {
                if (!arrAll.contains(arrInFile.get(i))) {
                    System.out.println("В тексте используются следующие запрещенные символы: " + arrInFile.get(i));
                    arrCode.add(i, arrInFile.get(i));
                } else {
                    for (int j = 0; j < arrAll.size(); j++) {

                        if ((arrInFile.get(i).equals(arrAll.get(j)) && (j + key) >= arrAll.size())) {
                            arrCode.add(i, arrAll.get(j + key - arrAll.size()));
                        } else if (arrInFile.get(i).equals(arrAll.get(j))) {
                            arrCode.add(i, arrAll.get(j + key));
                        }
                    }
                }
            }

            Writer writer = new FileWriter("C:\\Users\\Александр\\Downloads\\encryptionFile.txt");
            for (Character ch : arrCode) {
                writer.write(ch);
            }
            writer.flush();
            writer.close();
            System.out.println("Шифр записан в файл: C:\\Users\\Александр\\Downloads\\encryptionFile.txt");

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

