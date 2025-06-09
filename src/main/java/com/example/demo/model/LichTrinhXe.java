package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "lichtrinhxe")
@NoArgsConstructor
@AllArgsConstructor
public class LichTrinhXe {
    @EmbeddedId
    private LichTrinhXeId id;

    @ManyToOne
    @JoinColumn(name = "maXe" ,  insertable = false, updatable = false)
    private Xe xe;

    private String tenTaiXe;

    @ManyToOne
    @JoinColumn(name = "maTuyen")
    private TuyenXe tuyenXe;

    private Integer soLuongHanhKhach;



}
