package lab1.filewriter;

import com.sun.istack.internal.NotNull;

public abstract class Decorator extends AbstractFileWriter{
    protected AbstractFileWriter fileWriter;

    public Decorator(){}

    public Decorator(@NotNull String fileName){
        super(fileName);
    }

    public void decorate(@NotNull AbstractFileWriter fileWriter){
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(@NotNull String text) {
        fileWriter.write(text);
    }
}
