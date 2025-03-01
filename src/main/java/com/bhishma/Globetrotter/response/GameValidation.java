package com.bhishma.Globetrotter.response;

import java.util.List;

public class GameValidation {
    private boolean isValid;
    private String text;


    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
