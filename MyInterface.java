package RMI2;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import v1.Spectrum;
import v1.TimeHistory;

public interface MyInterface extends Remote{
    boolean registerTimeHistory(TimeHistory dataTimeHistory) throws RemoteException;
    List<TimeHistory> getListTim() throws RemoteException;
    boolean registerSpectrum(Spectrum<Double> dataSpectrum) throws RemoteException;
    List<Spectrum<Double>> getListSpe() throws RemoteException;
    File[] searchTim(String devName) throws RemoteException;
    File[] searchTim(String devName, String description) throws RemoteException;
    File[] searchTim(String devName, String description, Long time) throws RemoteException;
    File[] searchSpe(String devName) throws RemoteException;
    File[] searchSpe(String devName, String description) throws RemoteException;
    File[] searchSpe(String devName, String description, Long time) throws RemoteException;
    boolean saveToFileTimeHistory (int listNumber) throws RemoteException;
}


