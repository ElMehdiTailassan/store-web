package com.mycompany.dvdstore.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class MovieForm {

    private Long id;

    @NotBlank
    @Size(max = 20, message = "Entrez un titre de 20 caractères au plus")
    private String title;

    @NotBlank(message = "Veuillez entrer un genre")
    private String genre;

    @Size(max = 255,message = "Entrez une description de 255 caractères au plus")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
