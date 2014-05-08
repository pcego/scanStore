/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.service;

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

    private static IRepositoryClient repClient;
    private static IRepositoryCompany repCompany;
    private static IRepositoryTicket repTicket;
    private static IRepositoryRecipe repRecipe;

    public static IRepositoryClient getIRepositoryClient() {

        if (repClient == null) {
            repClient = (IRepositoryClient) new DaoClient();
        }
        return repClient;
    }

    public static IRepositoryRecipe getIRepositoryRecipe() {

        if (repRecipe == null) {
            repRecipe = (IRepositoryRecipe) new DaoRecipe();
        }
        return repRecipe;
    }

    public static IRepositoryTicket getIRepositoryTicket() {
        if (repTicket == null) {
            repTicket = (IRepositoryTicket) new DaoTicket();
        }
        return repTicket;
    }

    public static IRepositoryCompany getIRepositoryCompany() {
        if (repCompany == null) {
            repCompany = (IRepositoryCompany) new DaoCompany();
        }
        return repCompany;
    }
}
