package br.com.tiagooliveira.heroesofmarvel.model;

public class Hero {
    private String name;
    private String description;
    private String image = "http://freepngimg.com/download/megaman/20003-5-megaman.png";

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
