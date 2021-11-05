package com.example.sinhvienserver.service;

import com.example.sinhvienserver.VO.ResponseTemplateVO;
import com.example.sinhvienserver.entity.SinhVien;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SinhVienService {
    SinhVien saveSinhVien(SinhVien sv);
    List<SinhVien> getSinhVien();
    long deleteSinhVien(Long id);
    SinhVien updateSinhVien(Long id, SinhVien sv);
    ResponseTemplateVO getSinhVienWithKhoa(Long sinhvienID);

}
