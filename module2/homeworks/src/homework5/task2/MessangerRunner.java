package homework5.task2;

public class MessangerRunner {
    public static void main(String[] args) {
        Dialog dialog = new Dialog();

        Message m1 = new Message("Ivan", new PlainText("Hello!"));
        dialog.addMessge(m1);

        Message m2 = new Message("Vasiliy", new EmoticonText("smiling-face"));
        dialog.addMessge(m2);

        Message m3 = new Message("Ivan", new PlainText("How are you?"));
        dialog.addMessge(m3);

        Message m4 = new Message("Vasiliy", new PictureText("like"));
        dialog.addMessge(m4);

        System.out.println(dialog);
    }
}
