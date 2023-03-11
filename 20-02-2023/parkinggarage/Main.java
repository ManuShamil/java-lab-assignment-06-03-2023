package parkinggarage;

import java.util.ArrayList;

// 6. A parking garage charges a $2.00 minimum fee to park for up to three hours. The garage charges an
// additional $0.50 per hour for each hour or part thereof in excess of three hours. The maximum charge
// for any given 24-hour period is $10.00. Assume that no car parks for longer than 24 hours at a time.
// Write an application that calculates and displays the parking charges for each customer who parked in
// the garage yesterday. You should enter the hours parked for each customer. The program should display
// the charge for the current customer and should calculate and display the running total of yesterday’s
// receipts. It should use the method calculateCharges to determine the charge for each customer.

class Garage {

    ArrayList<VehicleSlot> vehicles;
    Garage() {
        this.vehicles = new ArrayList<VehicleSlot>();
    }

    void AddVehicle( VehicleSlot vehicle ) {
        this.vehicles.add( vehicle );
    }

    double calculateRunningTotal() {
        double total = 0.0;
        for ( VehicleSlot vehicle : this.vehicles )
            total += vehicle.calculateCharges();
        return total;
    }
}

class VehicleSlot {
    
    private static float BASE_PRICE = 2.0f;
    private static float HOURLY_PRICE = 0.5f;
    private static float MAX_PRICE = 10.0f;

    private int hoursParked;
    VehicleSlot() {
        this.hoursParked = 0;
    }
    void setHoursParked( int hoursParked ) {
        this.hoursParked = hoursParked;
    }
    int getHoursParked() {
        return this.hoursParked;
    }
    double calculateCharges() {
        if ( this.hoursParked <= 3 )
            return BASE_PRICE;
        
        if ( this.hoursParked >= 24)
            return MAX_PRICE;

        return BASE_PRICE + ( ( this.hoursParked - 3 ) * HOURLY_PRICE );
    }
}


public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();
        VehicleSlot vehicle = new VehicleSlot();
        vehicle.setHoursParked( 2 );
        garage.AddVehicle( vehicle );
        vehicle = new VehicleSlot();
        vehicle.setHoursParked( 4 );
        garage.AddVehicle( vehicle );
        vehicle = new VehicleSlot();
        vehicle.setHoursParked( 24 );
        garage.AddVehicle( vehicle );
        System.out.println( "Running Total: " + garage.calculateRunningTotal() );

        for ( VehicleSlot slot: garage.vehicles )
            System.out.println( "Vehicle parked for " + slot.getHoursParked() + " hours, charged $ " + slot.calculateCharges() );
    }
}
