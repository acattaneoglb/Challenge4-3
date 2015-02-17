package co.mobilemakers.wikipediatrekships;

/**
 * Star Trek ship model class(*).
 *
 * (*) Java class, not ship class.
 *
 * Created by ariel.cattaneo on 17/02/2015.
 */
public class ShipModel {
    private String mName;
    private String mRegistry;
    private String mShipClass;
    private int mYearLaunched;
    private String mFirstAppearance;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRegistry() {
        return mRegistry;
    }

    public void setRegistry(String registry) {
        mRegistry = registry;
    }

    public String getShipClass() {
        return mShipClass;
    }

    public void setShipClass(String shipClass) {
        mShipClass = shipClass;
    }

    public int getYearLaunched() {
        return mYearLaunched;
    }

    public void setYearLaunched(int yearLaunched) {
        mYearLaunched = yearLaunched;
    }

    public String getFirstAppearance() {
        return mFirstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        mFirstAppearance = firstAppearance;
    }

    @Override
    public String toString() {
        return mName + " (" + mRegistry + ")";
    }
}
