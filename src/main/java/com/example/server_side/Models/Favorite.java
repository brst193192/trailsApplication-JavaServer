package com.example.server_side.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FAVORITE_TRAILS_TBL")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // הרבה מועדפים יכולים להצביע על הטיול הזה
    // במסד יהיה רק הקוד שלו
    // ידע לשלוף את הטיול כולו לפי הקוד JPA-ה
    @ManyToOne
    @JoinColumn(name = "trail_id")
    private Trail trail;

    // הרבה מועדפים יכולים להצביע על המשתמש הזה
    // במסד יהיה רק הקוד שלו
    // ידע לשלוף את המשתמש כולו לפי הקוד JPA-ה
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
