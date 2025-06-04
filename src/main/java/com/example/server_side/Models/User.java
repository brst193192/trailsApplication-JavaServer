package com.example.server_side.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS_TBL")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    
    // משתמש אחד ישתייך לכל הטיולים הללו
    // במסד - בקוד של הטיול יהיה רק הקוד משתמש שלו
    // ידע לשלוף למשתמש את כל הטיולים שלו JPA-ה
    @OneToMany(mappedBy = "user")
    private List<Trail> trails;

}
