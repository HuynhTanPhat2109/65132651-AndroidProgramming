package ntu.tanphat.testgk;

import java.sql.Time;

public class LandScape {
    String landImageFileName;
    String landCaption;
    String landTime;

    public LandScape(String landImageFileName, String landCaption, String landTime) {
        this.landImageFileName = landImageFileName;
        this.landCaption = landCaption;
        this.landTime = landTime;
    }

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }

    public String getLandCaption() {
        return landCaption;
    }

    public void setLandCaption(String landCaption) {
        this.landCaption = landCaption;
    }

    public String getLandTime() {
        return landTime;
    }

    public void setLandTime(String landTime) {
        this.landTime = landTime;
    }
}
