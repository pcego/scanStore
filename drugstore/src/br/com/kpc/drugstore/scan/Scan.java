/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.scan;

import com.asprise.jia.JiaException;
import com.asprise.jia.JiaManager;
import com.asprise.jia.win.WiaJiaManager;
import java.io.File;

/**
 *
 * @author Pcego
 */
public class Scan {

    public File[] getGuiScan() throws JiaException {
        File[] files = WiaJiaManager.getInstance().quickScanUsingUI(new File(new File("C:\\scanner"), "sc.jpg"), null);
        System.out.println(files[0].getName());
        return files;
   }
}
