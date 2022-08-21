package RMI2;

import java.io.File;
import java.util.List;

import v1.Spectrum;
import v1.TimeHistory;

public class ClientTools {

    public ClientTools(){}

    protected static void foundFiles(File[] files) {
        System.out.println("----- I found those files: ");
        if (files.length == 0) {
            System.out.println("      none, try again :(");
        } else {
            for (File x : files) {
                System.out.println("     " + x);
            }
        }
    }

    protected static void printListTim(List<TimeHistory> list){
        int count = 1;
        System.out.println("\n----- This is your Tim List: ");
        if (list.size() == 0) {
            System.out.println("      didn't find any :(");
        } else {
            for (TimeHistory x : list) {
                System.out.println("<<<< " + count + " >>>>" + x);
                count += 1;
            }
        }
        System.out.println("\n*** END  ***************************************************************************");
    }

    protected static void printListSpe(List<Spectrum<Double>> list){
        int count = 1;
        System.out.println("\n----- This is your Spe List: ");
        if (list.size() == 0) {
            System.out.println("      didn't find any :(");
        } else {
            for (Spectrum<Double> x : list) {
                System.out.println("<<<< " + count + " >>>>" + x);
                count += 1;
            }
        }
        System.out.println("\n*** END  ***************************************************************************");
    }
}
