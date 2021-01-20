package company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    public static Connection GetConnection()//申请与MySql的链接
    {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javatest?characterEncoding=UTF-8","root","1330");
            //上面javatest是我已经用SQLyog新建好的表的表名，那个位置应该是所要操作数据库中表的表名
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
//    public void CreateTable()//新建一个表(这个方法实际上没有被现在的代码用到,只是最开始没有用SQLyong建表时用这个手动建表)
//    {
//        String sql="create table mytable (UserId int,UserName varchar(32))";
//        Connection connection=null;
//        PreparedStatement preparedStatement=null;
//        try {
//            connection=GetConnection();
//            preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            close(preparedStatement);
//            close(connection);
//        }
//    }
    public void Add(String MyTable,All all)//增(针对All类的操作，针对表一数据)
    {
        String sql="insert into "+MyTable+"(country,abbreviation,capital_city,sq_km_area,population,confirmed,recovered,deaths,continent,location,iso,elevation_in_meters,life_expectancy) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn= GetConnection();
            pstmt=(PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,all.getCountry());
            pstmt.setString(2,all.getAbbreviation());
            pstmt.setString(3,all.getCapital_city());
            pstmt.setLong(4,all.getSq_km_area());
            pstmt.setLong(5,all.getPopulation());
            pstmt.setLong(6,all.getConfirm());
            pstmt.setLong(7,all.getRecover());
            pstmt.setLong(8,all.getDeaths());
            pstmt.setString(9,all.getContinent());
            pstmt.setString(10,all.getLocation());
            pstmt.setString(11,all.getIso());
            pstmt.setLong(12,all.getElevation_in_meters());
            pstmt.setDouble(13,all.getLife_expectancy());
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            close(pstmt);
            close(conn);
        }
    }
    public void Add(String MyTable,List<Province> provinceList)//增(针对Province类的操作，针对表二数据)
    {
        String sql="insert into "+MyTable+"(LocationName,lat,mylong,confirmed,recovered,deaths,updated) values(?,?,?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn= GetConnection();
            for(int i=0;i<provinceList.size();i++)
            {
                pstmt=(PreparedStatement) conn.prepareStatement(sql);
                pstmt.setString(1,provinceList.get(i).getLocationName());
                pstmt.setDouble(2,provinceList.get(i).getLat());
                pstmt.setDouble(3,provinceList.get(i).getLong());
                pstmt.setLong(4,provinceList.get(i).getConfirm());
                pstmt.setLong(5,provinceList.get(i).getRecover());
                pstmt.setLong(6,provinceList.get(i).getDeaths());
                pstmt.setString(7,provinceList.get(i).getUpdated());
                pstmt.executeUpdate();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            close(pstmt);
            close(conn);
        }
    }
    public void DeleteCountry(String key)//以国家英文名称缩写为键值进行删除(针对表一数据)
    {
        String sql="delete from mytable_one where  abbreviation= ?";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=GetConnection();
            preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(preparedStatement);
            close(connection);
        }
    }
    public void DeleteProvince(String key)//以省份作为关键字进行删除(针对表二数据)
    {
        String sql="delete from mytable_two where LocationName = ?";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=GetConnection();
            preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,key);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(preparedStatement);
            close(connection);
        }
    }
    public void modify(String MyTable,All all)//改(针对表一的All类数据)
    {
        String sql="update "+MyTable+" set confirmed =?,recovered =?,deaths =?,life_expectancy =? where country =?";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=GetConnection();
            preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setLong(1,all.getConfirm());
            preparedStatement.setLong(2,all.getRecover());
            preparedStatement.setLong(3,all.getDeaths());
            preparedStatement.setDouble(4,all.getLife_expectancy());
            preparedStatement.setString(5,all.getCountry());
            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }
    public void modify(String MyTable,List<Province> provinceList)//改(针对表二的Province类数据)
    {
        String sql="update "+MyTable+" set lat =?,mylong =?,confirmed =?,recovered =?,deaths =?,updated=? where LocationName =?";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=GetConnection();
            for(int i=0;i<provinceList.size();i++)
            {
                preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
                Province province=provinceList.get(i);
                preparedStatement.setDouble(1,province.getLat());
                preparedStatement.setDouble(2,province.getLong());
                preparedStatement.setLong(3,province.getConfirm());
                preparedStatement.setLong(4,province.getRecover());
                preparedStatement.setLong(5,province.getDeaths());
                preparedStatement.setString(6,province.getUpdated());
                preparedStatement.setString(7,province.getLocationName());
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            close(preparedStatement);
            close(connection);
        }
    }
    public void FindCountry(String key)//以国家英文缩写进行查询操作（针对表一的All类数据）
    {
        String sql="select * from mytable_one order by abbreviation";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        //List<User> users=new ArrayList<>();
        try {
            int flag=1;
            connection=GetConnection();
            preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
            resultSet=(ResultSet) preparedStatement.executeQuery();
            while (resultSet.next())
            {
                if(key.equals(resultSet.getString("abbreviation")))
                {
                    long confirmed=resultSet.getLong("confirmed");
                    long recovered=resultSet.getLong("recovered");
                    long deaths=resultSet.getLong("deaths");
                    System.out.println(key+"'s case:"+" confirmed "+confirmed+" recovered "+recovered+" deaths "+deaths);
                    flag=0;
                    break;
                }
            }
            if(flag==1) System.out.println("没有找到相应的国家");
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
    }
    public void FindProvince(String key)//以省份为关键字进行查找操作（针对表二的Provence类数据）
    {
        String sql="select * from mytable_two order by LocationName";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            int flag=1;
            connection=GetConnection();
            preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
            resultSet=(ResultSet) preparedStatement.executeQuery();
            while (resultSet.next())
            {
                if(key.equals(resultSet.getString("LocationName")))
                {
                    long confirmed=resultSet.getLong("confirmed");
                    long recovered=resultSet.getLong("recovered");
                    long deaths=resultSet.getLong("deaths");
                    System.out.println(key+"'s case:"+" confirmed "+confirmed+" recovered "+recovered+" deaths "+deaths);
                    flag=0;
                    break;
                }
            }
            if(flag==1) System.out.println("没有找到相应的省份");
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
    }
    public void close(PreparedStatement pstmt)//释放资源
    {
        if(pstmt!=null)
        {
            try {
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void close(Connection conn)
    {
        if(conn!=null)
        {
            try {
                conn.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs)
    {
        if(rs!=null)
        {
            try {
                rs.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

}
