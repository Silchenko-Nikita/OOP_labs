package lab5.texteditor;

import com.sun.istack.internal.NotNull;

abstract class Action {
    protected static String serializationDelimiter = ",";

    abstract String perform(@NotNull String text);
//    abstract String performOpposite(@NotNull String text);
    abstract String serialize();
    abstract Action deserialize(@NotNull String string);

    static Action deserializeAction(@NotNull String string){
        String[] parts = string.split(serializationDelimiter,  2);
        String type = parts[0];

        if (type.equals(RemoveAction.typeMark)){
            return new RemoveAction(string);
        }else if(type.equals(InsertAction.typeMark)){
            return new InsertAction(string);
        }
        return null;
    }
}
