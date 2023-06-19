import models.MilitaryPlaneTypes;
import planes.BasePlane;
import planes.MilitaryBasePlane;
import planes.PassengerBasePlane;

import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<BasePlane> planes = Arrays.asList(
            new PassengerBasePlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerBasePlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerBasePlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerBasePlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerBasePlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerBasePlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerBasePlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerBasePlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryBasePlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneTypes.BOMBER),
            new MilitaryBasePlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneTypes.BOMBER),
            new MilitaryBasePlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneTypes.BOMBER),
            new MilitaryBasePlane("F-15", 1500, 12000, 10000, MilitaryPlaneTypes.FIGHTER),
            new MilitaryBasePlane("F-22", 1550, 13000, 11000, MilitaryPlaneTypes.FIGHTER),
            new MilitaryBasePlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneTypes.TRANSPORT)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());

        System.out.println("BasePlane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
