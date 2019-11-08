package com.clay4seed.demo_.GraphQL.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Kneotrino
 * @date 08/11/19
 */
@Data
@EqualsAndHashCode
@Entity
public class Vehicle implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "model_code", nullable = false)
  private String modelCode;

  @Column(name = "brand_name")
  private String brandName;

  @Column(name = "launch_date")
  private Long launchDate;

  private transient String formattedDate;

  // Getter and setter
  public String getFormattedDate() {
    return getLaunchDate().toString();
  }
}
