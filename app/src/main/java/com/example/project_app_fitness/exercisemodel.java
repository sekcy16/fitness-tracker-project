package com.example.project_app_fitness;

public class exercisemodel {
    String exercisename;

    public String getDescription() {
        return description;
    }

    String description;
    int image;

    public exercisemodel(String exercisename, int image, String description) {
        this.exercisename = exercisename;
        this.image = image;
        this.description = description;
    }
    public String getExercisename() {
        return exercisename;
    }

    public int getImage() {
        return image;
    }
}
