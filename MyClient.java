package RMI2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import v1.Spectrum;
import v1.TimeHistory;

public class MyClient {

    MyInterface remoteObject;

    public static void main(String[] args) {
        new MyClient("localhost");
    }

    private MyClient(String hostname) {
        System.out.println("Hello there!");
        Registry reg;
        try {
            reg = LocateRegistry.getRegistry(hostname);
            remoteObject = (MyInterface) reg.lookup("MyServer");

            // create and add Tim and Spe objects to its Lists
            remoteObject.registerTimeHistory(new TimeHistory());
            remoteObject.registerSpectrum(new Spectrum<>());

            // find Tim objects
            ClientTools.foundFiles(remoteObject.searchTim("PC2")); // by name
            ClientTools.foundFiles(remoteObject.searchTim("PC2", "Lab2")); // by name, description
            ClientTools.foundFiles(remoteObject.searchTim("PC2", "Lab3", 1649506303L)); // by name, description, time
            ClientTools.printListTim(remoteObject.getListTim());
            
            // find Spe objects
            ClientTools.foundFiles(remoteObject.searchSpe("PC2")); // by name
            ClientTools.foundFiles(remoteObject.searchSpe("PC2", "Lab2")); // by name, description
            ClientTools.foundFiles(remoteObject.searchSpe("PC2", "Lab3", 1649506303L)); // by name, description, time
            ClientTools.printListSpe(remoteObject.getListSpe());

            remoteObject.saveToFileTimeHistory(1);
            

        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
