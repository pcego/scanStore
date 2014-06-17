/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.dao;

import br.com.kpc.validator.core.IRepositoryKeyComputer;
import br.com.kpc.validator.core.KeyComputer;
import java.util.List;

/**
 *
 * @author pcego
 */
public class KeyComputerDao extends GenericDao<KeyComputer> implements IRepositoryKeyComputer {

    public KeyComputerDao() {
        super(KeyComputer.class);
    }

    @Override
    public KeyComputer lastKeyOfComputer(String hdNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<KeyComputer> listAllKeysByComputer(String hdNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
