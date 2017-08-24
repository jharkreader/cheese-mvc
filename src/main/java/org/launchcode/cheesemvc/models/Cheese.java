package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=3, max=15, message = "Cheese name must be between 3 and 13 letters.")
    private String cheeseName;

    @NotNull
    @Size(min=1, message = "Please include a description.")
    private String cheeseDescription;

    @NotNull
    @Pattern(regexp="[1-5]", message = "Rate cheese from 1 (worst) to 5 (best)")
    private String cheeseRating;

    private CheeseType cheeseType;

    private int cheeseId;
    private static int nextId = 1;


    public Cheese(String cheeseName, String cheeseDescription, String cheeseRating) {
        this();
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
        this.cheeseRating = cheeseRating;
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

    public CheeseType getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }

    public String getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(String cheeseRating) {
        this.cheeseRating = cheeseRating;
    }
}
