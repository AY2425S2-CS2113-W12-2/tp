package seedu.navi.canteen.canteenfinder.userfields;

public class UserFields {
    private boolean isOrSearchType;
    private String userLocation;
    private String[] canteenCriteria;

    public UserFields(boolean isOrSearchType, String userLocation, String[] canteenCriteria) {
        this.isOrSearchType = isOrSearchType;
        this.userLocation = userLocation;
        this.canteenCriteria = canteenCriteria;
    }

    public boolean isOrSearchType() {
        return isOrSearchType;
    }

    public void setOrSearchType(boolean orSearchType) {
        isOrSearchType = orSearchType;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String[] getCanteenCriteria() {
        return canteenCriteria;
    }

    public void setCanteenCriteria(String[] canteenCriteria) {
        this.canteenCriteria = canteenCriteria;
    }
}
