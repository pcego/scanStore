/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.tableModel;

import br.com.kpc.drugstore.core.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pcego
 */
public class TableModelClient extends AbstractTableModel {

    private List<Client> client;
    private String columns[] = new String[]{"CPF", "Nome", "Endereço"};

    private static final int CPF = 0;
    private static final int NOME = 1;
    private static final int ENDERECO = 2;

    public TableModelClient() {
        client = new ArrayList<>();

    }

    public TableModelClient(List<Client> client) {
        client = new ArrayList<Client>(client);
    }

    @Override
    public int getRowCount() {
        return client.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case NOME:
                return String.class;
            case CPF:
                return String.class;
            case ENDERECO:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Client cli = client.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                return cli.getName();

            case CPF:
                return cli.getCpf();

            case ENDERECO:
                return cli.getAdress_street();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Client cli = client.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                cli.setName((String) aValue);
                break;
            case CPF:
                cli.setCpf((String) aValue);
            case ENDERECO:
                cli.setAdress_street((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }

    public Client getClient(int indexRow) {
        return client.get(indexRow);
    }

    public void addClient(Client cli) {

        int lastIndex = getRowCount() - 1;
        client.add(cli);
        fireTableRowsInserted(lastIndex, lastIndex);

    }

    public void deleteClient(int indexRow) {

        client.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void addListClient(List<Client> cli) {

        int currentLengthTable = getRowCount();
        client.addAll(cli);
        fireTableRowsInserted(currentLengthTable, currentLengthTable + client.size());

    }

    public void clearTable() {

        client.clear();
        fireTableDataChanged();
    }
}
