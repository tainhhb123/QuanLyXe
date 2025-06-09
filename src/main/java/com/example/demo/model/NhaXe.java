package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table (name = "nhaxe")
@NoArgsConstructor
@AllArgsConstructor

public class NhaXe {
    @Id
    private String maNhaXe;
    private String tenNhaXe;
    private Integer namThanhLap;
}
