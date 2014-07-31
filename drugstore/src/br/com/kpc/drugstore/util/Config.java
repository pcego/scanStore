/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.drugstore.util;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Pcego
 */
public class Config {
    public static final String DIRETORIOIMAGEM = "C:\\scanStore\\drugstore\\documentos\\"; //System.getProperty("user.dir") + "\\documentos\\";
    public static final String URLWEBSERVICEVALIDACAO = "http://localhost:8080/validatorWS/rest/validar/getKeyValidation/";
    
    /** 
     * Este método faz com que o ENTER seja considerado como TAB, em componentes 
     * como um JTextField. Além disso, permite a navegação com as setas para 
     * cima e para baixo. 
     *  
     * @param comp 
     *            O componente. 
     */  
    public static void considerarEnterComoTab(Component comp) {  
        Set<AWTKeyStroke> newKeystrokes;  
        newKeystrokes = new HashSet<AWTKeyStroke>(  
                comp.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_DOWN, 0));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_KP_DOWN, 0));  
        comp.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,  
                newKeystrokes);  
        newKeystrokes = new HashSet<AWTKeyStroke>(  
                comp.getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER,  
                InputEvent.SHIFT_DOWN_MASK));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_UP, 0));  
        newKeystrokes.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_KP_UP, 0));  
        comp.setFocusTraversalKeys(  
                KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, newKeystrokes);  
    } 
    
}
