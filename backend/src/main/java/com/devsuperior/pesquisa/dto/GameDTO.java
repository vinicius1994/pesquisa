package com.devsuperior.pesquisa.dto;

import com.devsuperior.pesquisa.entities.Game;
import com.devsuperior.pesquisa.entities.enums.Platform;

import java.io.Serializable;

public class GameDTO implements Serializable {

    private Long id;
    private String title;
    private Platform platform;

    public GameDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
    public GameDTO(Game entity){
        id = entity.getId();
        title = entity.getTitle();
        platform = entity.getPlatform();
    }
}
