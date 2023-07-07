package com.example.sof3011_demo.db.repository;



import com.example.sof3011_demo.db.entity.MauSac;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    public static List<MauSac> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac",MauSac.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public MauSac getByID(UUID id) {
        MauSac mauSac = new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            mauSac = session.get(MauSac.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    public Boolean add(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean update(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(MauSac mauSac) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        List<MauSac> list = new MauSacRepository().getAll();
        for (MauSac cv : list) {
            System.out.println(cv.toString());
        }
    }
}
