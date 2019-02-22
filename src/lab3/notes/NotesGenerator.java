package lab3.notes;

import com.sun.istack.internal.NotNull;

// Singleton
public class NotesGenerator {
    private int freshmanNotesGenerated = 0;
    private int masterNotesGenerated = 0;
    private int generalNotesGenerated = 0;

    public int getFreshmanNotesGenerated() {
        return freshmanNotesGenerated;
    }

    public int getMasterNotesGenerated() {
        return masterNotesGenerated;
    }

    public int getGeneralNotesGenerated() {
        return generalNotesGenerated;
    }

    public static NotesGenerator getInstance() {

        if (instance == null){
            instance = new NotesGenerator();
        }

        return instance;
    }

    private static NotesGenerator instance;



    public StudentNotes generateNotes(@NotNull StudentType studentType){
        StudentNotes notes;
        switch (studentType){
            case MASTER:
                notes = new MasterNotes();
                masterNotesGenerated++;
                break;
            case FRESHMAN:
                notes = new FreshmanNotes();
                freshmanNotesGenerated++;
                break;
            default:
                notes = new GeneralNotes();
                generalNotesGenerated++;
                break;
        }
        return notes;
    }
}
