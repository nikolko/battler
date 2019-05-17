package ru.cft.aml.seabattler.data.entity;

import javax.persistence.*;


@Entity
@Table(name =  "CELLS")
public class Cell {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    private Integer x;

    private Integer y;

    private Boolean self;

    private Boolean damaged;


    private Long shipId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean getSelf() {
        return self;
    }

    public void setSelf(Boolean self) {
        this.self = self;
    }

    public Boolean getDamaged() {
        return damaged;
    }

    public void setDamaged(Boolean damaged) {
        this.damaged = damaged;
    }
}
