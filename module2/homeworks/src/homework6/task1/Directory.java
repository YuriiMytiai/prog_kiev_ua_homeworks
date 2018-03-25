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
            String itemStr = curItem.toString();
            String itemStrWithTabs = removeEnd(withLeadingTabs(itemStr));
            text.append(itemStrWithTabs);
        }

        String fs = removeEnd(text.toString());
        return fs;
    }

    private String removeEnd(String s) {
        for (int i = s.length() - 1; i > 0; i--) {
            char c= s.charAt(i);
            if ((s.charAt(i) != 9) && (s.charAt(i) != 10)) return s.substring(0, (i + 1)) + "\n";
        }
        return s;
    }

    private String withLeadingTabs(String itemStr) {
        String[] parts = itemStr.split("\n");
        StringBuilder newItemStr = new StringBuilder("\t");
        for (String part:parts) {
            newItemStr.append(part);
            newItemStr.append("\n\t");
        }

        return newItemStr.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return Objects.equals(items, directory.items);
    }

}
