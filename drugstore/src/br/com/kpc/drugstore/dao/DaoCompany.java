/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.Company;
import br.com.kpc.drugstore.core.IRepositoryCompany;
import javax.persistence.Query;

/**
 *
 * @author Pcego
 */
public class DaoCompany extends DaoGeneric<Company> implements IRepositoryCompany {

    public DaoCompany() {
        super(Company.class);
    }

    
    @Override
    public boolean validateLicenceKey(String key) {

        Query query = getManager().createQuery("");

        if (true) {
            //implementar validação; ????????
        }
        return true;
    }

    @Override
    public Company getCompany() {
        
        Query query = getManager().createQuery("SELECT cm FROM Company cm");
        return (Company) query.getSingleResult();
    }
}
