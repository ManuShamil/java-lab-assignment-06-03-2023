package RMIExercise;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Java Program to send Timestamp from server to client using RMI.
 */

interface PerfectTime1 extends Remote {
    long getPerfectTime() throws RemoteException;
}

class PerfectTime implements PerfectTime1 {

    public PerfectTime() throws RemoteException {

    }

    @Override
    public long getPerfectTime() throws RemoteException {
        return System.currentTimeMillis();
    }

}


public class Main {
    public static void main(String[] args) throws RemoteException, InterruptedException{
        PerfectTime server = new PerfectTime();
        server.wait();

    }
}