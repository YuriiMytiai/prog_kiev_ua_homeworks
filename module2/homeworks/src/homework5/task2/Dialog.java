package homework5.task2;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Dialog {
    private final ArrayList<Message> dialogHistory = new ArrayList();

    public void addMessge(Message message) { dialogHistory.add(message); }

    @Override
    public String toString() {

        StringBuilder text = new StringBuilder("Dialog:\n\n");
        for (Message curMessage:dialogHistory) {
            text.append(curMessage.getAuthor());
            text.append(" at " + curMessage.getDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " :\n");
            text.append(curMessage.getContent().getText());
            text.append("\n\n");
        }

        return text.toString();
    }
}
