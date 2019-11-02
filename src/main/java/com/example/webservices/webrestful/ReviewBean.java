package com.example.webservices.webrestful;

public class ReviewBean {
    private final String id;
    private final String suitableRamp;
    private final String cleanliness;
    private final String areAllAreasAccessible;
    private final String easeOfMovement;
    private final String seatingSuitability;
    private final Boolean lift;
    private final Boolean stairs;
    private final Boolean fullWheelchairAccessibleManual;
    private final Boolean fullWheelchairAccessibleElectric;
    private final Boolean keyRequiredFromStaff;
    private final Boolean serviceCounter;
    private final Boolean tableService;

    public String getId() {
        return id;
    }

    public String getsuitableRamp() {

        return suitableRamp;
    }

    private String getAreAllAreasAccessible() {
        return areAllAreasAccessible;
    }

    private String getEaseOfMovement() {
        return easeOfMovement;
    }

    private String getSeatingSuitability() {
        return seatingSuitability;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    private Boolean getServiceCounter() {
        return serviceCounter;
    }

    private Boolean getTableService() {
        return tableService;
    }

    public Boolean getLift() {

        return lift;
    }

    public Boolean getStairs() {

        return stairs;
    }

    public Boolean getfullWheelchairAccessibleManual() {
        return fullWheelchairAccessibleManual;
    }

    public Boolean getfullWheelchairAccessibleElectric() {
        return fullWheelchairAccessibleElectric;
    }

    private Boolean getKeyRequiredFromStaff() {
        return keyRequiredFromStaff;
    }

    @Override
    public String toString() {
        return "Review  Bean{" +
                "id=" + id +
                ", suitableRamp='" + suitableRamp + '\'' +
                ", lift='" + lift + '\'' +
                ", stairs='" + stairs + '\'' +
                ", fullWheelchairAccessibleManual='" + fullWheelchairAccessibleManual + '\'' +
                ", fullWheelchairAccessibleElectric='" + fullWheelchairAccessibleElectric + '\'' +
                ", cleanliness='" + cleanliness + '\'' +
                ", keyRequiredFromStaff='" + keyRequiredFromStaff + '\'' +
                ", areAllAreasAccessible='" + areAllAreasAccessible + '\'' +
                ", easeOfMovement='" + easeOfMovement + '\'' +
                ", SeatingSuitability='" + seatingSuitability + '\'' +
                ", serviceCounter='" + serviceCounter + '\'' +
                ", tableService='" + tableService + '\'' +
                '}';
    }

    public ReviewBean(String id, String suitableRamp, Boolean lift, Boolean stairs, Boolean fullWheelchairAccessibleManual, Boolean fullWheelchairAccessibleElectric, String cleanliness,
                      Boolean keyRequiredFromStaff, String areAllAreasAccessible, String easeOfMovement, String seatingSuitability, Boolean serviceCounter, Boolean tableService) {
        this.id = id;
        this.suitableRamp = suitableRamp;
        this.lift = lift;
        this.stairs = stairs;
        this.fullWheelchairAccessibleManual = fullWheelchairAccessibleManual;
        this.fullWheelchairAccessibleElectric = fullWheelchairAccessibleElectric;
        this.cleanliness = cleanliness;
        this.keyRequiredFromStaff = keyRequiredFromStaff;
        this.areAllAreasAccessible = areAllAreasAccessible;
        this.easeOfMovement = easeOfMovement;
        this.seatingSuitability = seatingSuitability;
        this.serviceCounter = serviceCounter;
        this.tableService = tableService;
    }
}
