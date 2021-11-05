package com.example.sinhvienserver.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_sinhvien")
public class SinhVien implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Long idKhoa;
}
