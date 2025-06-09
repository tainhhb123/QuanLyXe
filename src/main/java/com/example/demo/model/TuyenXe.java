package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="tuyenxe")
@AllArgsConstructor
@NoArgsConstructor

public class TuyenXe {
    @Id
    private String maTuyen;
    private String tenTuyen;
    private Double donGia;
}
