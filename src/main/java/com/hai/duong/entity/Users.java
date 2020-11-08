package com.hai.duong.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="username",length = 16)
    private String username;

    @Column(name = "password",columnDefinition = "text")
    private String password;

    @Column(name = "roles")
    private String roles;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userProfileId",referencedColumnName = "id")
    private UserProfile userProfile;
}
