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
        File[] img = sc.getGuiScan("C:\\imagens");
       
        boolean b = Scan.renameImg(img[0], "C:\\imagens", "novoNome");

        if (b) {
            System.out.println("sucesso");
        }
        else{
            System.out.println("falha ao renomear");
        }
    }

}
