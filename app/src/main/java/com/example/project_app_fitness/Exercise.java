package com.example.project_app_fitness;

public class Exercise {
    private String dataTitle;
    private int dataDesc;
    private String dataLang;
    private int dataImage;

    public Exercise(String dataTitle, int dataDesc, String dataLang, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public String getDataLang() {
        return dataLang;
    }

    public int getDataImage() {
        return dataImage;
    }
}

// DataClassEx now inherits from Exercise