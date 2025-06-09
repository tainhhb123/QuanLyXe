package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "loaixe")
@NoArgsConstructor
@AllArgsConstructor

public class LoaiXe {
    @Id
    private String maLoaiXe;
    private String moTaLoaiXe;
    private Integer soLuongChoNgoi;
}
