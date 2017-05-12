/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

package BackEnd.Servers;

import Classes.ServidorIndividual;
import Classes.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface lvServer extends Remote{
    
    public String MenorValor(Usuario user, int mes, int ano) throws RemoteException;
    
}
