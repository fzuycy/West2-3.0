package company;

import com.alibaba.fastjson.annotation.JSONField;

public class Province {
    private String LocationName;//地域名
    private double lat;
    @JSONField(name = "long")
    private double Long;
    @JSONField(name = "recovered")
    private long recover;
    @JSONField(name = "confirmed")
    private long confirm;
    private long deaths;
    private String updated;//更新时间
    public Province(){}

    public Province(String locationName, double lat, double aLong, long recover, long confirm, long deaths, String updated) {
        LocationName = locationName;
        this.lat = lat;
        Long = aLong;
        this.recover = recover;
        this.confirm = confirm;
        this.deaths = deaths;
        this.updated = updated;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLong() {
        return Long;
    }

    public void setLong(double aLong) {
        Long = aLong;
    }

    public long getRecover() {
        return recover;
    }

    public void setRecover(long recover) {
        this.recover = recover;
    }

    public long getConfirm() {
        return confirm;
    }

    public void setConfirm(long confirm) {
        this.confirm = confirm;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Province{" +
                "LocationName='" + LocationName + '\'' +
                ", lat=" + lat +
                ", Long=" + Long +
                ", recover=" + recover +
                ", confirm=" + confirm +
                ", deaths=" + deaths +
                ", updated='" + updated + '\'' +
                '}';
    }
}
