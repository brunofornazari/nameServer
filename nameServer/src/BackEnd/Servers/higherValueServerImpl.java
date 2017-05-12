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

import Classes.Categoria;
import Classes.Despesa;
import Classes.Periodo;
import Classes.ServidorIndividual;
import Classes.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class higherValueServerImpl extends UnicastRemoteObject implements hvServer {
    
    public higherValueServerImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String MaiorValor(Usuario user, int mes, int ano) throws RemoteException {
        double maiorValor = 0;
        String categoriaMaiorValor = "";
        List<Categoria> categorias = user.getCategorias();
        for (Categoria categoria : categorias) {
            double total = 0;
            for (Periodo periodo : categoria.getPeriodos()) {
                if (periodo.getMes() == mes && periodo.getAno() == ano) {
                    for (Despesa despesa : periodo.getDespesas()) {
                        total += despesa.getValor();
                    }
                }
            }
            if (total > maiorValor) {
                maiorValor = total;
                categoriaMaiorValor = categoria.getTitulo();
            }
        }
        return categoriaMaiorValor;
    }
}
