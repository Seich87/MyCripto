import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {


    Scanner scanner = new Scanner(System.in);
    private final Path path = filePath();

    public Path getPath() {
        return path;
    }

    private Path filePath() {
        String strPath = "";
        while (true) {
            System.out.println("Введите путь к текстовому файлу с зашифрованным текстом");
            strPath = scanner.next();
            if (!(Paths.get(strPath).toFile().isFile())) {
                System.out.println("Данный файл отсутствует");
            } else if (Paths.get(strPath).toFile().isFile()) {
                break;
            }
        }
        return Path.of(strPath);
    }


    void bruteForce(Path path) {
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


            for (int k = 1; k < arrAll.size(); k++) {
                ArrayList<Character> arrCode = arrCodeAdd(arrAll, arrInFile, k);
                if (textCheck(arrCode)) {

                    Writer writer = new FileWriter("C:\\Java\\MyProject\\MyCripto\\MyCripto\\src\\BruteForceFile.txt");
                    for (Character ch : arrCode) {
                        writer.write(ch);
                    }
                    writer.flush();
                    writer.close();
                    System.out.println("Расшифрованный текст записан в файл: C:\\Java\\MyProject\\MyCripto\\MyCripto\\src\\BruteForceFile.txt");
                    System.out.println("Криптографический ключ: " + k);
                    break;
                } else {
                    arrCode.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Character> arrCodeAdd(ArrayList<Character> arrAll, ArrayList<Character> arrInFile, int k) {
        ArrayList<Character> arrCode = new ArrayList<>();
        for (int i = 0; i < arrInFile.size(); i++) {
            if (!arrAll.contains(arrInFile.get(i))) {
                arrCode.add(i, arrInFile.get(i));
            } else {
                for (int j = 0; j < arrAll.size(); j++) {
                    if (arrAll.get(j).equals(arrInFile.get(i)) && (j - k) < 0) {
                        arrCode.add(i, arrAll.get(j - k + arrAll.size()));
                    } else if (arrAll.get(j).equals(arrInFile.get(i))) {
                        arrCode.add(i, arrAll.get(j - k));
                    }
                }
            }
        }
        return arrCode;
    }


    private boolean textCheck(ArrayList<Character> arrCode) {
        return point(arrCode) && comma(arrCode) && exclamationMark(arrCode) && questionMark(arrCode);
    }


    private boolean point(ArrayList<Character> arrCode) {
        return (arrCode.contains('.') && (arrCode.get(arrCode.indexOf('.') + 1).equals(' ') || arrCode.get(arrCode.indexOf('.') + 1).equals('.') || arrCode.get(arrCode.indexOf('.') + 2).equals('\n')));
    }

    private boolean comma(ArrayList<Character> arrCode) {
        return (arrCode.contains(',') && arrCode.get(arrCode.indexOf(',') + 1).equals(' '));
    }

    private boolean exclamationMark(ArrayList<Character> arrCode) {
        if (arrCode.contains('!')) {
            return (arrCode.get(arrCode.indexOf('!') + 1).equals(' ') || arrCode.get(arrCode.indexOf('!') + 2).equals('\n'));
        }
        return true;
    }

    private boolean questionMark(ArrayList<Character> arrCode) {
        if (arrCode.contains('?')) {
            return (arrCode.get(arrCode.indexOf('?') + 1).equals(' ') || arrCode.get(arrCode.indexOf('?') + 2).equals('\n'));
        }
        return true;
    }


}





