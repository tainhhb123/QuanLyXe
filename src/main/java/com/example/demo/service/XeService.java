package com.example.demo.service;

import com.example.demo.dto.XeLichTrinhDTO;
import com.example.demo.model.LichTrinhXe;
import com.example.demo.model.Xe;
import com.example.demo.repository.LichTrinhXeRepository;
import com.example.demo.repository.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class XeService {
    @Autowired
    private XeRepository xeRepository;
    public Xe save (Xe xe) {
        return xeRepository.save(xe);
    }

    @Autowired
    private LichTrinhXeRepository lichTrinhXeRepository;

    public List<XeLichTrinhDTO> getAllXeWithLichTrinh(String keyword) {
        List<Xe> dsXe;
        if (keyword != null && !keyword.trim().isEmpty()) {
            dsXe = xeRepository.findByNhaXe_TenNhaXeContainingIgnoreCase(keyword.trim());
        } else {
            dsXe = xeRepository.findAll();
        }
        List<XeLichTrinhDTO> result = new ArrayList<>();
        for (Xe xe : dsXe) {
            List<LichTrinhXe> dsLichTrinh = lichTrinhXeRepository.findByXe_MaXe(xe.getMaXe());
            if (dsLichTrinh.isEmpty()) {
                XeLichTrinhDTO dto = new XeLichTrinhDTO();
                dto.setMaXe(xe.getMaXe());
                dto.setBienSo(xe.getBienSo());
                dto.setTenNhaXe(xe.getNhaXe().getTenNhaXe());
                result.add(dto);
            } else {
                for (LichTrinhXe lichTrinh : dsLichTrinh) {
                    XeLichTrinhDTO dto = new XeLichTrinhDTO();
                    dto.setMaXe(xe.getMaXe());
                    dto.setBienSo(xe.getBienSo());
                    dto.setTenNhaXe(xe.getNhaXe().getTenNhaXe());
                    dto.setTenTaiXe(lichTrinh.getTenTaiXe());
                    dto.setMaTuyen(lichTrinh.getTuyenXe().getMaTuyen());
                    dto.setTenTuyen(lichTrinh.getTuyenXe().getTenTuyen());
                    dto.setNgayXuatBen(lichTrinh.getId().getNgayXuatBen());
                    dto.setGioXuatBen(lichTrinh.getId().getGioXuatBen());
                    result.add(dto);
                }
            }
        }
        return result;
    }

}
