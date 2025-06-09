package com.example.demo.controller;

import com.example.demo.dto.NhaXeThuNhapDTO;
import com.example.demo.service.NhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/thunhap")
public class ThuNhapController {
    @Autowired
    private NhaXeService nhaXeService;

    @GetMapping("/danhsach")
    public String bangThuNhap(Model model) {
        List<NhaXeThuNhapDTO> dsThuNhap = nhaXeService.getBangTongThuNhapNhaXe();
        model.addAttribute("dsThuNhap", dsThuNhap);
        return "thunhap-nhaxe-list";
    }
}

