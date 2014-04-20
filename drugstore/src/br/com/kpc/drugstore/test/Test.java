/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pcego
 */
public class Test {
    
    public static void main(String[] args) {
        System.out.println("iniciar");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("drugstorePU");
        EntityManager em = emf.createEntityManager();
        
    }
    
}
