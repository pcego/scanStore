/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.service;

import br.com.kpc.drugstore.core.IRepository;
import br.com.kpc.drugstore.core.IRepositoryClient;
import br.com.kpc.drugstore.core.IRepositoryCompany;
import br.com.kpc.drugstore.core.IRepositoryRecipe;
import br.com.kpc.drugstore.core.IRepositoryTicket;
import br.com.kpc.drugstore.dao.DaoClient;
import br.com.kpc.drugstore.dao.DaoCompany;
import br.com.kpc.drugstore.dao.DaoRecipe;
import br.com.kpc.drugstore.dao.DaoTicket;

/**
 *
 * @author Pcego
 */
public class Service {

    private static final int CLIENT = 1;
    private static final int RECIPE = 2;
    private static final int TICKET = 3;
    private static final int COMPANY = 4;

    private static IRepositoryClient repClient;
    private static IRepositoryCompany repCompany;
    private static IRepositoryTicket repTicket;
    private static IRepositoryRecipe repRecipe;

    public static IRepository irepositoryFactory(int id) {

        switch (id) {

            case CLIENT:

                if (repClient == null) {
                    repClient = (IRepositoryClient) new DaoClient();
                }
                return repClient;

            case RECIPE:

                if (repRecipe == null) {
                    repRecipe = (IRepositoryRecipe) new DaoRecipe();

                }
                return repRecipe;

            case TICKET:

                if (repTicket == null) {
                    repTicket = (IRepositoryTicket) new DaoTicket();
                }
                return repTicket;

            case COMPANY:

                if (repCompany == null) {
                    repCompany = (IRepositoryCompany) new DaoCompany();
                }
                return repCompany;
        }
        
        return null;
    }
}
