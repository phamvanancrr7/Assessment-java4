package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.NhanVien;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NhanVien",NhanVien.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public NhanVien getByID(UUID id) {
        NhanVien nhanVien= new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nhanVien = session.get(NhanVien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public Boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        List<NhanVien> list = new NhanVienRepository().getAll();
        for (NhanVien nv : list) {
            System.out.println(nv.toString());
        }
    }
}
