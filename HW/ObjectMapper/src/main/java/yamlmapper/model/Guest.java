package yamlmapper.model;

import homework4.annotations.Exported;

import java.util.Set;

@Exported
public class Guest {
    private String name;
    private Set<Preference> preferences;
}
