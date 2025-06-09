package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LichTrinhXeId implements Serializable {
    private String maXe;
    private String ngayXuatBen;
    private String gioXuatBen;
}
