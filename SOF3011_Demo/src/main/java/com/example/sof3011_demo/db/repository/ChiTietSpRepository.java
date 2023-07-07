package com.example.sof3011_demo.db.repository;

import com.example.sof3011_demo.db.entity.ChiTietSp;
import com.example.sof3011_demo.db.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class ChiTietSpRepository {


    public List<ChiTietSp> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSp", ChiTietSp.class);
            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }

    public ChiTietSp getByID(UUID id) {
        ChiTietSp chiTietSp = new ChiTietSp();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            chiTietSp = session.get(ChiTietSp.class, id);


        } catch (Exception e) {


        }
        return chiTietSp;
    }

    public Boolean add(ChiTietSp chiTietSp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(ChiTietSp chiTietSp) {

        Transaction transaction = null;
        try (Session session=HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(chiTietSp);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
public Boolean delete(ChiTietSp chiTietSp){
        Transaction transaction=null;
        try(Session session =HibernateUtil.getFACTORY().openSession()){
            transaction =session.beginTransaction();
            session.delete(chiTietSp);
            transaction.commit();
            return true;

        }catch (Exception e){
            return false;
        }
}

    public static void main(String[] args) {
        new ChiTietSpRepository().getAll().forEach(s-> System.out.println(s));
    }
}
