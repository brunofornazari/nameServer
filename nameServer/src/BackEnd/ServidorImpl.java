package BackEnd;

import BackEnd.Servers.avgServer;
import Classes.ServidorIndividual;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorImpl extends UnicastRemoteObject implements Servidor{
    
    public ServidorImpl() throws RemoteException {
            super(); 
    }

    @Override
    public ServidorIndividual getServidor(String sFuncao) throws RemoteException {
        List<ServidorIndividual> servicos = _servicos;
        System.out.println("Requisitando " + sFuncao);
        for(ServidorIndividual servico : servicos){
            if(servico.getName().compareTo(sFuncao) == 0){
                System.out.println("Servidor " + sFuncao + " está conectado, enviando ao cliente!");
                return servico;
            }
        }
        System.out.println("Não Foi possível encontrar nenhum serviço disponível do tipo " + sFuncao);
        return null;
    }
    
    @Override
    public int conectarServico(ServidorIndividual servico) throws RemoteException{
        int returnStatus = -1;
        if(servico instanceof ServidorIndividual){
            boolean tempStatus = true;
            for(ServidorIndividual tempServ : _servicos){
                if(tempServ.getName().compareTo(servico.getName()) == 0){
                    if(tempServ.getAddress().compareTo(servico.getAddress()) == 0){
                        returnStatus = 1;
                    } else {
                        returnStatus = 0;
                    }
                    tempStatus = false;
                }
            }
            if(tempStatus == true){
                _servicos.add(servico);
                System.out.println(servico.getName() + " Conectado!");
               
                returnStatus = 2;

            }
            
        } else {
            throw new Error("Servidor esperava um objeto do tipo ServidorIndividual, mas recebeu tipo não aceito.");
        }
        
        return returnStatus;
    }
    
    @Override
    public boolean desconectarServico(ServidorIndividual servico) throws RemoteException{
        List<ServidorIndividual> servicos = _servicos;
        for(ServidorIndividual server : servicos){
            if(servico == server){
                server.setStatus(0);
                servicos.remove(server);
                return true;
            }
        }
        return false;
    }
    

    public boolean desconectarServico(String sServico) throws RemoteException{
        List<ServidorIndividual> servicos = _servicos;
        for(ServidorIndividual server : servicos){
            if(server.getName().compareTo(sServico) == 0){
                servicos.remove(server);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void desconectarTodosOsServicos() throws RemoteException{
        _servicos.clear();
    }
    
    @Override
    public int verificaStatus(ServidorIndividual _servico) throws RemoteException{
        int returnStatus = 3;
        for(ServidorIndividual tempServ : _servicos){
            if(tempServ.getName().compareTo(_servico.getName()) == 0){
                if(tempServ.getAddress().compareTo(_servico.getAddress()) == 0){
                    returnStatus = 4;
                } 
            }
        }
        
        return returnStatus;
    }
    
    @Override
    public String listarServicosAtivos() throws RemoteException{
        String returnString = "";
        returnString += "Lista de Servidores ativos:\n";
        if(_servicos.size() > 0){
            for(ServidorIndividual tempServ : _servicos){
                returnString += tempServ.getName() + " - " + tempServ.getAddress();
            }
        } else {
            returnString += "Não há nenhum serviço ativo!";
        }
        returnString += "\n ------------------------------- \n";
        
        return returnString;
    }
}