package homework6.task1;

import java.util.ArrayList;

public abstract class NamedFSItem implements FSItem {

    private String name;

    public NamedFSItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
