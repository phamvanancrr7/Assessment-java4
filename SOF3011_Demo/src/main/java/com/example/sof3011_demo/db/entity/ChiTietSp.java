package com.example.sof3011_demo.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietSP")
@Entity
public class ChiTietSp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "NamBH")
    private int namBh;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "GiaNhap")
    private double giaNhap;
    @Column(name = "GiaBan")
    private double giaBan;


}
