/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.validator.resource;

import br.com.kpc.validator.core.ClientKpc;
import br.com.kpc.validator.core.Computer;
import br.com.kpc.validator.core.IRepositoryClientKpc;
import br.com.kpc.validator.core.IRepositoryComputer;
import br.com.kpc.validator.dao.ComputerDao;
import br.com.kpc.validator.service.ContextoInicial;
import br.com.kpc.validator.service.KPCSeg;
import com.sun.xml.wss.util.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
    private Computer computer = new Computer();
    private ClientKpc clientKpc = new ClientKpc();
    private IRepositoryComputer rpComputer;
    private IRepositoryClientKpc rpClientKpc;
    private Calendar c = Calendar.getInstance();
    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso
    @Path("/getKeyValidation/{key}")
    public String keyValidatorGen(@PathParam("key") String param) {
        try {
            rpComputer = (IRepositoryComputer) ContextoInicial.getContext().lookup("java:global/validatorWS/ComputerDao");
            rpClientKpc = (IRepositoryClientKpc) ContextoInicial.getContext().lookup("java:global/validatorWS/ClientKpcDao");

            //carregando as variaveis com os dados recebidos e descriptografados
            carregaDados(param.replace("@", "/"));

            //Loading object computer
            computer = rpComputer.getComputerByhdNumber(HD);
            /* 
             != Null Return True = Tem cliente
             else False = não tem cliente
             Verificando se o cliente existe.
             */
            if (computer != null) {
                dtValidade = sd.format(computer.getDateExpire());
            } else { //Verificando se o cliente é Novo.
                computer = new Computer();
                clientKpc = rpClientKpc.getClient(CNPJ);
                if (clientKpc == null) {
                    clientKpc = new ClientKpc();
                    //Loadiang object
                    clientKpc.setCpf_Cnpj(CNPJ);
                    clientKpc.setName("SEM NOME");
                    clientKpc.setPhone("0000000000");
                    clientKpc.setEmail("SEM EMAIL");

                    rpClientKpc.salvar(clientKpc);
                }

                c.add(Calendar.MONTH, 1);
                dtValidade = sd.format(c.getTime());
                //Loading object computer
                computer.setDateExpire(FormatDate.transformaData(dtValidade));
                computer.setHdNumber(HD);
                computer.setDateInstalation(FormatDate.transformaData(dtInstall));
                computer.setmBoardNumber(placaMae);
                computer.setClient(clientKpc);
                rpComputer.salvar(computer);
            }

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

        return serial;

    }

    private void carregaDados(String param) {
        String serialCompleto;
        String detalhes[];

        if (param.trim().equals("")) {
            return;
        }

        try {
            KPCSeg seg = new KPCSeg();
            serialCompleto = seg.decrypt(param.trim());
            detalhes = serialCompleto.split(",");

            // 0   1       2           3            4             5
            // X, CNPJ, serial HD, serial CPU, DTVencimento, DTInstalacao
            CNPJ = detalhes[1];
            HD = detalhes[2];
            placaMae = detalhes[3];
            dtValidade = "00/00/0000";
            dtInstall = detalhes[5];

//                    + new SimpleDateFormat("dd/MM/yyyy").format((new Date()));
            //tvCodInstalacao1.setText(seg.encrypt(codInstalacao));
            // tvSerial.setText();
        } catch (Exception ex) {
            Logger.getLogger(KeyValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
