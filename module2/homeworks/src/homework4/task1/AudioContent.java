package homework4.task1;

import java.util.Arrays;

public class AudioContent {

    private final byte[] content;

    public AudioContent(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "AudioContent{" +
                "content=" + Arrays.toString(content) +
                '}';
    }
}
