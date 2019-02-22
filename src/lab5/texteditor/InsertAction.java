package lab5.texteditor;

import com.sun.istack.internal.NotNull;

class InsertAction extends Action{
    protected String string;
    protected int pos;
    final static protected String typeMark = "i";

    InsertAction(@NotNull int pos, @NotNull String string){
        this.pos = pos;
        this.string = string;
    }

    InsertAction(@NotNull String serialized){
        deserialize(serialized);
    }

    @Override
    String perform(@NotNull String text) {
        return new StringBuilder(text).insert(pos, string).toString();
    }

    @Override
    String serialize() {
        return String.join(serializationDelimiter, typeMark, Integer.toString(pos), string);
    }

    @Override
    Action deserialize(@NotNull String string) {
        String[] parts = string.split(serializationDelimiter, 3);
        pos = Integer.parseInt(parts[1]);
        this.string = parts[2];
        return this;
    }
}
