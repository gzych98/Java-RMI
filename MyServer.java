package RMI2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {
    Registry reg;
    MyInterfaceRemote servant;

    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    protected MyServer() throws RemoteException {
        try {
            reg = LocateRegistry.createRegistry(1099);
            servant = new MyInterfaceRemote();
            reg.rebind("MyServer", servant);
            System.out.println("Server Ready");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
