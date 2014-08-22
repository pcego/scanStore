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
    
    List<Client> listAll(boolean active); 
    List<Client> listClientWithNearShop();
    Client getClientByCpf(String cpf, boolean active);
    List<Client> listClientByBirthday();
    List<Client> listClientByName(String name, boolean active);
    List<Client> listClientByCity(String city, boolean active);
    int clientRecipeValid(Date lastRecipe);    
    
}
