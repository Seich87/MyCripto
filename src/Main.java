import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        selectionMode();

        //класс и метод по визуализации(); будет возращать при нажатии на кнопку путь к файлу (внутри будет метод,
        // на который мы будем ссылаться отсюда: Path path = метод() или сделать тут int и Path, а внутри метода геттер и сеттер)


    }

    private static void selectionMode() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введи номер режима: Шифрование (1) / Расшифровка (2)");
                int num = scanner.nextInt();
                if (num == 1) {
                    System.out.println("Выбран режим шифрования");
                    Encryption encr = new Encryption();
                    encr.encryption();
                    break;
                } else if (num == 2) {
                    System.out.println("Выбран режим расшифровки");
                    Decoding dec = new Decoding();
                    dec.decoding();
                    break;
                } else {
                    System.out.println("Введи 1 или 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введи 1 или 2");
            }
        }

    }
}


