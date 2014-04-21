/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.IRepositoryTicket;
import br.com.kpc.drugstore.core.Ticket;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Pcego
 */
public class DaoTicket extends DaoGeneric<Ticket> implements IRepositoryTicket {

    public DaoTicket() {
        super(Ticket.class);
    }

    @Override
    public List<Ticket> listTicketByClient(Client obj) {

        Query query = getManager().createQuery("SELECT T FROM Ticket T "
                + "JOIN Recipe R ON T.recipe.id = R.id "
                + "JOIN Client C ON R.client.id = C.id WHERE C.cpf = :obj");
        query.setParameter("obj", obj.getCpf());
        return query.getResultList();
    }

    @Override
    public Ticket getLastShopByClient(String cpf, boolean active) {
            
        Query query = getManager().createQuery("SELECT T FROM Ticket T "
                + "JOIN Recipe R ON T.recipe = R.id "
                + "JOIN Client C ON R.client = C.id "
                + "WHERE C.cpf = :cpf AND C.active = :active "
                + "AND T.id = (SELECT MAX(T.id) FROM Ticket T WHERE  C.cpf = :cpf AND C.active = :active)"
                + "GROUP BY C.cpf");
        
        query.setParameter("cpf", cpf);
        query.setParameter("active", active);
        
        return (Ticket) query.getSingleResult();
    }
}
