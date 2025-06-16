package com.de.fhswf.orm.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;

    private String lastname;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToMany
    @JoinTable(
            name = "child_hobby",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private List<Hobby> hobbies = new ArrayList<>();

}
