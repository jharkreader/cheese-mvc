package org.launchcode.cheesemvc.models;

public class Cheese {

    private String cheeseName;
    private String cheeseDescription;
    private int cheeseId;
    private static int nextId = 1;


    public Cheese(String cheeseName, String cheeseDescription) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
    }

    public Cheese(String cheeseName) {
        this(cheeseName, "");
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String aCheeseName) {
        cheeseName = aCheeseName;
    }

    public String getCheeseDescription() {
        return cheeseDescription;
    }

    public void setCheeseDescription(String aCheeseDescription) {
        cheeseDescription = aCheeseDescription;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

}
