package planes;

import models.MilitaryPlaneTypes;

import java.util.Objects;

public class MilitaryBasePlane extends BasePlane {

    private MilitaryPlaneTypes planeType;

    public MilitaryBasePlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryPlaneTypes planeType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.planeType = planeType;
    }

    public MilitaryPlaneTypes getPlaneType() {
        return planeType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + planeType +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryBasePlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryBasePlane that = (MilitaryBasePlane) o;
        return planeType == that.planeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), planeType);
    }
}
