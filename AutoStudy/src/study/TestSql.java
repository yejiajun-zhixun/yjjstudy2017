package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestSql {
	
	public Connection getCon() {
        //数据库连接名称
        String username="root";
        //数据库连接密码
        String password="";
        String driver="com.mysql.jdbc.Driver";
        //其中test为数据库名称
        String url="jdbc:mysql://localhost:3306/test";
        Connection conn=null;
        try{
            Class.forName(driver);
            conn=(Connection) DriverManager.getConnection(url,username,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
	
	public List<String> getSelect() { 
//	　　　　　 sql语句
	        String sql = "select * from user"; 
//	　　　　　 获取到连接
	        Connection conn = getCon();
	        PreparedStatement pst = null;
	        // 定义一个list用于接受数据库查询到的内容
	        List<String> list = new ArrayList<String>();
	        try {
	            pst = (PreparedStatement) conn.prepareStatement(sql);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
	                list.add(rs.getString("userName"));
	            }
	        } catch (Exception e) {
	        }
	        return list;
	    }
	
	public static void main(String[] args) {
//	　　　　　	其中TestDao为类名
	        TestSql dao = new TestSql();
//	　　　　　	新建一个list得到查询方法中返回的集合
	        List<String> list = dao.getSelect();
//	　　　　　	对得到的list进行遍历输出到控制台中
	        for (int i = 0; i < list.size(); i++) {
	            System.out.println(list.get(i));
	        }
	    }
}
