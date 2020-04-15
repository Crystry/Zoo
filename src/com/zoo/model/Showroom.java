package com.zoo.model;

public class Showroom {
    private String ShowroomName;
    private String ShowroomIntroduction;
    private String ShowroomLocation;
    private String ShowroomLocationSize;
    private String ShowroonKeeper;
    public String getShowroomName() {
        return ShowroomName;
    }

    public void setShowroomName(String showroomName) {
        ShowroomName = showroomName;
    }

    public String getShowroomIntroduction() {
        return ShowroomIntroduction;
    }

    public void setShowroomIntroduction(String showroomIntroduction) {
        ShowroomIntroduction = showroomIntroduction;
    }

    public String getShowroomLocation() {
        return ShowroomLocation;
    }

    public void setShowroomLocation(String showroomLocation) {
        ShowroomLocation = showroomLocation;
    }

    public String getShowroomLocationSize() {
        return ShowroomLocationSize;
    }

    public void setShowroomLocationSize(String showroomLocationSize) {
        ShowroomLocationSize = showroomLocationSize;
    }

    public String getShowroonKeeper() {
        return ShowroonKeeper;
    }

    public void setShowroonKeeper(String showroonKeeper) {
        ShowroonKeeper = showroonKeeper;
    }

    @Override
    public String toString() {
        return "Showroom{" +
                "ShowroomName='" + ShowroomName + '\'' +
                ", ShowroomIntroduction='" + ShowroomIntroduction + '\'' +
                ", ShowroomLocation='" + ShowroomLocation + '\'' +
                ", ShowroomLocationSize='" + ShowroomLocationSize + '\'' +
                '}';
    }
}
