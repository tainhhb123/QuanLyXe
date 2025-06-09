package com.example.demo.repository;

import com.example.demo.model.NhaXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXeRepository extends JpaRepository<NhaXe, String> {
}
