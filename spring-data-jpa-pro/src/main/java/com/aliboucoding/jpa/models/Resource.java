package com.aliboucoding.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * This class will be extended by other entities, so it is not extended from BaseEntity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// @Inheritance(strategy = InheritanceType.JOINED) Separate tables, but with resource_id as foreign key to Resource Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Note: when findAll() for Resource, it will return all rows from sub-class tables
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "resource_type") --> only with InheritanceType.SINGLE_TABLE
// @DiscriminatorColumn will tell, what type of resource, within a single table for Text/Video/File
public class Resource {

  @Id
  @GeneratedValue
  private Integer id;
  private String name;
  private int size;
  private String url;

  @OneToOne
  @JoinColumn(name = "lecture_id")
  private Lecture lecture;
}
