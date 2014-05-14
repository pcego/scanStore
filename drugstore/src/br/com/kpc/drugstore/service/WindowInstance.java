/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.service;

import br.com.kpc.drugstore.gui.ClienteFrame;
import br.com.kpc.drugstore.gui.CompanyFrame;
import br.com.kpc.drugstore.gui.ConsultarCliente;
import br.com.kpc.drugstore.gui.RecipeFrame;
import br.com.kpc.drugstore.gui.Sobre;
import javax.swing.JFrame;

/**
 *
 * @author Pcego
 */
public class WindowInstance {

    private static ClienteFrame client;
    private static CompanyFrame company;
    private static RecipeFrame recipe;
    private static ConsultarCliente search;
    private static Sobre sobre;

    public static final int CLIENTWINDOW = 1;
    public static final int COMPANYWINDOW = 2;
    public static final int RECIPEWINDOW = 3;
    public static final int SEARCHWINDOW = 4;
    public static final int SOBREWINDOW = 5;

    public static JFrame getInstance(int id) {

        switch (id) {

            case CLIENTWINDOW:

                if (client == null) {
                    client = new ClienteFrame();
                }
                return client;

            case COMPANYWINDOW:

                if (company == null) {
                    company = new CompanyFrame();
                }
                return company;

            case RECIPEWINDOW:

                if (recipe == null) {
                    recipe = new RecipeFrame();
                }
                return recipe;

            case SEARCHWINDOW:

                if (search == null) {
                    search = new ConsultarCliente();
                }
                return search;

            case SOBREWINDOW:

                if (sobre == null) {
                    sobre = new Sobre();
                }
                return sobre;

            default:
                return null;
        }

    }

}
