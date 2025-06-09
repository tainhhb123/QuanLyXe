package com.example.demo.repository;

import com.example.demo.model.Xe;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XeRepository extends JpaRepository<Xe, String> {
    List<Xe> findByNhaXe_TenNhaXeContainingIgnoreCase(String keyword);

    List<Xe> findByNhaXe_MaNhaXe(String nhaXeMaNhaXe);
}
