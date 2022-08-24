package com.arkarmoe.unittesting.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_id")
    private String accountId;

    @ManyToOne
    @JsonIgnore
    private Employee employee;

    public Account(String accountId, Employee employee) {
        this.accountId = accountId;
        this.employee = employee;
    }
}
