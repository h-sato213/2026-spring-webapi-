package com.example.kakeboapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Kakebo {
    private long id;
    private String title;
    private long value;
    private LocalDateTime createdAt;
}
