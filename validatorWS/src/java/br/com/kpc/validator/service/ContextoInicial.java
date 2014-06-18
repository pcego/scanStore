/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public class ContextoInicial {

    private static Context ctx;

    private ContextoInicial() {
        try {
            ctx = (Context) new InitialContext();
        } catch (NamingException ex) {
            System.out.println(ex.getCause());
        }
    }

    public static Context getContext() {

        if (ctx == null) {
            new ContextoInicial();
        }
        return ctx;

    }
}
