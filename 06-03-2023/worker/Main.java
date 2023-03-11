package worker;

// 1. Develop an abstract class named Worker with private data members name and address along with
// the getter and setter methods for the fields, a two-argument constructor and an abstract method called
// earnings() to compute the income of a worker. Design another class named PieceWorker that should
// contain private instance variables wage (to store the worker’s wage per piece) and pieces (to store the
// number of pieces produced). Provide a concrete implementation of the method earnings in the class
// PieceWorker that calculates the worker’s earnings by multiplying the number of pieces produced by the
// wage per piece. Develop a class containing the main method to show the invocation of the earnings( )
// method on a PieceWorker object.

abstract class Worker {
    private String workerName;
    private String workerAddress;
    Worker( String name, String address ) {
        this.workerName = name;
        this.workerAddress = address;
    }
    public String getWorkerName() {
        return this.workerName;
    }
    public String getWorkerAddress() {
        return this.workerAddress;
    }
    public void setWorkerName( String name ) {
        this.workerName = name;
    }
    public abstract double earnings();
}

class PieceWorker extends Worker {
    private double wage;
    private int pieces;
    PieceWorker( String name, String address, double wage, int pieces ) {
        super(name, address);
        this.wage = wage;
        this.pieces = pieces;
    }
    public double earnings() {
        return this.wage * this.pieces;
    }
}
public class Main {
    public static void main(String[] args) {
        PieceWorker newWorker= new PieceWorker( "John", "123 Main St", 10.00, 100);
        System.out.println(String.format("Earnings for %s: %f", newWorker.getWorkerName(), newWorker.earnings()));
    }
}