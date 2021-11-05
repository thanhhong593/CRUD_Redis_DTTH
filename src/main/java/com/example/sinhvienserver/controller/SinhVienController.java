package com.example.sinhvienserver.controller;

import com.example.sinhvienserver.VO.ResponseTemplateVO;
import com.example.sinhvienserver.entity.SinhVien;
import com.example.sinhvienserver.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sinhvien")
public class SinhVienController {
    @Value("${hong}")
    private String welcome;

    @GetMapping("/home")
    public String home(){
        return welcome;
    }
    @Autowired
    private SinhVienService sinhVienService;


    @GetMapping("/")
    public List<SinhVien> getAllSinhVien(){
        return  sinhVienService.getSinhVien();
    }
    @PostMapping("/")
    public SinhVien insertSinhVien( @RequestBody SinhVien sv){
        return sinhVienService.saveSinhVien(sv);
    }
    @PostMapping("/{id}")
    public long deleteSinhVien( @PathVariable long id){
        return sinhVienService.deleteSinhVien(id);
    }
    @PutMapping("/{id}")
    public SinhVien updateSinhVien( @PathVariable("id") long id, @RequestBody SinhVien sv){
        return sinhVienService.updateSinhVien(id,sv);
    }
    @GetMapping("/sinhvienWithKhoa/{id}")
    public ResponseTemplateVO getSinhVienWithKhoa(@PathVariable("id")
                                                            Long sinhvienID){
        return sinhVienService.getSinhVienWithKhoa(sinhvienID);
    }
}
