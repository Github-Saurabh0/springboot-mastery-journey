/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wearl.HelloSpringBoot.exception;

/**
 *
 * @author Saurabh
 */

//public class StudentNotFoundException extends ResourceNotFoundException {
//    public StudentNotFoundException(String message) {
//        super(message);
//    }
//}

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
