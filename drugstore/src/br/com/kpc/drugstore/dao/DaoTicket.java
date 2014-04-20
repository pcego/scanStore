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

        Query query = getManager().createQuery("");
        return query.getResultList();
    }
}
