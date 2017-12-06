package old;

import old.SqlHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] ages) throws SQLException {
        //word
        /*readWord();
        Set<String> key = old.data.word.keySet();
        for (String s : key) {
            System.out.println(s + old.data.word.get(s));
            //System.out.println(s.compareTo("123"));
        }*/

        /*readUserInfo();
        Set<String> k = old.data.userInfo.keySet();
        for(String s:k)
        {
            System.out.println(s+old.data.userInfo.get(s));
        }*/
        /*try {
            insertUserInfo("999", "123");
        } catch (SQLException e) {
            System.out.println("用户名已存在");
        }*/
        //writeGrade("robot", 1, 2, (float) (2 / 3));
        //writeGrade("robot", 1, 2);
        //changeGrade("robot", 2, 4);
        /*ResultSet set = old.data.read_gread("123");
        while(set.next())
        {
            System.out.println(set.getString("word") + "......." + show_start_number(Float.parseFloat(set.getString("error"))));
        }*/
    }

    private static String show_start_number(float f)
    {
        if(f>=Float.parseFloat("0")&&f<=Float.parseFloat("0.2"))
            return "*";
        if( f > Float.parseFloat("0.2") && f < Float.parseFloat("0.4"))
            return "**";
        if(f>=Float.parseFloat("0.4")&&f<Float.parseFloat("0.6"))
            return "***";
        if(f>=Float.parseFloat("0.6")&&f<Float.parseFloat("0.8"))
            return "****";
        if(f>=Float.parseFloat("0.8")&&f<=Float.parseFloat("1.0"))
            return "*****";
        //出错就显示6个零
        return "000000";
    }


    static String User = "999";


    //读取单词和词义
    public static void readWord() throws SQLException {
        String SQL = "SELECT word, meaning FROM ylbWord ";
        ResultSet rs = SqlHelper.executeQuery(SQL);
        while (rs.next()) {
            data.word.put(rs.getString("word"), rs.getString("meaning"));
            data.right.put(rs.getString("word"), 0);
            data.wrong.put(rs.getString("word"), 0);
        }
        System.out.println("读取成功");
    }

    //读取帐号密码
    public static void readUserInfo() throws SQLException {
        String SQL = "SELECT userName, password FROM ylbUserInfo ";
        ResultSet rs = SqlHelper.executeQuery(SQL);
        while (rs.next()) {
            data.userInfo.put(rs.getString("userName"), rs.getString("password"));
        }
        System.out.println("读取成功");
    }

    //存入新的帐号密码
    public static void writeUserInfo(String user, String password) {
        String SQL = "insert into ylbUserInfo(userName,password) values(" + user + "," + password + ")";
        if (SqlHelper.executeUpdate(SQL)) {
            System.out.println("插入成功 ");
        } else {
            System.out.println("插入失败 ");
        }
    }

    //写入成绩
    public static void writeGrade(String word, int right, int wrong) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------连接数据库成功");

            PreparedStatement pstmt = conn.prepareStatement("insert into ylbGrade(userName,word,[right],wrong,error) values(?,?,?,?,?)");
            pstmt.setString(1, User);
            pstmt.setString(2, word);
            pstmt.setInt(3, right);
            pstmt.setInt(4, wrong);
            pstmt.setFloat(5, (float) (wrong * 1.0 / (right + wrong)));
            pstmt.executeUpdate();
            System.out.println("写入成绩成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------写入成绩失败");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("关闭失败");
            }
        }
    }

    //修改成绩
    public static void changeGrade(String word, int right, int wrong) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------连接数据库成功");

            PreparedStatement pstmt = conn.prepareStatement("update ylbGrade set [right] =?,wrong=?,error=? where userName=? and word=?");
            pstmt.setInt(1, right);
            pstmt.setInt(2, wrong);
            pstmt.setFloat(3, (float) (wrong * 1.0 / (right + wrong)));
            pstmt.setString(4, User);
            pstmt.setString(5, word);
            pstmt.executeUpdate();
            System.out.println("更新成绩成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------更新成绩失败");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("关闭失败");
            }
        }
    }
}
