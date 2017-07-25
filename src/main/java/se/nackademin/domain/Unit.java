package se.nackademin.domain;

import javax.persistence.*;

@Entity
public class Unit {

    @Id
    @GeneratedValue
    private long id;
    @Basic
    @Column(unique = true)
    private String name;

    public Unit() {
    }

    public Unit(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
