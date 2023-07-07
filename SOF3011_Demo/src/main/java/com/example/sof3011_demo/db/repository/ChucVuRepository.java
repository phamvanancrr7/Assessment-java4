package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.ChucVu;

import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    // thuc hien truy van
    public List<ChucVu> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu", ChucVu.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ChucVu getByid(UUID id) {
        ChucVu chucVu = new ChucVu();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            chucVu = session.get(ChucVu.class, id);
        } catch (Exception e) {
        }
        return chucVu;

    }

    public Boolean add(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public static void main(String[] args) {
        List<ChucVu> list = new ChucVuRepository().getAll();
        for (ChucVu cv : list) {
            System.out.println(cv.toString());
        }
    }
}
