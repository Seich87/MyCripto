import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //метод по выбору режима шифрования();
        //метод по визуализации(); будет возращать при нажатии на кнопку путь к файлу
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


