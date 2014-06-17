/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.dao;

import br.com.kpc.validator.core.IRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pcego
 */
public abstract class GenericDao<T> implements IRepository<T> {

    private Class type;
    @PersistenceContext(unitName = "validatorPU")
    protected EntityManager manager;

    protected EntityManager getManager() {
        return manager;
    }

    public GenericDao(Class type) {
        this.type = type;
    }

    @Override
    public T abrir(Long obj) throws Exception {

        return (T) getManager().find(type, obj);
    }

    @Override
    public boolean salvar(T obj) {

        try {
            getManager().persist(obj);
            getManager().flush();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean apagar(T obj) {

        try {
            getManager().remove(getManager().getReference(type, obj));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizar(T obj) {

        try {
            getManager().refresh(obj);
            getManager().flush();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
