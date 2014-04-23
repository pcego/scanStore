/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.scan;

import com.asprise.jia.JiaException;
import com.asprise.jia.win.WiaJiaManager;
import java.io.File;

/**
 *
 * @author Pcego
 */
public class Scan {

    private File img;
    private File[] files;

    public File[] getGuiScan(String path) {

        img = new File(path);

        try {

            files = WiaJiaManager.getInstance().
                    quickScanUsingUI(img, null);

        } catch (JiaException jex) {
            jex.printStackTrace();

        }
        return files;
    }

    public static boolean renameImg(File img, String path, String newName) {

        return img.getAbsoluteFile().renameTo(new File(path, newName));
        
    }
}
