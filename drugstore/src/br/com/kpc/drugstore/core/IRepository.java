/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.core;

/**
 *
 * @author Dino
 */
public interface IRepository <T> {
    
    public T abrir(T obj) throws Exception;

    public boolean salvar(T obj);

    public boolean apagar(T obj);

    public boolean atualizar(T obj);
    
}
