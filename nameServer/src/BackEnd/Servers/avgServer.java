/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Servers;

import Classes.ServidorIndividual;
import Classes.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dell
 */
public interface avgServer extends Remote {
    
    public double calculaMedia(Usuario user, int mes, int ano) throws RemoteException;

}
