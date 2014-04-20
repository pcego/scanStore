/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.test;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.Company;
import br.com.kpc.drugstore.core.IRepositoryClient;
import br.com.kpc.drugstore.dao.DaoClient;
import br.com.kpc.drugstore.dao.DaoGeneric;
import java.util.Calendar;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Dino
 */
public class testBd {

    public static void main(String[] args) throws NamingException {

        Calendar c = Calendar.getInstance();
        Client cl = new Client();
        Company cm = new Company();
        cm.setSystem_key("rsrwrwrwrwrsrsrsrarararar");
        cm.setId(1L);
        cm.setCompany_name("teste");
        cm.setFantasy("testando");
        cm.setCnpj("01.557.947/0001-62");
        cm.setCell_phone1("333333333");
        cm.setAdress_city("moc");
        cm.setAdress_postalCode("wwwwwww");
        cm.setEnd_stat("mg");
        cm.setInsc_stat("444444444");

        cl.setAdress_postalCode("uuuuuu");
        cl.setName("cesar");
        cl.setEnd_stat("mg");
        cl.setEmail("pcego@pcego");
        cl.setRg_image("99999999");
        cl.setCpf("951.112.126-03");
        cl.setDt_nasc(c.getTime());
        cl.setDt_cad(c.getTime());
        cl.setCompany(cm);
        cl.setCellPhone_1("44444444");
        cl.setAdress_city("moc");
        
        IRepositoryClient repo = (IRepositoryClient) new DaoClient();
        //repo.salvar(cl);
        
        List<Client> lc = repo.listAll();
        
        for(Client lcs : lc){
            System.out.println(lcs.getName());            
        }

    }
}
