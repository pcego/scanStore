/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.Company;
import br.com.kpc.drugstore.core.IRepositoryCompany;
import javax.persistence.Query;
import javax.swing.JOptionPane;

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

        try {
            Query query = getManager().createQuery("SELECT CM.System_key FROM Company CM");
            return (String) query.getSingleResult();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Falha ao Carregar Chave Licença",
                    "Ihh Falhou...!!", JOptionPane.ERROR_MESSAGE, null);
            return null;
        }
    }

    @Override
    public Company getCompany() {

        try {
            Query query = getManager().createQuery("SELECT CM FROM Company CM");
            return (Company) query.getSingleResult();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Falha ao Carregar Dados da Empresa",
                    "Ihh Falhou...!!", JOptionPane.ERROR_MESSAGE, null);
            return null;

        }
    }
}
