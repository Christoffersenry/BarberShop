/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbershop;

import barbershop.customerControllers.CLogCon;
import barbershop.index.IndexCon;
import barbershop.customerViews.CBarbAvailV;
import barbershop.customerViews.CBarbSearchV;
import barbershop.customerViews.CBookingsV;
import barbershop.customerViews.CLeaveRevV;
import barbershop.customerViews.CHomeV;
import barbershop.customerViews.CLogV;
import barbershop.customerViews.CRegV;

/**
 *
 * @author rcvb8
 */
public class BarberShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                BarberShop.run();
        
    }
    
    public static void run() {
        
                new IndexCon();
                
    }
    
    }
    

