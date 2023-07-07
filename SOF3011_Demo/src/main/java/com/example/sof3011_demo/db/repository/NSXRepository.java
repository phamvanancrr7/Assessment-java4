package com.example.sof3011_demo.db.repository;


import com.example.sof3011_demo.db.entity.NSX;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class NSXRepository {
    public static List<NSX> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NSX", NSX.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NSX getByID(UUID id) {
        NSX nsx = new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            nsx = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean add(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean update(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(NSX nsx) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        List<NSX> list = new NSXRepository().getAll();
        for (NSX cv : list) {
            System.out.println(cv.toString());
        }
    }
}
