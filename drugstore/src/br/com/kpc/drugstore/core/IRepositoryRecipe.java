/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

import java.util.List;

/**
 *
 * @author Pcego
 */
public interface IRepositoryRecipe extends IRepository<Recipe> {
    
    List<Recipe> listRecipeByClient(Client obj);
    Recipe getLastRecipeByClient(Client obj);
    List<Recipe> listAll();
    
}
