package lab1.library;

import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.HashSet;

public class Book extends LibraryComponent{
    private static HashSet<String> codes = new HashSet<String>();

    public Book(@NotNull String code, @NotNull String name) {
        super("Book", name);

        if (codes.contains(code)){
            throw new IllegalArgumentException("Code must be unique");
        }

        this.code = code;
        codes.add(code);
    }

    @Override
    public int countLeafs() {
        return 1;
    }

    @Override
    public int countLeafsNames() {
        throw new NotImplementedException();
    }

    @Override
    protected HashSet<String> getLeafsNames() {
        HashSet<String> names = new HashSet<String>();
        names.add(name);
        return names;
    }

    @Override
    public void add(LibraryComponent c) {
        throw new NotImplementedException();
    }

    @Override
    public void remove(LibraryComponent c) {
        throw new NotImplementedException();
    }

    @Override
    protected void display(int depth) {
        StringBuilder offsetBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            offsetBuilder.append("  ");
        }

        System.out.println(offsetBuilder + "type: " + type + ", name: " + name + ", code: " + code);
    }
}
