/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Pcego
 */
public interface IRepositoryClient extends IRepository<Client>{
    
    List<Client> listAll();
    Ticket getLastShopByClient(Client obj);
    Client getClientByCpf(String cpf);
    List<Client> listClientByBirthday(Date currentDate);
    List<Client> listClientByName(String name);
    List<Client> listClientByCity(String city);
    List<Client> listClientWithNearShop(Date currentDate);   
    
}
