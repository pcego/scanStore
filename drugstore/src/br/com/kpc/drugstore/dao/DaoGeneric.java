/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.IRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pcego
 */
public class DaoGeneric<T> implements IRepository<T> {

    private Class type;

    @PersistenceContext(unitName = "drugstorePU")
    protected EntityManager manager;

    protected EntityManagerFactory factory;

    protected EntityTransaction tran;

    public DaoGeneric(Class type) {

        this.type = type;

        factory = Persistence.createEntityManagerFactory("drugstorePU");

        manager = factory.createEntityManager();

        tran = manager.getTransaction();
    }

    protected EntityManager getManager() {

        return manager;
    }

    @Override
    public T abrir(T obj) throws Exception {
        try {
            return (T) getManager().find(type, obj);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean salvar(Object obj) {

        try {
            tran.begin();
            getManager().persist(obj);
            getManager().flush();
            tran.commit();
            return true;
        } catch (Exception e) {
            tran.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean apagar(Object obj) {

        try {
            tran.begin();
            getManager().remove(obj);
            getManager().flush();
            tran.commit();
            return true;
        } catch (Exception e) {
            tran.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Object obj) {

        try {
            tran.begin();
            getManager().merge(obj);
            getManager().flush();
            tran.commit();
            return true;
        } catch (Exception e) {
            tran.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
