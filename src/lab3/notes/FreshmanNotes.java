package lab3.notes;

class FreshmanNotes implements StudentNotes {
    public final String map = "----000----\n" +
                        "------000--\n" +
                        "---0-------\n";
    public final String[] universityPhones = {"0673255886", "0975886134"};
    public final String[] facultyPhones = {"0673251111", "0975882234"};
    public final String info = "blablabla";

    @Override
    public String getNotes() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Info:\n" + info + "\n");
        stringBuilder.append("Map:\n" + map);
        stringBuilder.append("University phones:\n");
        for (String phone: universityPhones){
            stringBuilder.append(phone).append("\n");
        }
        stringBuilder.append("Faculty phones:\n");
        for (String phone: facultyPhones){
            stringBuilder.append(phone).append("\n");
        }
        return stringBuilder.toString();
    }
}
