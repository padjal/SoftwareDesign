package model;

import annotations.Exported;

import java.util.Set;

@Exported
public class Guest {
    private String name;
    private String test;
    private Set<Preference> preferences;

    public Guest(String name, Set<Preference> preferences){
        this.name = name;
        this.preferences = preferences;
        test = "234";
    }
}
