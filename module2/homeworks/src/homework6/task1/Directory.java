package homework6.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory extends NamedFSItem {

    private final List<FSItem> items = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public Directory add(FSItem item) {
        checkRecursion(item);
        items.add(item);
        return this;
    }

    private void checkRecursion(FSItem item) {
        ArrayList<FSItem> items = item.getItems();
        if ((items == null) || items.isEmpty()) return;
        for (FSItem curItem:items) {
            if (curItem.equals(this)) throw new IllegalArgumentException("Illegal folders recursion");
        }
    }

    public ArrayList<FSItem> getItems() {
        return (ArrayList<FSItem>) items;
    }

    @Override
    public int getSize() {
        int sumSize = 0;
        for (FSItem curItem:items) {
            sumSize += curItem.getSize();
        }

        return sumSize;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("/" + getName());
        text.append("\n");

        for (FSItem curItem:items) {
            text.append("\t");
            text.append(curItem.toString());
            text.append("\n");
        }

        return text.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(items, directory.items);
    }

}
