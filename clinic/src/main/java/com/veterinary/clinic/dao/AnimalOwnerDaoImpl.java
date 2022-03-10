package com.veterinary.clinic.dao;

import com.veterinary.clinic.entity.AnimalOwner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AnimalOwnerDaoImpl implements AnimalOwnerDao {
    private SessionFactory sessionFactory;

    public AnimalOwnerDaoImpl(){}

    public AnimalOwnerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public AnimalOwner save(AnimalOwner animalOwner) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.save(animalOwner);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory.close();
        }

        //TODO: return object from db
        return animalOwner;
    }

    @Override
    public AnimalOwner findByPhone(String phone) {
        AnimalOwner animalOwner = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            String hql = "FROM AnimalOwner a WHERE a.phone = :phone";
            Query query = session.createQuery(hql);
            query.setParameter("phone", phone);

            animalOwner = (AnimalOwner) query.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory.close();
        }

        return animalOwner;
    }

    @Override
    public AnimalOwner findById(long id) {
        AnimalOwner animalOwner = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            String hql = "FROM AnimalOwner a WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);

            animalOwner = (AnimalOwner) query.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory.close();
        }

        return animalOwner;
    }

    @Override
    public AnimalOwner update(AnimalOwner animalOwner) {
        AnimalOwner o = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            o = session.get(AnimalOwner.class, animalOwner.getId());

            o.setFirstName(animalOwner.getFirstName());
            o.setLastName(animalOwner.getLastName());
            o.setPatronymic(animalOwner.getPatronymic());
            o.setEmail(animalOwner.getEmail());
            o.setPhone(animalOwner.getPhone());

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory.close();
        }

        return o;
    }

    @Override
    public String delete(long id) {
        return null;
    }

    @Override
    public List<AnimalOwner> findAll() {
        return null;
    }
}
