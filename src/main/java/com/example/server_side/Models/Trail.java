package com.example.server_side.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TRAILS_TBL")
public class Trail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String src;
    @Lob
    private String description;
    @Lob
    private String moreInfo;
    @Lob
    private String howToCome;
    @Lob
    private String waysInTrail;

    // הרבה טיולים יכולים להצביע על האדם הזה
    // במסד יהיה רק הקוד שלו
    // ידע לשלוף את המשתמש כולו לפי הקוד JPA-ה
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
