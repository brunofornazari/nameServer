/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Servers;

import Classes.Categoria;
import Classes.Despesa;
import Classes.Periodo;
import Classes.ServidorIndividual;
import Classes.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Dell
 */
public class averageServerImpl extends UnicastRemoteObject implements avgServer {
    
    public averageServerImpl() throws RemoteException{
        super();
    }
    
    @Override
    public double calculaMedia(Usuario user, int mes, int ano) throws RemoteException {
        double total = 0;
        double media = 0;
        List<Categoria> categorias = user.getCategorias();
        for (Categoria categoria : categorias) {
            for (Periodo periodo : categoria.getPeriodos()) {
                if (periodo.getMes() == mes && periodo.getAno() == ano) {
                    for (Despesa despesa : periodo.getDespesas()) {
                        total += despesa.getValor();
                    }
                }
            }
        }
        media = total/categorias.size();
        return media; 
    }
}
