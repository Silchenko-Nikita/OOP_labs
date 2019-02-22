package lab3.usersclone;

public class User implements Cloneable{
    private String login;
    private String password;
    private String name;
    private int age;
    private boolean isAdmin;
    private String city;
    private String fontStyle;
    private String pageColor;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public void setPageColor(String pageColor) {
        this.pageColor = pageColor;
    }

    public void displayInfo(){
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Admin: " + isAdmin);
        System.out.println("City : " + city);
        System.out.println("Font style: " + fontStyle);
        System.out.println("Page color: " + pageColor);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
