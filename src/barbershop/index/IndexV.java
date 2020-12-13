/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop.index;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IndexV extends JFrame{
    
    IndexCon indexCon;
    
//    CONSTRUCTOR TO INSTANTIATE AND CONNECT THIS VIEW TO THE INDEX CONTROLLER
    public IndexV(IndexCon indexCon) {        
        this.indexCon = indexCon;
        
            setAttributes();
            components();
            validation();        
    }
    
//     SET ATTRIBUTES AND DEFINE FRAME
    public void setAttributes() {
        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("cuttco.com");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
//     ORGANISE AND BUILD COMPONENTS    
    public void components() {
        BorderLayout bLay = new BorderLayout();
        this.setLayout(bLay);
        
        JPanel topPanel = new JPanel();
        this.add(topPanel, BorderLayout.NORTH);
        JLabel brand = new JLabel("Cutt Co.");
        topPanel.add(brand);
        
        JPanel centerPanel = new JPanel();
        this.add(centerPanel, BorderLayout.CENTER);
        GridLayout gLay = new GridLayout(2 , 1);
        centerPanel.setLayout(gLay);
        
        JPanel gridP1 = new JPanel();
        centerPanel.add(gridP1);
        JLabel phrase = new JLabel("Your friendly neighbourhood barbershop.");
        gridP1.add(phrase);
        
        JPanel gridP2 = new JPanel();
        centerPanel.add(gridP2);
        ImageIcon custIcon = new ImageIcon(getClass().getResource("/barbershop/images/custIcon.jpg"));
        Image custSize = custIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon custIconSized = new ImageIcon(custSize);
        JButton custLink = new JButton("Customer");
        custLink.setIcon(custIconSized);
        custLink.setHorizontalTextPosition(JButton.CENTER);
        custLink.setVerticalTextPosition(JButton.BOTTOM);
        custLink.setActionCommand("Customer");
        custLink.addActionListener(indexCon);
        gridP2.add(custLink);
        
        ImageIcon barbIcon = new ImageIcon(getClass().getResource("/barbershop/images/barber.jpg"));
        Image barbSize = barbIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon barbIconSized = new ImageIcon(barbSize);
        JButton barbLink = new JButton("Barber");
        barbLink.setIcon(barbIconSized);
        barbLink.setHorizontalTextPosition(JButton.CENTER);
        barbLink.setVerticalTextPosition(JButton.BOTTOM);
        barbLink.setActionCommand("Barber");
        barbLink.addActionListener(indexCon);
        gridP2.add(barbLink);
    }
        
//      VALIDATE AND REPAINT FRAME
    private void validation() {
        this.validate();
        this.repaint();
    }
    
}

