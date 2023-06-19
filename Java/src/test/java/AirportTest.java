import planes.*;
import models.PlaneClassificationLevels;
import models.ExperimentalPlaneTypes;
import models.MilitaryPlaneTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryBasePlane;
import planes.PassengerBasePlane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<BasePlane> basePlanes = Arrays.asList(
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
            new MilitaryBasePlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneTypes.TRANSPORT),
            new ExperimentalBasePlane("Bell X-14", 277, 482, 500, ExperimentalPlaneTypes.HIGH_ALTITUDE, PlaneClassificationLevels.SECRET),
            new ExperimentalBasePlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneTypes.VTOL, PlaneClassificationLevels.TOP_SECRET)
    );

    private static PassengerBasePlane planeWithMaxPassengerCapacity = new PassengerBasePlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(basePlanes);
        List<MilitaryBasePlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean flag = false;
        for (MilitaryBasePlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getPlaneType() == MilitaryPlaneTypes.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertEquals(flag, true);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(basePlanes);
        PassengerBasePlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void testPlanesSortedByMaxLoadCapacity() {
        Airport airport = new Airport(basePlanes);
        airport.sortByMaxLoadCapacity();
        List<? extends BasePlane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            BasePlane currentBasePlane = planesSortedByMaxLoadCapacity.get(i);
            BasePlane nextBasePlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentBasePlane.getMinLoadCapacity() > nextBasePlane.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        Airport airport = new Airport(basePlanes);
        List<MilitaryBasePlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean flag = false;
        for (MilitaryBasePlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getPlaneType() == MilitaryPlaneTypes.BOMBER)) {
                flag = true;
            }
            else {
                Assert.fail("Test failed!");
            }
        }
        // if not failed
    }

    @Test
    public void testExperimentalPlanesHasClassifiedLevel(){
        Airport airport = new Airport(basePlanes);
        List<ExperimentalBasePlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalBasePlane experimentalPlane : ExperimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == PlaneClassificationLevels.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
