import lab1.library.Book;
import lab1.library.Composite;
import lab2.election.Bulletin;
import lab2.election.BulletinFactory;
import lab3.usersclone.User;
import lab3.usersclone.UserCache;
import lab5.texteditor.TextEditor;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        1.1
        /*String testString = "   bla bla bla   ";
        FileWriter fileWriter = new FileWriter("output");
        Decorator textEncoder = new TextEncoder();
        Decorator textTrimmer = new TextTrimmer();
        Decorator textTrimmer1 = new TextTrimmer();

        textEncoder.decorate(fileWriter);
        textTrimmer.decorate(textEncoder);

        textTrimmer1.decorate(fileWriter);

        textTrimmer.write(testString);*/
//        textEncoder.write(testString);
//        textTrimmer1.write(testString);


//        1.2
//        Composite library = new Composite("library");
//
//        Composite department = new Composite("department");
//        library.add(department);
//
//        Composite rack1 = new Composite("rack", "detective");
//        Composite rack2 = new Composite("rack", "poetry");
//        department.add(rack1);
//        department.add(rack2);
//
//        Composite shelf11 = new Composite("shelf");
//        Composite shelf12 = new Composite("shelf");
//        rack1.add(shelf11);
//        rack1.add(shelf12);
//
//        Composite shelf21 = new Composite("shelf");
//        Composite shelf22 = new Composite("shelf");
//        rack2.add(shelf21);
//        rack2.add(shelf22);
//
//        shelf11.add(new Book("12", "a"));
//        shelf11.add(new Book("123", "b"));
//        shelf12.add(new Book("2123", "rqw"));
//        shelf12.add(new Book("22", "rqw"));
//        shelf12.add(new Book("24", "rd21w"));
//        shelf21.add(new Book("2dsadsa4", "rdw2121"));
//        shelf21.add(new Book("23124", "r2121dw"));
//        shelf22.add(new Book("323124", "rdw2121"));
//
//        library.display();
//
//        System.out.println();
//        rack1.display();
//
//        System.out.println();
//        System.out.println(library.countLeafs());
//        System.out.println(library.countLeafsNames());


//        2.1
        /*MessageSender basicMessageSender = new MessageSender();
        LimitingMessageSender limitingMessageSender = new LimitingMessageSender(1);
        User user1 = new User("Nikita", 0);
        User user2 = new User("Vasya", 1);
        User user3 = new User("Kolya", 2);
        User user4 = new User("Natasha", 3);

        limitingMessageSender.sendMessage(user1, "Воруй, убивай");
        limitingMessageSender.sendMessage(user2, "Воруй, убивай");

        try {
            limitingMessageSender.sendMessage(user3, "Воруй, убивай");
        } catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }

        try {
            limitingMessageSender.sendMessage(user4, "Воруй, убивай");
        } catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }

        System.out.println();

        basicMessageSender.sendMessage(user3, "Воруй, убивай");

        System.out.println();

        BulkMessageSender bulkMessageSender = new BulkMessageSender(limitingMessageSender);
        bulkMessageSender.addUser(user1);
        bulkMessageSender.addUser(user2);
        bulkMessageSender.addUser(user3);
        bulkMessageSender.addUser(user4);

        bulkMessageSender.sendMessage("Воруй, убивай");*/

//        2.2
        Bulletin bulletin = new BulletinFactory().getBulletin();
        String[] candidates = { "Poroshenko", "Tymoshenko", "Lashko", "Tigipko" };
        int[] votesNums = {0, 0, 0, 0};

        bulletin.display();
        Random random = new Random();
        for (int i = 1; i <= 12; i++) {
            int ind = random.nextInt(candidates.length);
            String candidate = candidates[ind];
            votesNums[ind]++;
            bulletin.displayVote(candidate, votesNums[ind]);
        }

//        3.1
//        NotesGenerator notesGenerator = NotesGenerator.getInstance();
//        int n = 4;
//        for (int i = 0; i < n; i++) {
//            StudentNotes notes = notesGenerator.generateNotes(StudentType.FRESHMAN);
//            System.out.println(notes.getNotes());
//            System.out.println();
//        }
//
//        for (int i = 0; i < n; i++) {
//            StudentNotes notes = notesGenerator.generateNotes(StudentType.MASTER);
//            System.out.println(notes.getNotes());
//            System.out.println();
//        }
//
//        System.out.println("freshman notes generated: " + notesGenerator.getFreshmanNotesGenerated());
//        System.out.println("master notes generated: " + notesGenerator.getMasterNotesGenerated());

//        3.2
//        UserCache.loadCache();
//        try {
//            User regularUser = null;
//            regularUser = UserCache.getUser("regular");
//            regularUser.displayInfo();
//
//            System.out.println();
//
//            User adminUser = null;
//            adminUser = UserCache.getUser("admin");
//            adminUser.displayInfo();
//        } catch (CloneNotSupportedException e) {
//            System.out.println(e);
//        }

//        4.1
        /*HashMap<String, Integer> ratingTable = new HashMap<>();
        ratingTable.put("Ivanov", 70);
        ratingTable.put("Petrov", 54);
        ratingTable.put("Ivasichkin", 90);
        ratingTable.put("Gribovko", 76);
        ratingTable.put("Kobza", 12);
        ratingTable.put("Tarasenko", 95);

        StudentsRating studentsRating = new StudentsRating(ratingTable);

        StudentsMarkRatingConverter marksConverter = new StudentsMarkRatingConverter();
        StudentsPassesRatingConverter passesConverter = new StudentsPassesRatingConverter();

        studentsRating.setRatingConverter(marksConverter);
        System.out.println(studentsRating.getConvertedRating());

        studentsRating.setRatingConverter(passesConverter);
        System.out.println(studentsRating.getConvertedRating());*/

//        4.2
        /*Cooker cooker = new Cooker();

        cooker.cook(new SoupRecipe());
        cooker.cook(new SaladRecipe());
        cooker.cook(new FryOperation(), new PepperOperation());*/

        TextEditor app = new TextEditor();
        app.setVisible(true);

//        5.2
        /*ProductionCenter productionCenter = new ProductionCenter();
        Actor actor1 = new Actor("Vasya");
        Actor actor2 = new Actor("Petya");
        Actor actor3 = new Actor("Vanya");
        Actor actor4 = new Actor("Kolya");
        Actor actor5 = new Actor("Anna");
        Actor actor6 = new Actor("Larysa");

        productionCenter.addActor(actor1);
        productionCenter.addActor(actor2);
        productionCenter.addActor(actor3);
        productionCenter.addActor(actor4);
        productionCenter.addActor(actor5);
        productionCenter.addActor(actor6);

        Place place1 = new Place("palats sportu");
        Place place2 = new Place("maydan nezalezhnosty");

        productionCenter.addPlace(place1);
        productionCenter.addPlace(place2);

        Client client1 = new Client("client1");
        Client client2 = new Client("client2");

        productionCenter.addClient(client1);
        productionCenter.addClient(client2);

        client1.orderPerformance("palats sportu","Vasya", "Petya", "Vanya");
        System.out.println();
        client2.orderPerformance("maydan nezalezhnosty","Anna", "Larysa", "Petya", "Vanya");*/
    }
}
