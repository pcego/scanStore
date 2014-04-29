/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import br.com.kpc.drugstore.core.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kennedi Malheiros
 */
public class ClientesTableModel extends AbstractTableModel {

    private static final int COL_ID = 0;
    private static final int COL_NOME = 1;
    private static final int COL_CPF = 2;

    private List<Client> listClient;

    //Esse é um construtor, que recebe a nossa lista de clientes
    public ClientesTableModel(List<Client> listClisnt) {
        this.listClient = new ArrayList<Client>(listClisnt);
    }

    @Override
    public int getRowCount() {
        return listClient.size();
    }

    @Override
    public int getColumnCount() {
        //Quantas colunas tem a tabela? Nesse exemplo, só 2.  
        return 3;
    }

    public String getColumnName(int column) {
        //Qual é o nome das nossas colunas?  
        if (column == COL_ID) {
            return "ID";
        }
        if (column == COL_NOME) {
            return "Nome";
        }
        if (column == COL_CPF) {
            return "CPF";
        }
        return ""; //Nunca deve ocorrer  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Precisamos retornar o valor da coluna column e da linha row.  
        Client cli = listClient.get(rowIndex);
        if (columnIndex == COL_ID) {
            return cli.getId();
        } else if (columnIndex == COL_NOME) {
            return cli.getName();
        } else if (columnIndex == COL_CPF) {
            return cli.getCpf();
        }
        return ""; //Nunca deve ocorrer 
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Client cli = listClient.get(rowIndex);
        //Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parâmetro.  
        //Note que vc poderia alterar 3 campos ao invés de um só.  
        if (columnIndex == COL_ID) {
            cli.setId(Long.valueOf(aValue.toString()));
        } else if (columnIndex == COL_NOME) {
            cli.setName(aValue.toString());
        } else if (columnIndex == COL_CPF) {
            cli.setCpf(aValue.toString());
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        //Qual a classe das nossas colunas? Como estamos exibindo texto, é string.  
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda é.  
        return false;
    }

    //Já que esse tableModel é de clientes, vamos fazer um get que retorne um cliente inteiro.  
    //Isso elimina a necessidade de chamar o getValueAt() nas telas.   
    public Client get(int row) {
        return listClient.get(row);
    }
}
