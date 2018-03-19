package homework5.task2;


public class EmoticonText implements Text {

    private final String content;

    public EmoticonText(String message) {
        content = checkMessage(message);
    }

    private String checkMessage(String message) {
        if (message.equalsIgnoreCase("winking-face")) return "\ud83d\ude09";
        else if (message.equalsIgnoreCase("smiling-face")) return "\ud83d\ude0a";
        else if (message.equalsIgnoreCase("relieved-face")) return "\ud83d\ude0c";
        else if (message.equalsIgnoreCase("neutral-face")) return "\ud83d\ude10";
        else throw new IllegalArgumentException("There is no " + message + " smile in base");
    }

    public String getText() {
        return content;
    }
}
