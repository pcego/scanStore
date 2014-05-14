/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Pcego
 */
public class LoadImage {

    public static Icon drawIcon(String url) {

        File img = new File(url);

        try {
            BufferedImage bfi = ImageIO.read(img);
            Icon icon = new ImageIcon(bfi);
            return icon;
        } catch (IOException iex) {
            System.out.println(iex);
            return null;
        }
    }
}
