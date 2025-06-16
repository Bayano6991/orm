package com.de.fhswf.orm.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

}
