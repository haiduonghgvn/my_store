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
@Table(name = "userProfile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "address",columnDefinition = "text")
    private String address;

    @Column(name = "phone",length = 11)
    private int phone;

    @Column(name = "status")
    private boolean status;

    @OneToOne(mappedBy = "userProfile")
    private Users users;

}
