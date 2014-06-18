/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.dao;

import br.com.kpc.validator.core.Computer;
import br.com.kpc.validator.core.IRepositoryComputer;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author pcego
 */
@Stateless
public class ComputerDao extends GenericDao<Computer> implements IRepositoryComputer {

    public ComputerDao() {
        super(Computer.class);
    }

    @Override
    public List<Computer> listByClient(String cpfCnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
