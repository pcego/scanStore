/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.kpc.validator.dao;

import br.com.kpc.validator.core.ClientKpc;
import br.com.kpc.validator.core.IRepositoryClientKpc;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author pcego
 */
@Stateless
public class ClientKpcDao extends GenericDao<ClientKpc> implements IRepositoryClientKpc {

    public ClientKpcDao() {
        super(ClientKpc.class);
    }

    
    @Override
    public List<ClientKpc> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientKpc getClient(String cpfCnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
