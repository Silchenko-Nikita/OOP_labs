package lab1.filewriter;

import com.sun.istack.internal.NotNull;

abstract class AbstractFileWriter {
    protected String fileName;

    public AbstractFileWriter(){}

    public AbstractFileWriter(@NotNull String fileName){
        this.fileName = fileName;
    }

    public abstract void write(@NotNull String text);
}
