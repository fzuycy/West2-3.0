package company;

import com.alibaba.fastjson.annotation.JSONField;

public class All {
    @JSONField(name = "confirmed")
    private long confirm;//确诊数
    @JSONField(name = "recovered")
    private long recover;//治愈数
    private long deaths;//死亡人数
    private String country;
    private long population;
    private long sq_km_area;//占地面积
    private double life_expectancy;//预期寿命
    private long elevation_in_meters;//海拔
    private String continent;//所在大陆
    private String abbreviation;//国家缩写
    private String location;//位置
    private String iso;
    private String capital_city;
    public All()
    {

    }

    public All(long confirm, long recover, long deaths, String country, long population, long sq_km_area, double life_expectancy, long elevation_in_meters, String continent, String abbreviation, String location, String iso, String capital_city) {
        this.confirm = confirm;
        this.recover = recover;
        this.deaths = deaths;
        this.country = country;
        this.population = population;
        this.sq_km_area = sq_km_area;
        this.life_expectancy = life_expectancy;
        this.elevation_in_meters = elevation_in_meters;
        this.continent = continent;
        this.abbreviation = abbreviation;
        this.location = location;
        this.iso = iso;
        this.capital_city = capital_city;
    }

    public long getConfirm() {
        return confirm;
    }

    public void setConfirm(long confirm) {
        this.confirm = confirm;
    }

    public long getRecover() {
        return recover;
    }

    public void setRecover(long recover) {
        this.recover = recover;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getSq_km_area() {
        return sq_km_area;
    }

    public void setSq_km_area(long sq_km_area) {
        this.sq_km_area = sq_km_area;
    }

    public double getLife_expectancy() {
        return life_expectancy;
    }

    public void setLife_expectancy(double life_expectancy) {
        this.life_expectancy = life_expectancy;
    }

    public long getElevation_in_meters() {
        return elevation_in_meters;
    }

    public void setElevation_in_meters(long elevation_in_meters) {
        this.elevation_in_meters = elevation_in_meters;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCapital_city() {
        return capital_city;
    }

    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }

    @Override
    public String toString() {
        return "All{" +
                "confirm=" + confirm +
                ", recover=" + recover +
                ", deaths=" + deaths +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", sq_km_area=" + sq_km_area +
                ", life_expectancy=" + life_expectancy +
                ", elevation_in_meters=" + elevation_in_meters +
                ", continent='" + continent + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", location='" + location + '\'' +
                ", iso='" + iso + '\'' +
                ", capital_city='" + capital_city + '\'' +
                '}';
    }
}
