package com.aliboucoding.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true) // equals and hashcode will consider parent properties as well, when callSuper=true
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // used this so the child class can create builder from parent properties
@Entity
@NamedQueries(  // use for optimizing performance, or for complex logics, alternative is CriteriaQuery
    {
        @NamedQuery(
            name = "Author.findByNamedQuery",
            query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
            name = "Author.updateByNamedQuery",
            query = "update Author a set a.age = :age"
        )
    }
)
public class Author extends BaseEntity {

    /*
    @Column(
        name = "f_name",
        length = 50
    ) */
    private String firstName;

    private String lastName;

    @Column(
        unique = true,
        nullable = false
    )
    private String email;

    private int age;

    /**
     * mappedBy = "authors" means that the "authors" field in the Course class is the Owner of the relationship
     * fetch = FetchType.EAGER means that the courses will be loaded eagerly
     */
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Course> courses;

}
