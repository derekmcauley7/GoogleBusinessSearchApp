package com.example.webservices.webrestful;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

    @Id
    private String id;
    private double overAllRating;
    private String suitableRamp;
    private String toilet;
    private String cleanliness;
    private String areAllAreasAccessible;
    private String easeOfMovement;
    private String seatingSuitability;
    private String lift;
    private String stairs;
    private String fullWheelchairAccessibleManual;
    private String fullWheelchairAccessibleElectric;
    private String keyRequiredFromStaff;
    private String serviceCounter;
    private String tableService;
    private String content;

    public Review() {  }

    public Review(String id, String placesId, String overAllRating, String suitableRamp, String toilet, String cleanliness,
                  String areAllAreasAccessible, String easeOfMovement, String seatingSuitability, String lift, String stairs,
                  String fullWheelchairAccessibleManual, String fullWheelchairAccessibleElectric, String keyRequiredFromStaff,
                  String serviceCounter, String tableService, String content) {
        this.setId(id);
        this.setPlacesId(placesId);
        this.setSuitableRamp(suitableRamp);
        this.setToilet(toilet);
        this.setCleanliness(cleanliness);
        this.setAreAllAreasAccessible(areAllAreasAccessible);
        this.setEaseOfMovement(easeOfMovement);
        this.setSeatingSuitability(seatingSuitability);
        this.setLift(lift);
        this.setStairs(stairs);
        this.setFullWheelchairAccessibleElectric(fullWheelchairAccessibleElectric);
        this.setFullWheelchairAccessibleManual(fullWheelchairAccessibleManual);
        this.setKeyRequiredFromStaff(keyRequiredFromStaff);
        this.setServiceCounter(serviceCounter);
        this.setTableService(tableService);
        this.setContent(content);
        Double totalRating = Double.parseDouble(createtOverAllRating());
        this.setOverAllRating(totalRating);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlacesId() {
        return placesId;
    }

    public void setPlacesId(String placesId) {
        this.placesId = placesId;
    }

    private String placesId;

    public double getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(double overAllRating) {
        this.overAllRating = overAllRating;
    }

    public String getSuitableRamp() {
        return suitableRamp;
    }

    public void setSuitableRamp(String suitableRamp) {
        this.suitableRamp = suitableRamp;
    }

    public String getToilet() {
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getAreAllAreasAccessible() {
        return areAllAreasAccessible;
    }

    public void setAreAllAreasAccessible(String areAllAreasAccessible) {
        this.areAllAreasAccessible = areAllAreasAccessible;
    }

    public String getEaseOfMovement() {
        return easeOfMovement;
    }

    public void setEaseOfMovement(String easeOfMovement) {
        this.easeOfMovement = easeOfMovement;
    }

    public String getSeatingSuitability() {
        return seatingSuitability;
    }

    public void setSeatingSuitability(String seatingSuitability) {
        this.seatingSuitability = seatingSuitability;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public String getStairs() {
        return stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public String getFullWheelchairAccessibleManual() {
        return fullWheelchairAccessibleManual;
    }

    public void setFullWheelchairAccessibleManual(String fullWheelchairAccessibleManual) {
        this.fullWheelchairAccessibleManual = fullWheelchairAccessibleManual;
    }

    public String getFullWheelchairAccessibleElectric() {
        return fullWheelchairAccessibleElectric;
    }

    public void setFullWheelchairAccessibleElectric(String fullWheelchairAccessibleElectric) {
        this.fullWheelchairAccessibleElectric = fullWheelchairAccessibleElectric;
    }

    public String getKeyRequiredFromStaff() {
        return keyRequiredFromStaff;
    }

    public void setKeyRequiredFromStaff(String keyRequiredFromStaff) {
        this.keyRequiredFromStaff = keyRequiredFromStaff;
    }

    public String getServiceCounter() {
        return serviceCounter;
    }

    public void setServiceCounter(String serviceCounter) {
        this.serviceCounter = serviceCounter;
    }

    public String getTableService() {
        return tableService;
    }

    public void setTableService(String tableService) {
        this.tableService = tableService;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "com.example.webservices.webrestful.Review{" +
                "id=" + id +
                ", title='" + placesId + '\'' +
                ", content='" + content + '\'' +
                '}';
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
        Review.CalculateRatingForQuestions calculateRatingForQuestions = new Review.CalculateRatingForQuestions(totalRating, totalItems).invoke();
        totalRating = calculateRatingForQuestions.getTotalRating();
        totalItems = calculateRatingForQuestions.getTotalItems();

        totalRating = totalRating /totalItems;
        return totalRating.toString();
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

        public Review.CalculateRatingForQuestions invoke() {
            if(Review.this.toilet == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.toilet == "no") {
                totalRating = totalRating - 25;
                totalItems = totalItems+1;
            }
            if(Review.this.lift == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.lift == "no") {
                totalRating = totalRating + 1;
                totalItems = totalItems+1;
            }
            if(Review.this.stairs == "yes") {
                totalRating = totalRating + 0;
                totalItems = totalItems+1;
            } else if (Review.this.stairs == "no") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            }
            if(Review.this.fullWheelchairAccessibleManual == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.fullWheelchairAccessibleManual == "no") {
                totalRating = totalRating + 0;
                totalItems = totalItems+1;
            }
            if(Review.this.fullWheelchairAccessibleElectric == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.fullWheelchairAccessibleElectric == "no") {
                totalRating = totalRating + 0;
                totalItems = totalItems+1;
            }
            if(Review.this.keyRequiredFromStaff == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.keyRequiredFromStaff == "no") {
                totalRating = totalRating + 4;
                totalItems = totalItems+1;
            }
            if(Review.this.serviceCounter == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.serviceCounter == "no") {
                totalRating = totalRating + 2;
                totalItems = totalItems+1;
            }
            if(Review.this.tableService == "yes") {
                totalRating = totalRating + 5;
                totalItems = totalItems+1;
            } else if (Review.this.tableService == "no") {
                totalRating = totalRating + 3;
                totalItems = totalItems+1;
            }
            return this;
        }
    }
}
