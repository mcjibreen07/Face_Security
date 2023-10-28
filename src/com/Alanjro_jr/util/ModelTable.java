package com.Alanjro_jr.util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel {

    private String path;

    private ArrayList linhas = null;
    private String[] colunas = null;

    public ModelTable(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ModelTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }

}
