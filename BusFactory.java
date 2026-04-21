public class BusFactory {
    
    public static BusManager createBus(String busType, String vehicleId, String vehicleName, int capacity, 
                                       String driverName, String busNumber, String routeAssigned, String specificAttribute) {
        
        switch (busType.toLowerCase()) {
            case "city":
                boolean isLowFloor = Boolean.parseBoolean(specificAttribute);
                return new CityBus(vehicleId, vehicleName, capacity, "Diesel", "Depot", "Idle", driverName, busNumber, routeAssigned, isLowFloor);
            
            case "express":
                int stops = Integer.parseInt(specificAttribute);
                return new ExpressBus(vehicleId, vehicleName, capacity, "Diesel", "Depot", "Idle", driverName, busNumber, routeAssigned, stops);
            
            case "luxury":
                boolean hasWifi = Boolean.parseBoolean(specificAttribute);
                return new LuxuryBus(vehicleId, vehicleName, capacity, "Diesel", "Depot", "Idle", driverName, busNumber, routeAssigned, hasWifi);
            
            case "school":
                return new SchoolBus(vehicleId, vehicleName, capacity, "Diesel", "Depot", "Idle", driverName, busNumber, routeAssigned, specificAttribute);
            
            case "tourist":
                return new TouristBus(vehicleId, vehicleName, capacity, "Diesel", "Depot", "Idle", driverName, busNumber, routeAssigned, specificAttribute);
            
            case "electric":
                int battery = Integer.parseInt(specificAttribute);
                return new ElectricBus(vehicleId, vehicleName, capacity, "Depot", "Idle", driverName, busNumber, routeAssigned, battery);
                
            default:
                System.out.println("Error: Invalid bus type provided to factory.");
                return null;
        }
    }
}
