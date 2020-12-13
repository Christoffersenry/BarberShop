/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.barberViews;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rcvb8
 */
public class BBooleanTableV extends AbstractTableModel {
    
    Object data[][] = {       
           {"7:00 AM", Boolean.FALSE},
           {"8:00 AM", Boolean.FALSE},
           {"9:00 AM", Boolean.FALSE},
           {"10:00 AM", Boolean.FALSE},
           {"11:00 AM", Boolean.FALSE},
           {"1:00 PM", Boolean.FALSE},
           {"2:00 PM", Boolean.FALSE},
           {"3:00 PM", Boolean.FALSE},
           {"4:00 PM", Boolean.FALSE},
           {"5:00 PM", Boolean.FALSE},
           {"6:00 PM", Boolean.FALSE}           
       };
       String[] columnNames = {"Time Slot", "Available"};
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
        
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return data[0][columnIndex].getClass();
        }
}
