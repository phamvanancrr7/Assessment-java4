package com.example.sof3011_demo.db.repository;


import com.example.sof3011_demo.db.entity.DongSp;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class DongSpRepository {
    public static List<DongSp> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM DongSp", DongSp.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DongSp getByID(UUID id) {
        DongSp dongSp = new DongSp();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            dongSp = session.get(DongSp.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSp;
    }

    public Boolean add(DongSp dongSp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(dongSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean update(DongSp dongSp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(DongSp dongSp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        List<DongSp> list = new DongSpRepository().getAll();
        for (DongSp cv : list) {
            System.out.println(cv.toString());
        }
    }
}
