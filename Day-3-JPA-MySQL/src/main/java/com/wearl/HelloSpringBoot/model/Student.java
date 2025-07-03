/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wearl.HelloSpringBoot.model;

/**
 *
 * @author Saurabh
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String course;

    // Getters, Setters, Constructors
}
