package com.aliboucoding.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Section extends BaseEntity {

  private String name;

  private int sectionOrder;

  /**
   * 
   * For @ManyToOne, we need to use @JoinColumn to specify the foreign key column
   *  - name: the name of the foreign key column
   *  - referencedColumnName: the name of the primary key column of the referenced table, course_id
   * This is the owner-side of the relationship
   */
  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  @OneToMany(mappedBy = "section")
  private List<Lecture> lectures;
}
