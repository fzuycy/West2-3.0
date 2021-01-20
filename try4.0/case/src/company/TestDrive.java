package company;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args){
        TestDrive tester=new TestDrive();
        Scanner scanner=new Scanner(System.in);
        String[]CountryName=new String[4];//存储需要查找的四个国家名字
        CountryName[0]="China";
        CountryName[1]="US";
        CountryName[2]="United%20Kingdom";
        CountryName[3]="Japan";
        GetData DataGeter=new GetData();//用于获取网站中的数据的对象
        String tmp=null;
        JSONObject obj=null;//JSON数据转化为的对象
        ParseToObject Parser=null;//用于解析JSON数据的对象
        CountryInformation countryInformation=null;//储存网站数据的java对象
        JDBC jdbc=new JDBC();//对数据库进行增删改查操作的对象
        for(int i=0;i<4;i++)
        {
            System.out.println(CountryName[i]+"'s data :");
            try {
                tmp=DataGeter.getData(CountryName[i]);//将获取到的json字符串赋给tmp
                obj= JSON.parseObject(tmp);//将json字符串解析成jsonobject
                Parser=new ParseToObject(obj);//新建一个Parser对象
                countryInformation=Parser.CreateFinalObject();//将数据保存到提前设计好结构的java对象里
                jdbc.Add("mytable_one",countryInformation.getAll());//将All类对象里存储的数据取出放入表一
                jdbc.Add("mytable_two",countryInformation.getProvinces());//将Province类对象里存储的数据取出放入表二
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while(true)//进行增改查的测试
        {
            System.out.println("现在您可以进行更新(请输入1）、查询(请输入2)、退出(请输入3)操作");
            int task;
            task=scanner.nextInt();
            if(task==1)//更新数据
            {
                for(int i=0;i<4;i++)
                {
                    try {
                        tmp= DataGeter.getData(CountryName[i]);
                        obj=JSON.parseObject(tmp);
                        Parser=new ParseToObject(obj);
                        countryInformation=Parser.CreateFinalObject();
                        jdbc.modify("mytable_one",countryInformation.getAll());//更新表一
                        jdbc.modify("mytable_two",countryInformation.getProvinces());//更新表二
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("更新数据结束！");
            }
            else if(task==2)//查询
            {
                System.out.print("如果想要查询城市，请输入4;如果想查询省份，请输入5 :");
                int task1=scanner.nextInt();
                if(task1==4)
                {
                    System.out.print("请输入想要查找的国家的英文名称缩写:");
                    String task2=scanner.next();
                    jdbc.FindCountry(task2);//查找输入国家的确诊,治愈，死亡人数
                }
                else if(task1==5)
                {
                    System.out.print("请输入想要查找的省份的英文名称:");
                    String task2=scanner.next();
                    jdbc.FindProvince(task2);//查找输入省份的确诊，治愈，死亡人数
                }
                else
                {
                    System.out.println("输入指令错误，无法继续查询");
                }
                System.out.println("查询结束！");
            }
            else if(task==3)//退出
            {
                break;
            }
            else
            {
                System.out.println("输入指令错误，请正确输入指令");
            }
        }
        System.out.println("退出成功！");
        //删数据库的方法测试
        jdbc.DeleteCountry("CN");//在表1删除China所在行的数据
        jdbc.DeleteProvince("Gansu");//在表2删除Gansu所在行的数据
    }
}
