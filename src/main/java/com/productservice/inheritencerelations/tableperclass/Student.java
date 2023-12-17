package com.productservice.inheritencerelations.tableperclass;

import com.productservice.inheritencerelations.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_student")
public class Student extends User {
    private double psp;
}