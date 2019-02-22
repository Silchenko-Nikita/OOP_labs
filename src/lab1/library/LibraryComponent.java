package lab1.library;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class LibraryComponent {
    protected String name;
    protected String type;
    protected String code;

    public LibraryComponent(@NotNull String type){
        this.type = type;
    }

    public LibraryComponent(@NotNull String type, String name){
        this(type);
        this.name = name;
    }

    public void display(){
        display(0);
    }

    public abstract void add(LibraryComponent c);
    public abstract int countLeafs();
    public abstract int countLeafsNames();
    protected abstract HashSet<String> getLeafsNames();
    public abstract void remove(LibraryComponent c);
    protected abstract void display(int depth);
}

