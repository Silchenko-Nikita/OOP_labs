package lab5.texteditor;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


class ActionLogger {
    ArrayList<Action> actions = new ArrayList<>();
    String logFileName = ".log";
    FileWriter logWriter;

    ActionLogger(){
        try {
            deserialize();
            logWriter = new FileWriter(logFileName, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserialize(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(logFileName));
            String line;
            while ((line = br.readLine()) != null){
                Action action = Action.deserializeAction(line);
                actions.add(action);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String recover(String text){
        for(Action action: actions) {
            text = action.perform(text);
        }
        return text;
    }

    public void clear(){
        actions.clear();
        try {
            logWriter.close();
            logWriter = new FileWriter(logFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAction(@NotNull Action action){
        actions.add(action);
        serializeAction(action);
    }

    private void serializeAction(@NotNull Action action){
        try {
            logWriter.write(action.serialize());
            logWriter.write('\n');
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serializeAllActions(){
        for(Action action: actions) {
            serializeAction(action);
        }
    }
}
