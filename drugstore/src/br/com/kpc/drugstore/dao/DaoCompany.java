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
    public String getLicenceKey() {

        Query query = getManager().createQuery("SELECT CM.System_key FROM Company CM");
        return (String) query.getSingleResult();
    }

    @Override
    public Company getCompany() {

        Query query = getManager().createQuery("SELECT CM FROM Company CM");
        return (Company) query.getSingleResult();
    }
}
