/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.SeveralServers;

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

import BackEnd.SeveralServers.functionServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class higherValueServer extends UnicastRemoteObject implements functionServer {
    
    public higherValueServer() throws RemoteException {
        
    }
    
}
