/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

/**
 *
 * @author Pcego
 */
public interface IRepositoryCompany extends IRepository<Company> {
    
    Company getCompany();       
    
    boolean validateLicenceKey(String key);
    
}
