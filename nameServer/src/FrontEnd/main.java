/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;
import BackEnd.Servidor;
import Classes.ServidorIndividual;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
/**
 *
 * @author Engenharia de Computação - 9º Semestre
 * André Apollo
 * Bruno Fornazari
 * Felipe Arias
 * Filipe Nathan
 * Thales Correa
 * 
 */

public class main{
    static Servidor _server;
    
    public static void main(String args[]) throws NotBoundException, MalformedURLException, MalformedURLException, RemoteException {
        _server = (Servidor) Naming.lookup("rmi://localhost:1099/Servidor");
        
        String funcaoExemplo = "Teste";
        ServidorIndividual teste = _server.getServidor(funcaoExemplo);
        if(teste == null){
            System.out.println("Não foi possível encontrar o Servidor: " + funcaoExemplo + ".");
        } else {
            System.out.println("Encontrei o servidor " + funcaoExemplo + " ele está em " + teste.getAddress());
        }
    }
}

