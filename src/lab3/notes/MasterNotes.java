package lab3.notes;

class MasterNotes implements StudentNotes {
    public final String info = "dichdichdich";
    public final String articlesWritingRules = "ne plogiatit";
    public final String dissertationWritingRules = "ne plogiatit, novisna";

    @Override
    public String getNotes() {
        return ("Info:\n" + info + "\n") +
                "How to write articles:\n" + articlesWritingRules + "\n" +
                "How to write dissertation:\n" + dissertationWritingRules + "\n";
    }
}
