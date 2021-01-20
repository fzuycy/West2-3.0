package company;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetData {
    public  String getData(String country) throws Exception {
        //利用httpcomponent相关jar包里的方法从网站上获取json字符串
        HttpGet get=new HttpGet("https://covid-api.mmediagroup.fr/v1/cases?country="+country);
        CloseableHttpClient client= HttpClients.createDefault();
        CloseableHttpResponse response=client.execute(get);
        String res=null;
        if(response.getCode()==200)
        {
            HttpEntity entity=response.getEntity();
            InputStream in=entity.getContent();
            res=readResponse(in);
        }
        return res;//返回取得的json字符串
    }
    public  String  readResponse(InputStream in)throws Exception//读取输入流
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String str="";
        String tmp=null;
        while ((tmp=reader.readLine())!=null)
        {
            System.out.println(tmp);
            str+=tmp;
        }
        return str;
    }

}
