package zystem_design;

/*
*

abstract class Gate {
    int gateId;
}

class EntryGate extends Gate {
    Ticket processEntry(Vehicle v) {
        ParkingLot lot = ParkingLot.getInstance();
        return lot.park(v);
    }
}

class ExitGate extends Gate {
    double processExit(Ticket t) {
        ParkingLot lot = ParkingLot.getInstance();
        lot.unpark(t);
        return lot.calculateFee(t);
    }
}


* class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors = new ArrayList<>();
    PricingStrategy pricingStrategy = new HourlyPricing();

    private ParkingLot() {}

    public static synchronized ParkingLot getInstance() {
        if (instance == null) instance = new ParkingLot();
        return instance;
    }

    public synchronized void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public synchronized Ticket park(Vehicle v) {
        for (ParkingFloor floor : floors) {
            Ticket t = floor.park(v);
            if (t != null) return t;
        }
        return null;
    }

    public synchronized void unpark(Ticket t) {
        for (ParkingFloor floor : floors) {
            if (floor.floorId == t.floorId) {
                floor.unpark(t);
                return;
            }
        }
    }

    public synchronized double calculateFee(Ticket t) {
        long end = System.currentTimeMillis();
        return pricingStrategy.calculateFee(t.startTime, end);
    }
}

class ParkingFloor {
    int floorId;
    List<ParkingSpot> spots = new ArrayList<>();

    public synchronized Ticket park(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.canFit(v)) {
                spot.park(v);
                return new Ticket(
                    UUID.randomUUID().toString(),
                    floorId,
                    spot.spotId,
                    System.currentTimeMillis()
                );
            }
        }
        return null;
    }

    public synchronized void unpark(Ticket t) {
        for (ParkingSpot spot : spots) {
            if (spot.spotId == t.spotId) {
                spot.free();
                return;
            }
        }
    }
}

class HourlyPricing implements PricingStrategy {
    double ratePerHour = 10.0;

    public double calculateFee(long start, long end) {
        long durationMs = end - start;
        double hours = Math.ceil(durationMs / (1000.0 * 60 * 60));
        return hours * ratePerHour;
    }
}

class Ticket {
    String ticketId;
    int floorId;
    int spotId;
    long startTime;

    Ticket(String id, int f, int s, long time) {
        ticketId = id;
        floorId = f;
        spotId = s;
        startTime = time;
    }
}

abstract class ParkingSpot {
    int spotId;
    boolean isFree = true;
    VehicleType allowedType;
    Vehicle parkedVehicle;

    boolean canFit(Vehicle v) {
        return isFree && v.type == allowedType;
    }

    void park(Vehicle v) {
        isFree = false;
        parkedVehicle = v;
    }

    void free() {
        isFree = true;
        parkedVehicle = null;
    }
}

abstract class Vehicle {
    String plateNumber;
    VehicleType type;
}

enum VehicleType {
    MOTORCYCLE,
    COMPACT,
    LARGE,
    HANDICAPPED
}


*/