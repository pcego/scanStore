/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.relatorios;

import br.com.kpc.drugstore.dao.ConnectionDb;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pcego
 */
public class Filter {

    //passar null como parametro se não existir
    public String createSqlRel(String cpf, Date shopIn, Date shopEnd, Date recipeIn, Date recipeEnd) {

        HashMap hm = new HashMap();
        
        if(cpf.equals(null)){
            
        }      
        
        //sql base para geração de todos os relatórios para listagem de documentos
        //sem o filtro essa sql lista todas as vendas contidas na base
        StringBuilder sql_base = new StringBuilder("select cl.name, cl.cpf, cl.cpf_image, cl.rg_image, r.dt_recipe, r.recipe_type, \n"
                + "r.recipe_image, r.other_document, t.dt_shop, t.ticket_image, \n"
                + "t.ticket_number, t.auth_number from clients as cl INNER join recipes as r\n"
                + "on cl.clientId = r.CLIENT_clientId INNER join tickets as t\n"
                + "on r.recipeId = t.RECIPE_recipeId ");
        
        
        //implementação dos filtros para relatórios de documentos
        //estes são apenas alguns filtros possíveis sendo que novos filtros podem ser
        //implementados assim que surgir a necessidade, utilizando-se sempre a mesma sql base
        //filtra ultima compra de um cpf específico
        String filtroUltimaCompra = "WHERE cl.CPF = 95111212604 and "
                + "r.recipeId = (select MAX(recipeId) from recipes where CLIENT_clientId = (select clientId from clients where cpf = 95111212604))";

        //filtra as vendas em uma determinada data
        String filtroPorData = "WHERE t.DT_SHOP = '2014-08-01'";

        //filtra vendas para uma cliente específico em uma data específica
        String filtroVendaClienteData = "WHERE cl.cpf = '95111212604' and t.DT_SHOP = '2014-08-01'";

        //filtra todas as vendas com data de receita específica
        String filtroVendaDataReceita = "WHERE r.DT_RECIPE = '2014-07-30'";

        sql_base.append(filtroUltimaCompra);

        hm.put("query", sql_base);

        File rel = new File("C:\\scanStore\\drugstore\\src\\br\\com\\kpc\\drugstore\\relatorios\\documentos.jrxml");

        try {
            //gerando o jasper design
            JasperDesign desenho = JRXmlLoader.load(rel);
            //compila o relatório
            JasperReport relatorio = JasperCompileManager.compileReport(desenho);
            JasperPrint print = JasperFillManager.fillReport(relatorio, hm, ConnectionDb.getConnectionDs());
            JasperViewer visao = new JasperViewer(print, true);
            visao.setVisible(true);
        } catch (JRException jrex) {
            System.out.println("deu erro: " + jrex);
        }

        return null;
    }
}
