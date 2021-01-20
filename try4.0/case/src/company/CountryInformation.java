package company;

import java.util.ArrayList;
import java.util.List;

public class CountryInformation {
    All all;
    List<Province> provinces=new ArrayList<>();
    public CountryInformation(){}

    public void setAll(All all) {
        this.all = all;
    }
    //通过getProvences 取得可变长数据的引用
    public void Add(Province province)
    {
        provinces.add(province);
    }

    public All getAll() {
        return all;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinceOfName(String name)
    {
        Province province = provinces.get(provinces.size()-1);
        province.setLocationName(name);
    }

    @Override
    public String toString() {
        return "CountryInformation{" +
                "all=" + all +
                ", provinces=" + provinces +
                '}';
    }
}
