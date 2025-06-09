package com.example.demo.repository;

import com.example.demo.model.NhaXe;
import com.example.demo.model.Xe;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface NhaXeRepository extends JpaRepository<NhaXe, String> {

}
