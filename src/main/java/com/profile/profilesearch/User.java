package com.profile.profilesearch;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or AUTO
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String ssn;
    private String phone;
    private String username;
}
