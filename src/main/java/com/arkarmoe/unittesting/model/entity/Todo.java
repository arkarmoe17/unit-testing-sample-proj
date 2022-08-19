package com.arkarmoe.unittesting.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    @Id
    String id;
    String task;
    boolean isFinished;
}
