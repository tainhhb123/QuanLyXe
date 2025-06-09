package com.example.demo.controller;

import com.example.demo.dto.XeLichTrinhDTO;
import com.example.demo.model.LichTrinhXe;
import com.example.demo.model.LichTrinhXeId;
import com.example.demo.model.TuyenXe;
import com.example.demo.model.Xe;
import com.example.demo.repository.*;
import com.example.demo.service.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/xe")
public class XeController {
    @Autowired
    private XeService xeService;
    @Autowired
    private LoaiXeRepository loaiXeRepository;
    @Autowired
    private NhaXeRepository nhaXeRepository;

    @Autowired
    private XeRepository xeRepository;

    @Autowired
    private LichTrinhXeRepository lichTrinhXeRepository;

    @Autowired
    private TuyenXeRepository tuyenXeRepository;

    // Hiển thị form nhập xe
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("xe", new Xe());
        model.addAttribute("dsLoaiXe", loaiXeRepository.findAll());
        model.addAttribute("dsNhaXe", nhaXeRepository.findAll());
        return "xecreate";
    }

    // Xử lý lưu xe
    @PostMapping("/create")
    public String createXe(@ModelAttribute("xe") Xe xe, BindingResult result, Model model) {
        // Validate hạn kiểm định ở phía server
        if (xe.getHanKiemDinh() != null) {
            LocalDate now = LocalDate.now();
            if (!xe.getHanKiemDinh().isAfter(now.plusMonths(1))) {
                result.rejectValue("hanKiemDinh", "error.xe",
                        "Hạn kiểm định không đúng, hạn kiểm định phải lớn hơn thời gian hiện tại ít nhất 1 tháng, xin hãy nhập lại thông tin hạn kiểm định.");
            }
        }
        if (result.hasErrors()) {
            model.addAttribute("dsLoaiXe", loaiXeRepository.findAll());
            model.addAttribute("dsNhaXe", nhaXeRepository.findAll());
            return "xecreate";
        }

        xeService.save(xe);
        return "redirect:/xe/create";
    }
//chức năng 2
    @GetMapping("/list")
    public String listXeWithLichTrinh(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model
    ) {
        List<XeLichTrinhDTO> list = xeService.getAllXeWithLichTrinh(keyword);
        model.addAttribute("listXe", list);
        model.addAttribute("keyword", keyword);
        return "xe-list";
    }



//    // Màn hình danh sách lịch trình của 1 xe
//    @GetMapping("/lichtrinh")
//    public String listLichTrinhOfXe(@RequestParam("maXe") String maXe, Model model) {
//        List<LichTrinhXe> dsLichTrinh = lichTrinhXeRepository.findByXe_MaXe(maXe);
//        Xe xe = xeRepository.findById(maXe).orElse(null);
//        // KHẮC PHỤC: Nếu dsLichTrinh null thì gán bằng list rỗng
//        if (dsLichTrinh == null) dsLichTrinh = new ArrayList<>();
//        model.addAttribute("dsLichTrinh", dsLichTrinh);
//        model.addAttribute("xe", xe);
//        return "xe-lichtrinh-list";
//    }

    // Hiển thị form nhập lịch trình
    @GetMapping("/lichtrinh/add")
    public String showAddLichTrinhForm(@RequestParam("maXe") String maXe, Model model) {
        LichTrinhXe lichTrinhXe = new LichTrinhXe();
        // Khởi tạo key rỗng để Thymeleaf binding được
        lichTrinhXe.setId(new LichTrinhXeId());
        model.addAttribute("lichTrinhXe", lichTrinhXe);
        model.addAttribute("maXe", maXe);
        model.addAttribute("dsTuyenXe", tuyenXeRepository.findAll());
        return "lichtrinh-add";
    }

    // Xử lý lưu lịch trình
    @PostMapping("/lichtrinh/add")
    public String addLichTrinhXe(
            @ModelAttribute("lichTrinhXe") LichTrinhXe lichTrinhXe,
            @RequestParam("maXe") String maXe,
            @RequestParam("tuyenXe.maTuyen") String maTuyen
    ) {
        // Set composite key
        LichTrinhXeId id = new LichTrinhXeId();
        id.setMaXe(maXe);
        id.setNgayXuatBen(lichTrinhXe.getId().getNgayXuatBen());
        id.setGioXuatBen(lichTrinhXe.getId().getGioXuatBen());
        lichTrinhXe.setId(id);

        // Set xe
        Xe xe = xeRepository.findById(maXe).orElse(null);
        lichTrinhXe.setXe(xe);

        // Set tuyến
        TuyenXe tuyenXe = tuyenXeRepository.findById(maTuyen).orElse(null);
        lichTrinhXe.setTuyenXe(tuyenXe);

        // Lưu
        lichTrinhXeRepository.save(lichTrinhXe);

        // Quay lại list lịch trình xe
//        return "redirect:/xe/lichtrinh?maXe=" + maXe;
        return "redirect:/xe/list";
    }
}
