package com.example.sinhvienserver.service;

import com.example.sinhvienserver.VO.Khoa;
import com.example.sinhvienserver.VO.ResponseTemplateVO;
import com.example.sinhvienserver.entity.SinhVien;
import com.example.sinhvienserver.repository.SinhVienRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class SinhVienServiceImpl implements SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public SinhVien saveSinhVien(SinhVien sv) {
        sinhVienRepository.save(sv);
        return sv;
    }

    @Override
    public List<SinhVien> getSinhVien() {
        return (List<SinhVien>) sinhVienRepository.findAll();
    }

    @Override
    public long deleteSinhVien(Long id) {
        sinhVienRepository.deleteById(id);
        return id;
    }

    @Override
    public SinhVien updateSinhVien(Long id, SinhVien newSinhVien) {
        SinhVien sv = sinhVienRepository.findSinhViensById(id);
        if(sv != null && newSinhVien != null){
            sv.setFirstName(newSinhVien.getFirstName());
            sv.setLastName(newSinhVien.getLastName());
            sv.setPhoneNumber(newSinhVien.getPhoneNumber());
        }
        return sinhVienRepository.save(sv);
    }

    @Override
    @Retry(name = "basic")
    public ResponseTemplateVO getSinhVienWithKhoa(Long sinhvienID) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        SinhVien sinhVien = sinhVienRepository.findSinhViensById(sinhvienID);
        vo.setSinhVien(sinhVien);
        Khoa khoa =
                restTemplate.getForObject("http://localhost:9001/khoa/"
                                +sinhVien.getIdKhoa(),
                        Khoa.class);

        vo.setKhoa(khoa);

        return vo;
    }
}
