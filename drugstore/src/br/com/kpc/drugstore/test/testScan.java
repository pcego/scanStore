/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.kpc.drugstore.test;

import br.com.kpc.drugstore.scan.Scan;
import com.asprise.jia.JiaException;
import java.io.File;

/**
 *
 * @author Dino
 */
public class testScan {
    
    
    
    public static void main(String[] args) throws JiaException {
        Scan sc = new Scan();
        File[] img = sc.getGuiScan(); 
        for(int i =0; i < img.length; i++){
            
        }
    }
    
}
