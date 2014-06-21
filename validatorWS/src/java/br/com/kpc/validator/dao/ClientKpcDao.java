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
import javax.persistence.Query;

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

        try {

            Query query = getManager().createQuery("select cl from ClientKpc cl order by cl.name");
            return query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ClientKpc getClient(String cpfCnpj) {

        try {

            Query query = getManager().createQuery("select cl from ClientKpc cl where cl.cpf_Cnpj = :cpf_Cnpj");
            query.setParameter("cpf_Cnpj", cpfCnpj);
            return (ClientKpc) query.getSingleResult();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
