package homework5.task2;

import java.time.LocalDateTime;

public class Message {
    private final String author;
    private final LocalDateTime dateTime;
    private final Text content;

    public Message(String author, Text content) {
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.content = content;
    }

    public Text getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
