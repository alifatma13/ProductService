package com.productservice.inheritencerelations.tableperclass;

import com.productservice.inheritencerelations.tableperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User {
    private double avgRating;
}
