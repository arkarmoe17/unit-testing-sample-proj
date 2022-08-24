package com.arkarmoe.unittesting.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

//working ...
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(name = "employee_account",
//            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "id")})
//    @JsonIgnore
//    private Set<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Set<Account> accounts;
}
