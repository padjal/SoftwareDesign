package model;

import annotations.Exported;

import java.util.ArrayList;
import java.util.List;

@Exported
public class TestClass {
    int a = 4;
    double b = 4.5;
    String name = "pavel";
    List<Preference> prefs = List.of(new Preference("hey there"), new Preference("lalala"));
    Preference pref = new Preference("hheyyy jtest");
}
