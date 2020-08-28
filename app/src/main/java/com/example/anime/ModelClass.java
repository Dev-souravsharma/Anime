package com.example.anime;

public class ModelClass {
    String image;
    String headline, studio, category;

    public ModelClass() {

    }

    public ModelClass(String image, String headline, String studio, String category) {
        this.image = image;
        this.headline = headline;
        this.studio = studio;
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public String getHeadline() {
        return headline;
    }

    public String getStudio() {
        return studio;
    }

    public String getCategory() {
        return category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
