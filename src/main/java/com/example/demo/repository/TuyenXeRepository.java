package com.example.demo.repository;

import com.example.demo.model.TuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuyenXeRepository extends JpaRepository<TuyenXe, String> {
}
