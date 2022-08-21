package RMI2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.util.List;

import v1.Spectrum;
import v1.TimeHistory;

public class MyInterfaceRemote extends UnicastRemoteObject implements MyInterface{
    private List<TimeHistory> dataTimeHistories = new ArrayList<>();
    private List<Spectrum<Double>> dataSpectrums = new ArrayList<>();
    
    MyInterfaceRemote() throws RemoteException {
        super();
    }
    /**
	 * add TimeHistory object to remote List
	 * @param dataTimeHistory - new TimeHsitory object
	 * @return - boolean if added
	 */
    public boolean registerTimeHistory(TimeHistory dataTimeHistory) throws RemoteException {
        System.out.println("Server.register(): " + dataTimeHistory.toString());
		if (!dataTimeHistories.contains(dataTimeHistory)) {
			dataTimeHistories.add(dataTimeHistory);
			return true;
		}
		return false;
    }
    /**
	 * add Spectrum object to remote List
	 * @param dataSpectrum - new Spectrum object
	 * @return - boolean if added
	 */
    public boolean registerSpectrum(Spectrum<Double> dataSpectrum) throws RemoteException {
        System.out.println("Server.register(): " + dataSpectrum.toString());
		if (!dataSpectrums.contains(dataSpectrum)) {
			dataSpectrums.add(dataSpectrum);
			return true;
		}
		return false;
    }
    /**
	 * return current TimeHistory List
	 * @return - TimeHisotry objects List
	 */
    public List<TimeHistory> getListTim() throws RemoteException {
        return dataTimeHistories;
    }

    
    public boolean saveToFileTimeHistory(int listNumber) throws RemoteException {
        String element = dataTimeHistories.get(listNumber-1).fileName();
        String path = "./src/RMI2/data/" + element + ".thi";
        File f = new File(path);
        boolean openNew;
        try {
            openNew = f.createNewFile();
            if (openNew) {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
                out.writeObject(element);
                out.close();
                return true;
            } else {
                System.out.println("File operation failed");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }  
    }
    /**
	 * search TimeHistory by name
	 * @param devName - object name
	 * @return - File array
	 */
    public File[] searchTim(String devName) throws RemoteException {
        File fileFind = new File("./src/RMI2/data/");
        File[] matchingFiles = fileFind.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
              return name.startsWith(devName) && name.endsWith(".thi");
            }
          });    
        return matchingFiles;    
    }
    /**
	 * search TimeHistory by name and description
	 * @param devName - object name
     * @param description - object description
	 * @return - File array
	 */
    public File[] searchTim(String devName, String description) throws RemoteException {
        File fileFind = new File("./src/RMI2/data/");
        String name1 = devName + "-" + description;
        File[] matchingFiles = fileFind.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
              return name.startsWith(name1) && name.endsWith(".thi");
            }
          });    
        return matchingFiles; 
    }
    /**
	 * search TimeHistory by name, description and boot time
	 * @param devName - object name
     * @param description - object description
     * @param time - object boot time
	 * @return - File array
	 */
    public File[] searchTim(String devName, String description, Long time) throws RemoteException {
        File fileFind = new File("./src/RMI2/data/");
        String name1 = devName + "-" + description + "-" + time;
        File[] matchingFiles = fileFind.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
              return name.startsWith(name1) && name.endsWith(".thi");
            }
          });    
        return matchingFiles; 
    }

     /**
	 * search Spectrum by name
	 * @param devName - object name
	 * @return - File array
	 */
    public File[] searchSpe(String devName) throws RemoteException {
        File fileFind = new File("./src/RMI2/data/");
        File[] matchingFiles = fileFind.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
              return name.startsWith(devName) && name.endsWith(".spc");
            }
          });    
        return matchingFiles;    
    }
    /**
	 * search Spectrum by name and description
	 * @param devName - object name
     * @param description - object description
	 * @return - File array
	 */
    public File[] searchSpe(String devName, String description) throws RemoteException {
        File fileFind = new File("./src/RMI2/data/");
        String name1 = devName + "-" + description;
        File[] matchingFiles = fileFind.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
              return name.startsWith(name1) && name.endsWith(".spc");
            }
          });    
        return matchingFiles; 
    }
    /**
	 * search Spectrum by name, description and boot time
	 * @param devName - object name
     * @param description - object description
     * @param time - object boot time
	 * @return - File array
	 */
    public File[] searchSpe(String devName, String description, Long time) throws RemoteException {
        File fileFind = new File("./src/RMI2/data/");
        String name1 = devName + "-" + description + "-" + time;
        File[] matchingFiles = fileFind.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
              return name.startsWith(name1) && name.endsWith(".spc");
            }
          });    
        return matchingFiles; 
    }
    /**
	 * return current Spectrum List
	 * @return - TimeHisotry objects List
	 */
    public List<Spectrum<Double>> getListSpe() throws RemoteException {
        return dataSpectrums;
    }
 
}
