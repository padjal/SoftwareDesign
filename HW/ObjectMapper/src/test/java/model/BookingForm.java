package model;

import annotations.Exported;

import java.util.List;

@Exported
public class BookingForm {
    private List<Guest> guests;

    public BookingForm(List<Guest> guests){
        this.guests = guests;
    }
}
