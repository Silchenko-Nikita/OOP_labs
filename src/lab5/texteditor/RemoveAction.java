package lab5.texteditor;

import com.sun.istack.internal.NotNull;

class RemoveAction extends Action{
    protected int length;
    protected int pos;
    final static protected String typeMark = "r";

    RemoveAction(int pos, int length){
        this.pos = pos;
        this.length = length;
    }

    RemoveAction(@NotNull String serialized){
        deserialize(serialized);
    }

    @Override
    String perform(@NotNull String text) {
        return new StringBuilder(text).replace(pos, pos + length, "").toString();
    }

    @Override
    String serialize() {
        return String.join(serializationDelimiter, typeMark, Integer.toString(pos), Integer.toString(length));
    }

    @Override
    Action deserialize(@NotNull String string) {
        String[] parts = string.split(serializationDelimiter, 3);
        pos = Integer.parseInt(parts[1]);
        length = Integer.parseInt(parts[2]);
        return this;
    }
}
