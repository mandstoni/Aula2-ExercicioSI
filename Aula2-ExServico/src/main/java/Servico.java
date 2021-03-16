import comum.ServicoRemoteImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Servico {
    public Servico() throws RemoteException{
        try {
            LocateRegistry.createRegistry(4200);
            System.out.println("INICIO");
            Naming.rebind("rmi://localhost:4200/pessoa", new ServicoRemoteImpl());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws RemoteException{
        new Servico();
    }
}