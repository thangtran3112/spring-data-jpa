package com.aliboucoding.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // used this so the child class can create builder from parent properties
@MappedSuperclass // any entity extends this @MappedSuperclass class, will inherit all the fields
public class BaseEntity {

  /* Create specific sequence:
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "author_sequence"
  )
  @SequenceGenerator(
    name = "author_sequence",
    sequenceName = "author_sequence",
    allocationSize = 1
  )*/
  /* Create sequence with a table for each entity, there will be 'author' : 0 in the table, to keep track of id
  @GeneratedValue(
    strategy = GenerationType.TABLE,
    generator = "author_id_gen"
  )
  @TableGenerator(
    name = "author_id_gen",
    table = "id_generator",
    pkColumnName = "id_name",
    valueColumnName = "id_value",
    allocationSize = 1
  )*/
  @Id
  @GeneratedValue
  private Integer id;

  @Column(
    updatable = false,
    nullable = false
  )
  private LocalDateTime createdAt;

//   @Column(insertable = false)
  private LocalDateTime lastModifiedAt;

  private String createdBy;
  private String lastModifiedBy;
}
