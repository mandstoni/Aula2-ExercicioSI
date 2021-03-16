package comum;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServicoPessoa extends Remote {
    void inserir(Pessoa p) throws RemoteException;
    List<Pessoa> listarPessoa() throws RemoteException;
}
