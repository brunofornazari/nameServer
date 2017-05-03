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
        for(ServidorIndividual servico : servicos){
            if(servico.getName() == sFuncao){
                return servico;
            }
        }
        return null;
    }
    
    @Override
    public void conectarServico(ServidorIndividual servico){
        if(servico instanceof ServidorIndividual){
            _servicos.add(servico);
        } else {
            throw new Error("Servidor esperava um objeto do tipo ServidorIndividual, mas recebeu tipo não aceito.");
        }
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