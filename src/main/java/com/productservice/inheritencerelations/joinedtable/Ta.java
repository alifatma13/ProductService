package com.productservice.inheritencerelations.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joined_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class Ta extends User {
    private String ta_session;
}
