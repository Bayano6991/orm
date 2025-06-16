package com.de.fhswf.orm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Child> children = new ArrayList<>();




}
