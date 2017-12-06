package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Data {
    //存放单词和单词意思
    public static Map<String, String> word = new HashMap<String, String>();
    //存放账户密码
    public static Map<String, String> userInfo = new HashMap<String, String>();
    //记录正取次数
    public static Map<String, Integer> right = new HashMap<String, Integer>();
    //记录错误次数
    public static Map<String, Integer> wrong = new HashMap<String, Integer>();

    public static String loged_in_user_name=null;

    //读取单词和词义
    public static void read_word() throws SQLException {
        String SQL = "SELECT word, meaning FROM ylbWord ";
        ResultSet rs = SqlHelper.executeQuery(SQL);
        while (rs.next()) {
            Data.word.put(rs.getString("word"), rs.getString("meaning"));
            Data.right.put(rs.getString("word"), 0);
            Data.wrong.put(rs.getString("word"), 0);
        }
        System.out.println("读取成功");
    }

    //读取帐号密码
    public static void read_userInfo() throws SQLException {
        String SQL = "SELECT userName, password FROM ylbUserInfo ";
        ResultSet rs = SqlHelper.executeQuery(SQL);
        while (rs.next()) {
            Data.userInfo.put(rs.getString("userName"), rs.getString("password"));
        }
        System.out.println("读取成功");
    }

    //存入新的帐号密码
    public static void write_userInfo(String user, String password) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------连接数据库成功");

            PreparedStatement pstmt = conn.prepareStatement("insert into ylbUserInfo(userName,password) values(?,?)");
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------更新失败");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("关闭失败");
            }
        }
    }

    //写入成绩
    public static void write_grade(String name, String word, int right, int wrong) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------连接数据库成功");

            PreparedStatement pstmt = conn.prepareStatement("insert into ylbGrade(userName,word,[right],wrong,error) values(?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, word);
            pstmt.setInt(3, right);
            pstmt.setInt(4, wrong);
            pstmt.setFloat(5, (float) (wrong * 1.0 / (right + wrong)));
            pstmt.executeUpdate();
            System.out.println("更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------更新失败");
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
    public static void change_grade(String name, String word, int right, int wrong) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------连接数据库成功");

            PreparedStatement pstmt = conn.prepareStatement("update ylbGrade set [right] =?,wrong=?,error=? where userName=? and word=?");
            pstmt.setInt(1, right);
            pstmt.setInt(2, wrong);
            pstmt.setFloat(3, (float) (wrong * 1.0 / (right + wrong)));
            pstmt.setString(4, name);
            pstmt.setString(5, word);
            pstmt.executeUpdate();
            System.out.println("更新成绩成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------更新失败");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("关闭失败");
            }
        }
    }

    //读取成绩
    public static ResultSet read_gread(String name) {
        String SQL = "select word,error from ylbGrade where userName = " + name;
        return SqlHelper.executeQuery(SQL);
    }
}
