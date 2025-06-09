package com.example.demo.repository;

import com.example.demo.model.LichTrinhXe;
import com.example.demo.model.LichTrinhXeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichTrinhXeRepository extends JpaRepository<LichTrinhXe, LichTrinhXeId> {
}
