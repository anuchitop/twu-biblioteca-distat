package main.java.com.twu;

public class Account {
    private String name;
    private String libraryID;
    private String password;

    public Account(String name, String libraryID, String password) {
        this.setName(name);
        this.setLibraryID(libraryID);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(String libraryID) {
        this.libraryID = libraryID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
