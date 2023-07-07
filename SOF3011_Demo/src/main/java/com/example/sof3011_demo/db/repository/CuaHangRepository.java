package com.example.sof3011_demo.db.repository;


import com.example.sof3011_demo.db.entity.CuaHang;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    // thuc hien truy van
    public static List<CuaHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang", CuaHang.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CuaHang getByID(UUID id) {
        CuaHang cuaHang = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            cuaHang = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }

    public Boolean add(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean update(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        List<CuaHang> list = new CuaHangRepository().getAll();
        for (CuaHang cv : list) {
            System.out.println(cv.toString());
        }
    }


}
