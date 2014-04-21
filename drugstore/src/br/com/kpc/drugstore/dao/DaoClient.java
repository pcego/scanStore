/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.IRepositoryClient;
import br.com.kpc.drugstore.core.Ticket;
import java.util.Date;
import java.util.List;
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
    public List<Client> listAll() {
               
        Query query = getManager().createQuery("SELECT C FROM Client C");
        return query.getResultList();
    }

    @Override
    public Ticket getLastShopByClient(Client obj) {

        Query query = getManager().createQuery("");
        return (Ticket) query.getSingleResult();
    }

    @Override
    public Client getClientByCpf(String cpf) {

        Query query = getManager().createQuery("");
        return (Client) query.getSingleResult();
    }

    @Override
    public List<Client> listClientByBirthday(Date currentDate) {

        Query query = getManager().createQuery("");
        return query.getResultList();
    }

    @Override
    public List<Client> listClientByName(String name) {

        Query query = getManager().createQuery("");
        return query.getResultList();
    }

    @Override
    public List<Client> listClientByCity(String city) {

        Query query = getManager().createQuery("");
        return query.getResultList();
    }

    @Override
    public List<Client> listClientWithNearShop(Date currentDate) {
        
        Query query = getManager().createQuery("");
        return query.getResultList();
    }
}
