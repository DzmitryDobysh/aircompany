import models.MilitaryPlaneTypes;
import planes.BasePlane;
import planes.ExperimentalBasePlane;
import planes.MilitaryBasePlane;
import planes.PassengerBasePlane;

import java.util.*;

/**
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */

public class Airport {
    private List<? extends BasePlane> planes;

    public Airport(List<? extends BasePlane> planes) {
        this.planes = planes;
    }


    public List<PassengerBasePlane> getPassengerPlanes() {
        List<? extends BasePlane> l = this.planes;
        List<PassengerBasePlane> x = new ArrayList<>();
        for (BasePlane p : l) {
            if (p instanceof PassengerBasePlane) {
                x.add((PassengerBasePlane) p);
            }
        }
        return x;
    }

    public List<MilitaryBasePlane> getMilitaryPlanes() {
        List<MilitaryBasePlane> militaryPlanes = new ArrayList<>();
        for (BasePlane basePlane : planes) {
            if (basePlane instanceof MilitaryBasePlane) {
                militaryPlanes.add((MilitaryBasePlane) basePlane);
            } else {

            }
        }
        return militaryPlanes;
    }

    public PassengerBasePlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerBasePlane> passengerPlanes = getPassengerPlanes();
        PassengerBasePlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }


        return planeWithMaxCapacity;
    }

    public List<MilitaryBasePlane> getTransportMilitaryPlanes() {
        List<MilitaryBasePlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryBasePlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryBasePlane plane = militaryPlanes.get(i);
            if (plane.getPlaneType() == MilitaryPlaneTypes.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryBasePlane> getBomberMilitaryPlanes() {
        List<MilitaryBasePlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryBasePlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            MilitaryBasePlane plane = militaryPlanes.get(i);
            if (plane.getPlaneType() == MilitaryPlaneTypes.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalBasePlane> getExperimentalPlanes() {
        List<ExperimentalBasePlane> ExperimentalPlanes = new ArrayList<>();
        for (BasePlane basePlane : planes) {
            if (basePlane instanceof ExperimentalBasePlane) {
                ExperimentalPlanes.add((ExperimentalBasePlane) basePlane);
            }
        }
        return ExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<BasePlane>() {
            public int compare(BasePlane o1, BasePlane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }

    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<BasePlane>() {
            public int compare(BasePlane o1, BasePlane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<BasePlane>() {
            public int compare(BasePlane o1, BasePlane o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends BasePlane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends BasePlane> collection) {
        Iterator<? extends BasePlane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            BasePlane basePlane = iterator.next();
            System.out.println(basePlane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
