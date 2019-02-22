package lab1.filewriter;

import com.sun.istack.internal.NotNull;

public class TextTrimmer extends Decorator {

    @Override
    public void write(@NotNull String text) {
        String trimmedText = text.trim();
        super.write(trimmedText);
    }
}
