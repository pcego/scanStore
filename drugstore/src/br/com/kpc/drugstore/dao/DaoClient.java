/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.IRepositoryClient;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Pcego
 */
public class DaoClient extends DaoGeneric<Client> implements IRepositoryClient {

    public DaoClient() {
        super(Client.class);

    }

    @Override
    public List<Client> listAll(boolean active) {

        try {
            Query query = getManager().createQuery("SELECT C FROM Client C WHERE "
                    + "C.active = :active ORDER BY C.name");
            query.setParameter("active", active);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public Client getClientByCpf(String cpf, boolean active) {

        try {

            Query query = getManager().createQuery("SELECT C FROM Client C WHERE "
                    + "C.cpf = :cpf AND C.active = :active ORDER BY C.name");
            query.setParameter("cpf", cpf);
            query.setParameter("active", active);
            return (Client) query.getSingleResult();

        } catch (NoResultException nrex) {
            return new Client("", "", "");
        }
    }

    @Override
    public List<Client> listClientByBirthday() {

        final String stQuery = "SELECT C FROM clients C "
                + "WHERE MONTH(C.DT_NASC) = MONTH(CURDATE()) "
                + "AND DAY(C.DT_NASC) = DAY(CURDATE()) ORDER BY C.NAME;";

        try {
            Query query = getManager().createNativeQuery(stQuery, Client.class
            );
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Client> listClientByName(String name, boolean active) {

        try {
            Query query = getManager().createQuery("SELECT C FROM Client C WHERE"
                    + " C.name LIKE :name AND C.active = :active ORDER BY C.name");
            query.setParameter("name", name);
            query.setParameter("active", active);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Client> listClientByCity(String city, boolean active) {

        try {
            Query query = getManager().createQuery("SELECT C FROM Client C WHERE C.adress_city LIKE :city "
                    + "AND C.active = :active GROUP BY C.adress_city ORDER BY C.name");
            query.setParameter("city", city);
            query.setParameter("active", active);
            return query.getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public int clientRecipeValid(Date lastRecipe) {

        final String strQuery = "SELECT DATEDIFF(CURDATE()," + lastRecipe + ");";

        try {
            Query query = getManager().createNativeQuery(strQuery);
            return query.getFirstResult();
        } catch (Exception ex) {
            return -1;
        }
    }

}
