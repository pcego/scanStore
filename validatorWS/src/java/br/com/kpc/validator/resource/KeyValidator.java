/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.resource;

import br.com.kpc.validator.service.KPCSeg;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pcego
 */
@XmlRootElement
@Path("/validar")
public class KeyValidator {

    private String CNPJ;
    private String HD;
    private String placaMae;
    private String dtInstall;
    private String dtValidade;
    private boolean ativo;
    private String serial;
    
    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso
    @Path("/getKeyValidation/{key}")
    public String keyValidatorGen(@PathParam("key") String param) {
        try {
            carregaDados(param.replace("@", "/"));
            
            String codInstalacao;
            KPCSeg seg = new KPCSeg();
            ativo = true;
            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
            codInstalacao = "X,"
                    + CNPJ.trim() + ","
                    + HD.trim() + ","
                    + placaMae.trim() + ","
                    + dtValidade.trim() + ","
                    + dtInstall.trim() + ",";
            if (ativo) {
                codInstalacao = codInstalacao + "true";
            } else {
                codInstalacao = codInstalacao + "false";
            }

            
            serial = (seg.encrypt(codInstalacao.trim()));
          
        } catch (Exception ex) {
            Logger.getLogger(KeyValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        //implementar aqui a lógica de validação
        return serial ;
    }
    
    
    private void carregaDados(String param){
        String serialCompleto;
        String detalhes[];

        if (param.trim().equals("")) {
            return;
        }

        try {
            KPCSeg seg = new KPCSeg();
            serialCompleto = seg.decrypt(param.trim());
            detalhes = serialCompleto.split(",");

            Calendar c = Calendar.getInstance();
            c.add(Calendar.MONTH, 1);
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            sd.format(c.getTime());

            // 0   1       2           3            4             5
            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
            CNPJ = detalhes[1];
            HD = detalhes[2];
            placaMae = detalhes[3];
            dtValidade = sd.format(c.getTime());
            dtInstall = detalhes[5];

//                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
            //tvCodInstalacao1.setText(seg.encrypt(codInstalacao));
            // tvSerial.setText();
        } catch (Exception ex) {
            Logger.getLogger(KeyValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

}
