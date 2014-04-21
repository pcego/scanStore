/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.dao;

import br.com.kpc.drugstore.core.Client;
import br.com.kpc.drugstore.core.IRepositoryRecipe;
import br.com.kpc.drugstore.core.Recipe;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Pcego
 */
public class DaoRecipe extends DaoGeneric<Recipe> implements IRepositoryRecipe {

    public DaoRecipe() {
        super(Recipe.class);
    }

    @Override
    public List<Recipe> listRecipeByClient(Client obj) {

        Query query = getManager().createQuery("SELECT R FROM Recipe R "
                + "JOIN Client C ON R.client = C.id WHERE C.cpf = :obj");
        query.setParameter("obj", obj.getCpf());
        return query.getResultList();
    }

    @Override
    public Recipe getLastRecipeByClient(Client obj) {

        Query query = getManager().createQuery("SELECT R FROM Recipe R "
                + "WHERE R.client.cpf = :obj "
                + "AND R.dt_recipe = (SELECT MAX(R.dt_recipe) "
                + "FROM Recipe R WHERE R.client.cpf = :obj) ORDER BY R.dt_recipe");
        query.setParameter("obj", obj.getCpf());
        return (Recipe) query.getSingleResult();

    }

    @Override
    public List<Recipe> listAll() {

        Query query = getManager().createQuery("SELECT R FROM Recipe R "
                + "ORDER BY R.dt_recipe");
        return query.getResultList();
    }
}
