package BackEnd;

import Classes.ServidorIndividual;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServidorImpl extends UnicastRemoteObject implements Servidor{
    
    public ServidorImpl() throws RemoteException {
            super(); 
    }

    @Override
    public ServidorIndividual getServidor(String sFuncao) {
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
    public ServidorIndividual conectarServico(ServidorIndividual servico){
        if(servico instanceof ServidorIndividual){
            boolean tempStatus = true;
            for(ServidorIndividual tempServ : _servicos){
                if(tempServ.getName().compareTo(servico.getName()) == 0){
                    if(tempServ.getAddress().compareTo(servico.getAddress()) == 0){
                        servico.setStatus(1);
                    } else {
                        servico.setStatus(0);
                    }
                    tempStatus = false;
                }
            }
            if(tempStatus == true){
                _servicos.add(servico);
                System.out.println(servico.getName() + " Conectado!");
                servico.setStatus(2);
            }
            
        } else {
            throw new Error("Servidor esperava um objeto do tipo ServidorIndividual, mas recebeu tipo não aceito.");
        }
        
        return servico;
    }
    
    @Override
    public boolean desconectarServico(ServidorIndividual servico){
        List<ServidorIndividual> servicos = _servicos;
        for(ServidorIndividual server : servicos){
            if(servico.getName().compareTo(server.getName()) == 0 && servico.getAddress().compareTo(server.getAddress()) == 0){
                servicos.remove(server);
                return true;
            }
        }
        
        return false;
    }
}