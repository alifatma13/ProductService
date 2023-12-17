package com.productservice.inheritencerelations.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joined_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    private double psp;
}
