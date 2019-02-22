package lab3.notes;

class GeneralNotes implements StudentNotes{
    public final String info = "dichdichdich";

    @Override
    public String getNotes() {
        return ("Info:\n" + info + "\n");
    }
}
