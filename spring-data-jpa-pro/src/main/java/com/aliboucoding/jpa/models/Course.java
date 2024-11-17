package com.aliboucoding.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity {

  private String title;

  private String description;

  /** 
   * Courses is the owner-side of the relation, where we will need @JoinTable 
   * Author is the inverse-side of the relation, where we will not need @JoinTable
   * This will create a join table named 'authors_courses' with the columns 'course_id' and 'author_id'
   * The @JsonIgnore annotation is used to prevent infinite recursion when serializing/deserializing the entities
   * */
  @JsonIgnore
  @ManyToMany
  @JoinTable(
      name = "authors_courses",
      joinColumns = {
          @JoinColumn(name = "course_id")
      },
      inverseJoinColumns = {
          @JoinColumn(name = "author_id")
      }
  )
  private List<Author> authors;

  // This is not the owner side of this relation
  @OneToMany(mappedBy = "course")
  private List<Section> sections;

}
