import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing {
   private int num;
    private static String value;


    static void frame() {
    JFrame frame1 = new JFrame();
        frame1.setBounds(100, 100, 600, 500);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setLayout(new BoxLayout(frame1.getContentPane(), BoxLayout.Y_AXIS));

        JLabel jLabel1 = new JLabel("Внесите в строку ниже действие: Шифрование / Расшифровка / Метод Brute force");
        JTextArea textArea1 = new JTextArea();

        JButton jButton1 = new JButton("Выбрать");

        frame1.add(jLabel1);
        frame1.add(textArea1);
        frame1.add(jButton1);
        frame1.setVisible(true);


        MyCallBack myCallBack = new MyCallBack();

        jButton1.addActionListener(new MyActionListener(myCallBack));



        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea1.getText().equalsIgnoreCase("Шифрование")) {

                    frame1.setVisible(false);





                } else if (textArea1.getText().equalsIgnoreCase("Расшифровка")) {
                    int num = 2;

                } else if (textArea1.getText().equalsIgnoreCase("Метод Brute force")) {
                    int num = 3;
                } else  {
                    System.out.println("Внесены неверные данные");
                }
            }
        });
    }


    public static class MyActionListener implements ActionListener {
        private MyCallBack myCallBack;

        public MyActionListener(MyCallBack myCallBack) {
            this.myCallBack = myCallBack;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            String text = "Hi";
            myCallBack.setResult(text);
        }
    }

    public static class MyCallBack {

        public void setResult(String result) {
            value = result;
        }
    }

    /*JFrame frame2 = new JFrame("CRYPTANALIZER");




        frame2.setBounds(100, 100, 600, 500);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame2.setLayout(new BoxLayout(frame2.getContentPane(), BoxLayout.Y_AXIS));

    JLabel jLabel2 = new JLabel("Выбран режим шифрования" +
            "");
    JLabel jLabel3 = new JLabel("Введите ключ шифрования");
    JTextArea textArea2 = new JTextArea();
    JLabel jLabel4 = new JLabel("Введите путь к текстовому файлу с исходным текстом");
    JTextArea textArea3 = new JTextArea();


    JButton jButton2 = new JButton("Выбрать");

        frame2.add(jLabel2);
        frame2.add(jLabel3);
        frame2.add(textArea2);
        frame2.add(jLabel4);
        frame2.add(textArea3);


        frame2.add(jButton2);

        jButton1.addActionListener(new ActionListener() {
*/




}

