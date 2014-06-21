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
import javax.persistence.Query;

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

        try {

            Query query = getManager().createQuery("select cp from Computer cp where cp.client.cpf_Cnpj = :cpf_Cnpj");
            query.setParameter("cpf_Cnpj", cpfCnpj);
            return query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Computer getComputerByhdNumber(String hdNumber) {

        try {

            Query query = getManager().createQuery("select cp from Computer cp where cp.hdNumber = :hdNumber");
            query.setParameter("hdNumber", hdNumber);
            return (Computer) query.getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
