package homework6.task1;

import java.util.ArrayList;

public class File extends NamedFSItem {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public ArrayList<FSItem> getItems() {
        return null;
    }

    @Override
    public String toString() {
        return getName() + ", " + size + " bytes";
    }
}
