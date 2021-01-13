package com.example.chapter01;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Invitation {
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }
}
