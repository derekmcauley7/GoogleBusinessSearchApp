package com.example.webservices.webrestful;

public class ReviewBean {
    private final String id;
    private final String placesId;
    private final String overAllRating;
    private final String suitableRamp;
    private final String toilet;
    private final String cleanliness;
    private final String areAllAreasAccessible;
    private final String easeOfMovement;
    private final String seatingSuitability;
    private final String lift;
    private final String stairs;
    private final String fullWheelchairAccessibleManual;
    private final String fullWheelchairAccessibleElectric;
    private final String keyRequiredFromStaff;
    private final String serviceCounter;
    private final String tableService;

    public String getId() {
        return id;
    }

    public String gettoilet() {
        return toilet;
    }

    public String getplacesId() {
        return placesId;
    }

    public String getsuitableRamp() {
        return suitableRamp;
    }
    public String getoverAllRating() {
        return overAllRating;
    }

    public String getareAllAreasAccessible() {
        return areAllAreasAccessible;
    }

    public String getEaseOfMovement() {
        return easeOfMovement;
    }

    public String getSeatingSuitability() {
        return seatingSuitability;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public String getServiceCounter() {
        return serviceCounter;
    }

    public String getTableService() {
        return tableService;
    }

    public String getLift() {

        return lift;
    }

    public String getStairs() {

        return stairs;
    }

    public String createtOverAllRating() {
        Double totalRating = new Double(0);
        Double totalItems = new Double(5);
        Double suitableRamp = new Double(this.suitableRamp);
        Double cleanliness = new Double(this.cleanliness);
        Double areAllAreasAccessible = new Double(this.areAllAreasAccessible);
        Double easeOfMovement = new Double(this.easeOfMovement);
        Double seatingSuitability = new Double(this.seatingSuitability);
        totalRating = totalRating + suitableRamp + cleanliness + areAllAreasAccessible + easeOfMovement + seatingSuitability;
        CalculateRatingForQuestions calculateRatingForQuestions = new CalculateRatingForQuestions(totalRating, totalItems).invoke();
        totalRating = calculateRatingForQuestions.getTotalRating();
        totalItems = calculateRatingForQuestions.getTotalItems();

        totalRating = totalRating /totalItems;
        return totalRating.toString();
    }

    public String getfullWheelchairAccessibleManual() {
        return fullWheelchairAccessibleManual;
    }

    public String getfullWheelchairAccessibleElectric() {
        return fullWheelchairAccessibleElectric;
    }

    public String getKeyRequiredFromStaff() {
        return keyRequiredFromStaff;
    }


    public ReviewBean(String id, String placesId, String suitableRamp, String toilet, String lift,
                      String stairs, String fullWheelchairAccessibleManual,
                      String fullWheelchairAccessibleElectric, String cleanliness,
                      String keyRequiredFromStaff, String areAllAreasAccessible,
                      String easeOfMovement, String seatingSuitability, String serviceCounter, String tableService) {
        this.id = id;
        this.placesId = placesId;
        this.suitableRamp = suitableRamp;
        this.toilet = toilet;
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
        this.overAllRating = createtOverAllRating();
    }

    private class CalculateRatingForQuestions {
        private Double totalRating;
        private Double totalItems;

        public CalculateRatingForQuestions(Double totalRating, Double totalItems) {
            this.totalRating = totalRating;
            this.totalItems = totalItems;
        }

        public Double getTotalRating() {
            return totalRating;
        }

        public Double getTotalItems() {
            return totalItems;
        }

        public CalculateRatingForQuestions invoke() {
            if(ReviewBean.this.toilet == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.toilet == "no") {
                totalRating = totalRating - 25;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.lift == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.lift == "no") {
                totalRating = totalRating + 1;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.stairs == "yes") {
                totalRating = totalRating + 0;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.stairs == "no") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.fullWheelchairAccessibleManual == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.fullWheelchairAccessibleManual == "no") {
                totalRating = totalRating + 0;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.fullWheelchairAccessibleElectric == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.fullWheelchairAccessibleElectric == "no") {
                totalRating = totalRating + 0;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.keyRequiredFromStaff == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.keyRequiredFromStaff == "no") {
                totalRating = totalRating + 4;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.serviceCounter == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.serviceCounter == "no") {
                totalRating = totalRating + 2;
                totalItems = totalItems+1;
            }
            if(ReviewBean.this.tableService == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (ReviewBean.this.tableService == "no") {
                totalRating = totalRating + 3;
                totalItems = totalItems+1;
            }
            return this;
        }
    }
}
