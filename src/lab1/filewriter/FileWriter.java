package lab1.filewriter;

import com.sun.istack.internal.NotNull;

import java.io.IOException;

public class FileWriter extends AbstractFileWriter{

    public FileWriter(@NotNull String fileName){
        super(fileName);
    }

    @Override
    public void write(@NotNull String text) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)){
            writer.write(text);

            writer.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
