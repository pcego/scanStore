/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.kpc.validator.core;

import java.util.List;

/**
 *
 * @author pcego
 */
public interface IRepositoryClientKpc extends IRepository<ClientKpc>{
    
    List<ClientKpc> listAll();
    ClientKpc getClient(String cpfCnpj);
}
