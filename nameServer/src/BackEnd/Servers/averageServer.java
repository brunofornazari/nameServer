/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Servers;

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

import BackEnd.Servers.functionServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class averageServer extends UnicastRemoteObject implements functionServer {
    
    public averageServer() throws RemoteException {
        
    }
    
}
