package com.GnadigFisher.MileStoneJPA.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class MileStoneEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private long teacherId;

    private Date date;
    private String name;
    private String comment;
    private boolean active;

    protected MileStoneEntity(){}

    public MileStoneEntity(long teacherId, Date date, String name, String comment) {
        this.teacherId = teacherId;
        this.date = date;
        this.name = name;
        this.comment = comment;
        this.active = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MileStoneEntity that = (MileStoneEntity) o;
        return id == that.id &&
                teacherId == that.teacherId &&
                active == that.active &&
                Objects.equals(date, that.date) &&
                Objects.equals(name, that.name) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherId, date, name, comment, active);
    }
}
