package model;

import annotations.Exported;

@Exported
public class Preference {
    private String description;

    public Preference(String description){
        this.description = description;
    }

    public Preference(){
    }

    public void setDescription(String value){
        description = value;
    }
}
