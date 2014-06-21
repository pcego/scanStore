/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.dao;

import br.com.kpc.validator.core.IRepositoryKeyComputer;
import br.com.kpc.validator.core.KeyComputer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author pcego
 */
@Stateless
public class KeyComputerDao extends GenericDao<KeyComputer> implements IRepositoryKeyComputer {

    public KeyComputerDao() {
        super(KeyComputer.class);
    }

    @Override
    public KeyComputer lastKeyOfComputer(String hdNumber) {

        try {

            Query query = getManager().createQuery("select k from KeyComputer k where "
                    + "k.computer.hdNumber = :hdNumber and k.id = "
                    + "(select MAX(kc.id) from KeyComputer kc where kc.computer.hdNumber = :hdNumber");
            query.setParameter("hdNumber", hdNumber);
            return (KeyComputer) query.getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<KeyComputer> listAllKeysByComputer(String hdNumber) {

        try {

            Query query = getManager().createQuery("select k from KeyComputer k where k.computer.hdNumber = :hdNumber");
            query.setParameter("hdNumber", hdNumber);
            return query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
