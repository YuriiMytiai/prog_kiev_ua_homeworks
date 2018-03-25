package homework6.task1;

import java.util.ArrayList;

public class Symlink implements FSItem {

    private String symlinkName;
    private final FSItem item;

    public Symlink(String symlinkName, FSItem item) {
        this.symlinkName = symlinkName;
        this.item = item;
    }


    @Override
    public String getName() {
        return symlinkName + " -> " + item.getName();
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public ArrayList<FSItem> getItems() {
        return null;
    }

    @Override
    public String toString() {
        return "Symlink " + symlinkName + " " + item ;
    }
}
