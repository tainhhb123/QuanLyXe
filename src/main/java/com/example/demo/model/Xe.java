package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "xe")
@NoArgsConstructor
@AllArgsConstructor

public class Xe {
    @Id
    private String maXe;
    private String hangSanXuat;
    private String bienSo;
    private LocalDate hanKiemDinh;

    @ManyToOne
    @JoinColumn (name = "maLoaiXe")
    private LoaiXe loaiXe;

    @ManyToOne
    @JoinColumn(name = "maNhaXe")
    private NhaXe nhaXe;
}
