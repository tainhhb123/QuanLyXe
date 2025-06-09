package com.example.demo.repository;

import com.example.demo.model.LichTrinhXe;
import com.example.demo.model.LichTrinhXeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichTrinhXeRepository extends JpaRepository<LichTrinhXe, LichTrinhXeId> {
    List<LichTrinhXe> findByXe_MaXe(String maXe);
}
