/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.kpc.validator.core;

/**
 *
 * @author Dino
 */
public interface IRepository<T> {
    
    public T abrir(Long obj) throws Exception;

    public boolean salvar(T obj);

    public boolean apagar(T obj);

    public boolean atualizar(T obj);
    
}
