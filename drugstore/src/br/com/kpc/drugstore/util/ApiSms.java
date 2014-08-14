/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.kpc.drugstore.util;

import java.util.ArrayList;
import java.util.List;

import br.com.facilitamovel.bean.Retorno;
import br.com.facilitamovel.bean.SmsMultiplo;
import br.com.facilitamovel.bean.SmsMultiploMessages;
import br.com.facilitamovel.bean.SmsSimples;
import br.com.facilitamovel.service.SendMessage;
import br.com.kpc.drugstore.core.Client;
/**
 *
 * @author www
 */
public class ApiSms {
//	public static void main(String[] args) throws Exception{
//		ApiSms.simple();
//	}
    private static String login = "kennedimalheirosXXX";
    private static String senha = "kpsm2907XXXX";
	
	/**
	 * Exemplo de um envio Simples de SMS para a Plataforma
	 * @throws Exception
	 */
	public static void simple(String numCelular, String mensagem) throws Exception {
		// Simple Send
		SmsSimples sms = new SmsSimples();
		sms.setUser(login);
		sms.setPassword(senha);
		sms.setDestinatario(numCelular);
		sms.setMessage(mensagem);
		Retorno retorno = SendMessage.simpleSend(sms);
		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
	}

	
	/**
	 * Exemplo de uma mensagem para multiplos destinatarios
	 * @throws Exception
	 */
	public static void multiple(List<Client> listClientes) throws Exception {
		// Multiple Send
		SmsMultiplo sms = new SmsMultiplo();
		sms.setUser(login);
		sms.setPassword(senha);

		// Multiplos destinatarios
		List<String> nmbs = new ArrayList<String>();
		nmbs.add("3891573613");
		nmbs.add("3898178200");
		nmbs.add("3892296420");
		sms.setDestinatarios(nmbs);

		// Chave Interna do Cliente, nao eh obrigatorio
		List<String> chaveCliente = new ArrayList<String>();
		chaveCliente.add("1");
		chaveCliente.add("2");
		chaveCliente.add("3");
		sms.setChaveClientes(chaveCliente);

		sms.setMessage("teste");
		Retorno retorno = SendMessage.multipleSend(sms);

		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
	}

	
	/**
	 * Exemplo de envio de Multiplas Mensagens para Multiplos Destinatarios
	 * @throws Exception
	 */
	public static void multipleMsgs(List<Client> listClientes) throws Exception{
		// Multiple Send
		SmsMultiploMessages sms = new SmsMultiploMessages();
		sms.setUser(login);
		sms.setPassword(senha);

		// Multiplos destinatarios
		List<String> listNmbs = new ArrayList<String>();
		listNmbs.add("3891573613");
		listNmbs.add("3898178200");
		listNmbs.add("3892296420");
		sms.setDestinatarios(listNmbs);

		// Chave Interna do Cliente, nao eh obrigatorio
		List<String> messagesList = new ArrayList<String>();
		messagesList.add("Mensagem 1");
		messagesList.add("Mensagem 2");
		messagesList.add("Mensagem 3");
		sms.setMessages(messagesList);

		// Chave Interna do Cliente, nao eh obrigatorio
		List<String> chaveCliente = new ArrayList<String>();
		chaveCliente.add("1");
		chaveCliente.add("2");
		chaveCliente.add("3");
		sms.setChaveClientes(chaveCliente);

		Retorno retorno = SendMessage.multipleMessagesToMultPhones(sms);
		System.out.println("Codigo:" + retorno.getCodigo());
		System.out.println("Descricao:" + retorno.getMensagem());
	}
}
