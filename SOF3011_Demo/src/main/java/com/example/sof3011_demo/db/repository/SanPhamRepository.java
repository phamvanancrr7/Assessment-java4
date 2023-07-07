package com.example.sof3011_demo.db.repository;



import com.example.sof3011_demo.db.entity.SanPham;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    public static List<SanPham> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham",SanPham.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public SanPham getByID(UUID id) {
        SanPham sanPham = new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            sanPham = session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        List<SanPham> list = new SanPhamRepository().getAll();
        for (SanPham cv : list) {
            System.out.println(cv.toString());
        }
    }
}
