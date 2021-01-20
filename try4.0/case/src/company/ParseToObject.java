package company;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.Set;

public class ParseToObject {
    private JSONObject JsonData;//json字符串解析成的对象
    Set<String> keySet;//储存json数据中的键值的集合
    public ParseToObject()
    {

    }
    public ParseToObject(JSONObject jsonData) {
        JsonData = jsonData;
    }

    public JSONObject getJsonData() {
        return JsonData;
    }

    public void setJsonData(JSONObject jsonData) {
        JsonData = jsonData;
    }

//    public void getKey()//获取关键字,然后将其输出(这个方法实际上没有用到，只是当时刚开始写的时候为了测试方便写的)
//    {
//        keySet= JsonData.keySet();
//        Iterator<String> it=keySet.iterator();//迭代器
//        while(it.hasNext())//返回的键值是乱序的（原因是其内部是用hashmap的）
//        {
//
//            String key=it.next();
//            if(key!=null) System.out.println("key ="+key);
//        }
//        //直接利用obj.getString(键值)拿到相应字段之后，直接用ParseObject函数生成相应对象(省份，all)即可
//    }
    public CountryInformation CreateFinalObject()
    {
        CountryInformation countryInformation=new CountryInformation();
        keySet=JsonData.keySet();//获取储存有json数据中的各个关键字的集合
        Iterator<String> it=keySet.iterator();
        while(it.hasNext())
        {
            String key= it.next();
            String JsonString=JsonData.getString(key);
            //将json数据分拆成两部分(All类和Province类)
            if(key.equals("All"))
            {
                countryInformation.all= JSON.parseObject(JsonString,All.class);
            }
            else
            {
                countryInformation.Add(JSON.parseObject(JsonString,Province.class));
                int sum=countryInformation.provinces.size();
                countryInformation.setProvinceOfName(key);
            }
        }
        System.out.println(countryInformation.toString());//输出解析json数据后生成的对象的信息
        return countryInformation;
    }

}
