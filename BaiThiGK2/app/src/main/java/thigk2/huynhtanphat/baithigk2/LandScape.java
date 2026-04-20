package thigk2.huynhtanphat.baithigk2;

public class LandScape {
    String landImageFileName;
    String ten;
    String quequan;

    public LandScape(String landImageFileName, String landCaption, String landTime) {
        this.landImageFileName = landImageFileName;
        this.ten = landCaption;
        this.quequan = landTime;
    }

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String landCaption) {
        this.ten = landCaption;
    }

    public String getQueQuan() {
        return quequan;
    }

    public void setQueQuan(String landTime) {
        this.quequan = landTime;
    }
}
