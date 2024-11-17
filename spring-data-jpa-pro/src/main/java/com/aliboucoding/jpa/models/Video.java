package com.aliboucoding.jpa.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// @PrimaryKeyJoinColumn(name = "video_id") only for Inheritance.JOINED, overwrite the default id column into video_id
// @DiscriminatorValue("V")  //this is only used in Inheritance.SINGLE_TABLE, to identify rows, which belongs to Text
@Polymorphism(type = PolymorphismType.EXPLICIT) // Inheritance.TABLE_PER_CLASS, when we query findAll() Resource, it will ignore results from Videos Table
public class Video extends Resource {

  private int length;

}
