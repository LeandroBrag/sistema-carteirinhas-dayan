/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controles;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dayan
 */
public class Tabela extends DefaultTableModel {
    
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }
    
    public Tabela(Object[][] data, Object[] columnNames) {
        setDataVector(data, columnNames);
    }
    
    
    
}
