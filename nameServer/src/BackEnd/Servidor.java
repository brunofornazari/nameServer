package BackEnd;

import Classes.ServidorIndividual;
import java.rmi.*; // importa pacotes do RMI
import java.util.ArrayList;
import java.util.List;

public interface Servidor extends Remote // necessita herdar para obter invocação remota
{
	List<ServidorIndividual> _servicos = new ArrayList<ServidorIndividual>();
        
        public ServidorIndividual getServidor(String sTypo) throws RemoteException;
        public ServidorIndividual conectarServico(ServidorIndividual servico) throws RemoteException;
        public boolean desconectarServico(ServidorIndividual servico) throws RemoteException;
        public boolean desconectarServico(String sServico) throws RemoteException;
        public void desconectarTodosOsServicos() throws RemoteException;
}