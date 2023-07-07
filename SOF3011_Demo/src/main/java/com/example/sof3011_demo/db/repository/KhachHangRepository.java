package com.example.sof3011_demo.db.repository;


import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    // thuc hien truy van
    public List<KhachHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM KhachHang", KhachHang.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang getById(UUID id) {
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            //            Query query = session.createQuery("from KhachHang where id =: id");
            //            query.setParameter("id", id);
            //            khachHang= (KhachHang) query.getSingleResult();
            khachHang = session.get(KhachHang.class, id);

        } catch (Exception e) {

        }
        return khachHang;
    }

    public Boolean add(KhachHang khachHang) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
    public Boolean delete(KhachHang khachHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }


    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().getAll();
        for (KhachHang kh : list) {
            System.out.println(kh.toString());
        }
    }
}
