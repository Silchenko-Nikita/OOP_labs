package lab1.library;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashSet;

public class Composite extends LibraryComponent {
    private ArrayList<LibraryComponent> children = new ArrayList<LibraryComponent>();

    public Composite(@NotNull String type) {
        super(type);
    }

    public Composite(@NotNull String type, String name) {
        super(type, name);
    }

    @Override
    public void add(@NotNull LibraryComponent c) {
        children.add(c);
    }

    @Override
    public int countLeafs() {
        int num = 0;
        for (LibraryComponent component: children) {
            num += component.countLeafs();
        }
        return num;
    }

    @Override
    public int countLeafsNames() {
        return getLeafsNames().size();
    }

    @Override
    protected HashSet<String> getLeafsNames() {
        HashSet<String> names = new HashSet<String>();

        for (LibraryComponent component: children) {
            names.addAll(component.getLeafsNames());
        }
        return names;
    }

    @Override
    public void remove(@NotNull LibraryComponent c) {
        children.remove(c);
    }

    @Override
    protected void display(int depth) {
        StringBuilder offsetBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            offsetBuilder.append("  ");
        }

        System.out.println(offsetBuilder + "type: " + type + (name != null ? (", name: " + name): ""));
        for (LibraryComponent component: children) {
            component.display(depth + 1);
        }
    }
}
