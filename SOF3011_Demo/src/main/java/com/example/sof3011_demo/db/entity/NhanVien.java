package com.example.sof3011_demo.db.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table (name = "NhanVien")
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
   
    @Column (name = "Ma")
    private String ma;
    @Column (name = "Ten")
    private String ten ;
    @Column (name = "TenDem")
    private String tenDem;
    @Column (name = "Ho")
    private String ho;
    @Column (name = "GioiTinh")
    private String gioiTinh;
    @Column (name = "NgaySinh")
    private Date ngaySinh;
    @Column (name = "DiaChi")
    private String diaChi;
    @Column (name = "Sdt")
    private String sdt;
    @Column (name = "MatKhau")
    private String matKhau;
    @Column (name = "TrangThai")
    private int trangThai;







}
