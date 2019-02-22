package lab3.usersclone;

import java.util.HashMap;

public class UserCache {
    private static HashMap<String, User> usersMap = new HashMap<>();

    public static User getUser(String userType) throws CloneNotSupportedException{
        if (!usersMap.containsKey(userType)){
            throw new IllegalArgumentException("No such userType hashed");
        }
        return (User) usersMap.get(userType).clone();
    }

    public static void loadCache(){
        User regularUser = new User();
        regularUser.setLogin("login");
        regularUser.setPassword("password");
        regularUser.setName("User");
        regularUser.setAge(21);
        regularUser.setAdmin(false);
        regularUser.setCity("London");
        regularUser.setFontStyle("basic");
        regularUser.setPageColor("blue");

        User adminUser = new User();
        adminUser.setLogin("admin");
        adminUser.setPassword("password");
        adminUser.setName("Admin");
        adminUser.setAge(21);
        adminUser.setAdmin(true);
        adminUser.setCity("London");
        adminUser.setFontStyle("bold");
        adminUser.setPageColor("black");

        usersMap.put("regular", regularUser);
        usersMap.put("admin", adminUser);
    }
}
