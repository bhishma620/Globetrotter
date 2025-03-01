package com.bhishma.Globetrotter.response;

import java.util.List;

public class LoadResponse {
    private Long id;
    private List<String> clues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getClues() {
        return clues;
    }

    public void setClues(List<String> clues) {
        this.clues = clues;
    }
}
