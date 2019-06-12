package dao;

import ejb.dto.AbstractDTO;

import javax.persistence.*;
import java.util.List;

public abstract class AbstractDAO<T extends AbstractDTO>  {

    private String className;
    private Class clazz;

    protected AbstractDAO(Class clazz) {
        this.clazz = clazz;
        className = clazz.getSimpleName();
    }

    public List<T> getItems() {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Projekt");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List items = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            items = manager.createQuery("SELECT s FROM " + className + " s", clazz).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return items;
    }

    public T getItem(Integer itemId) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Projekt");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        T item = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            TypedQuery query = manager.createQuery("SELECT c FROM " + className + " c WHERE c.id = :id", clazz);
            query.setParameter("id", itemId);
            transaction.commit();
            item = (T) query.getSingleResult();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return item;
    }

    public boolean addItem(T item) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Projekt");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        } finally {
            manager.close();
        }
        return true;
    }

    public void updateItem(T item) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Projekt");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(item);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

    }

    public void deleteItem(Integer itemId) {
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Projekt");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            T itemToRemove = (T) manager.find(clazz, itemId);
            manager.remove(itemToRemove);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }
}