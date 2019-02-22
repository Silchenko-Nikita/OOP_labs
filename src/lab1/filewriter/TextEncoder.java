package lab1.filewriter;

import com.sun.istack.internal.NotNull;

import java.util.Base64;

public class TextEncoder extends Decorator{

    @Override
    public void write(@NotNull String text) {
        String encoded = new String(Base64.getEncoder().encode(text.getBytes()));
        super.write(encoded);
    }
}
