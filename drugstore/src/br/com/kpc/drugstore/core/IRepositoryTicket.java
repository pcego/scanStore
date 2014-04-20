/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

import java.util.List;

/**
 *
 * @author Pcego
 */
public interface IRepositoryTicket extends IRepository<Ticket> {

    List<Ticket> listTicketByClient(Client obj);
    
}
