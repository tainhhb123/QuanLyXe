package com.example.demo.service;

import com.example.demo.dto.NhaXeThuNhapDTO;
import com.example.demo.model.LichTrinhXe;
import com.example.demo.model.NhaXe;
import com.example.demo.model.Xe;
import com.example.demo.repository.LichTrinhXeRepository;
import com.example.demo.repository.NhaXeRepository;
import com.example.demo.repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NhaXeService {
    @Autowired
    private NhaXeRepository nhaXeRepository;
    @Autowired
    private XeRepository xeRepository;
    @Autowired
    private LichTrinhXeRepository lichTrinhXeRepository;

    public List<NhaXeThuNhapDTO> getBangTongThuNhapNhaXe() {
        List<NhaXeThuNhapDTO> result = new ArrayList<>();
        List<NhaXe> dsNhaXe = nhaXeRepository.findAll();
        for (NhaXe nhaXe : dsNhaXe) {
            // Lấy tất cả xe của nhà xe này
            List<Xe> dsXe = xeRepository.findByNhaXe_MaNhaXe(nhaXe.getMaNhaXe());
            double tong = 0.0;
            for (Xe xe : dsXe) {
                // Lấy tất cả lịch trình của xe này
                List<LichTrinhXe> lichTrinhs = lichTrinhXeRepository.findByXe_MaXe(xe.getMaXe());
                for (LichTrinhXe lt : lichTrinhs) {
                    if (lt.getTuyenXe() != null && lt.getSoLuongHanhKhach() != null) {
                        tong += lt.getTuyenXe().getDonGia() * lt.getSoLuongHanhKhach();
                    }
                }
            }
            result.add(new NhaXeThuNhapDTO(nhaXe.getMaNhaXe(), nhaXe.getTenNhaXe(), tong));
        }
        return result;
    }
}

