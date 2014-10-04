/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.relatorios;

/**
 *
 * @author pcego
 */
public class Filter {

    public static final int DATA_RECEITA_CLIENTE = 1;
    public static final int INTERVALO_DATA_RECEITA = 2;
    public static final int DATA_VENDA = 3;
    public static final int INTERVALO_DATA_VENDA = 4;
    public static final int TODOS = 5;
    public static final int ULTIMA_COMPRA_CLIENTE = 6;
    public static final int VENDAS_CLIENTE = 7;
    public static final int CLIENTE_DATA_VENDA = 8;
    public static final int DATA_RECEITA = 9;

    //passar null como parametro se não existir
    public StringBuilder createSqlRel(int check, String cpf, String dataIn, String dataEnd) {

        String filtro = "";

        //sql base para geração de todos os relatórios para listagem de documentos
        //sem o filtro essa sql lista todas as vendas contidas na base
        StringBuilder sql_base = new StringBuilder("select cl.name, cl.cpf, cl.cpf_image, cl.rg_image, r.dt_recipe, r.recipe_type, \n"
                + "r.recipe_image, r.other_document, t.dt_shop, t.ticket_image, \n"
                + "t.ticket_number, t.auth_number from clients as cl INNER join recipes as r\n"
                + "on cl.clientId = r.CLIENT_clientId INNER join tickets as t\n"
                + "on r.recipeId = t.RECIPE_recipeId ");

        switch (check) {

            case TODOS:
                return sql_base;

            case VENDAS_CLIENTE:
                filtro = " where cl.CPF = " + cpf;
                return sql_base.append(filtro);

            case ULTIMA_COMPRA_CLIENTE:
                filtro = "WHERE cl.CPF = " + cpf + " and "
                        + "r.recipeId = (select MAX(recipeId) from recipes where "
                        + "CLIENT_clientId = (select clientId from clients where cpf = " + cpf + " ))";
                return sql_base.append(filtro);

            case INTERVALO_DATA_VENDA:
                filtro = "WHERE t.DT_SHOP = BETWEEN " + "'" + dataIn +"'" + " AND " + "'" + dataEnd +"'";
                return sql_base.append(filtro);
                
            case INTERVALO_DATA_RECEITA:
                filtro = "WHERE t.DT_RECIPE = BETWEEN " + "'" + dataIn +"'" + " AND " + "'" + dataEnd +"'";
                return sql_base.append(filtro);
                
            case DATA_VENDA:
                filtro = "WHERE t.DT_SHOP = " + "'" + dataIn +"'";
                return sql_base.append(filtro);

            case DATA_RECEITA:
                filtro = "WHERE r.DT_RECIPE = " + "'" + dataIn +"'";
                return sql_base.append(filtro);

            case CLIENTE_DATA_VENDA:
                filtro = "WHERE cl.cpf = " + cpf + " and  t.DT_SHOP = " + "'" + dataIn +"'";
                return sql_base.append(filtro);

            case DATA_RECEITA_CLIENTE:
                filtro = "WHERE cl.cpf = " + cpf + " and  t.DT_RECIPE = " + "'" + dataIn +"'";
                return sql_base.append(filtro);
        }

        return null;
    }
}
