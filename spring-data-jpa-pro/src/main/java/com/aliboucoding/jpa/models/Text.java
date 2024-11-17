package com.aliboucoding.jpa.models;

import jakarta.persistence.Entity;
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
// @DiscriminatorValue("T")  //this is only used in Inheritance.SINGLE_TABLE, to identify rows, which belongs to Text
public class Text extends Resource {

  private String content;
}
