/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.tableModel;

import br.com.kpc.drugstore.core.Company;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kennedi Malheiros
 */
public class TableModelCompany extends AbstractTableModel {

    private List<Company> company;
    private String columns[] = new String[]{"CNPJ", "Nome", "Endereço"};

    private static final int CNPJ = 0;
    private static final int NOME = 1;
    private static final int ENDERECO = 2;

    public TableModelCompany() {
        company = new ArrayList<>();

    }

    public TableModelCompany(List<Company> company) {
        this.company = new ArrayList<>(company);
    }

    @Override
    public int getRowCount() {
        return company.size();
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
            case CNPJ:
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

        Company comp = company.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                return comp.getFantasy();

            case CNPJ:
                return comp.getCnpj();

            case ENDERECO:
                return comp.getAdress_street();

            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Company comp = company.get(rowIndex);

        switch (columnIndex) {
            case NOME:
                comp.setFantasy((String) aValue);
                break;
            case CNPJ:
                comp.setCnpj((String) aValue);
            case ENDERECO:
                comp.setAdress_street((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
    }

    public Company getCompany(int indexRow) {
        return company.get(indexRow);
    }

    public void addCompany(Company comp) {

        int lastIndex = getRowCount() - 1;
        company.add(comp);
        fireTableRowsInserted(lastIndex, lastIndex);

    }

    public void deleteCompany(int indexRow) {

        company.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void addListCompany(List<Company> comp) {

        int currentLengthTable = getRowCount();
        company.addAll(comp);
        fireTableRowsInserted(currentLengthTable, currentLengthTable + company.size());

    }

    public void clearTable() {

        company.clear();
        fireTableDataChanged();
    }
}
