import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = selectionMode();

        if (num == 1) {
            Encryption encr = new Encryption();
            encr.encryptionToFile(encr.getPath(), encr.getKey());

        } else if (num == 2) {
            Decoding dec = new Decoding();
            dec.decodingToFile(dec.getPath(), dec.getKey());

        } else if (num == 3) {
            BruteForce brForce = new BruteForce();
            brForce.bruteForce();
        }
        //класс и метод по визуализации(); будет возращать при нажатии на кнопку путь к файлу (внутри будет метод,
        // на который мы будем ссылаться отсюда: Path path = метод() или сделать тут int и Path, а внутри метода геттер и сеттер)


    }

    private static int selectionMode() {

       int num;
        while (true) {
            try {
                System.out.println("Выберете действие: Шифрование (1) / Расшифровка (2) / Метод Brute force (3)");
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
                if (num == 1) {
                    System.out.println("Выбран режим шифрования");
                    break;
                } else if (num == 2) {
                    System.out.println("Выбран режим расшифровки");
                    break;
                } else if (num == 3) {
                    System.out.println("Выбран метод Brute force");
                    break;

                } else {
                    System.out.println("Введи 1, 2 или 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введи 1, 2 или 3");
            }
        }
        return num;
    }
}


