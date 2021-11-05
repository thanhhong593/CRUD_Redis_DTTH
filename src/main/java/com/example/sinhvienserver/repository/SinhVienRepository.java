package com.example.sinhvienserver.repository;

import com.example.sinhvienserver.entity.SinhVien;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhVienRepository extends CrudRepository<SinhVien,Long> {
    List<SinhVien> findSinhViensByLastName(String lastName);
    SinhVien findSinhViensById(Long id);
}
