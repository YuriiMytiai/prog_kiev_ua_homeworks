package homework6.task1;

import java.util.ArrayList;

public interface FSItem {

    String getName();

    int getSize();

    // we need this method to validate folders recursion
    ArrayList<FSItem> getItems();

}
