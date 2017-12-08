package Logic;

import java.sql.*;

public class SqlHelper {
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ylb";
    private static String userName = "sa";
    private static String userPwd = "123456";

    public static Connection getCoonection() {
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL, userName, userPwd);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("----------------����ʧ��");
        }
        return null;
    }

    public static ResultSet executeQuery(String SQL) {
        try {
            Connection conn = getCoonection();
            System.out.println("---------------�������ݿ�ɹ�");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("----------------��ѯʧ��");
        }
        return null;
    }

    // ��ѯ����������˼
    public static ResultSet search_word_meaning() {
        String SQL = "select * from ylbWord";
        return SqlHelper.executeQuery(SQL);
    }

    //д��ɼ�
    public static void write_grade(String name, String word, int right, int wrong) {
        try {
            String SQL = "insert into ylbGrade(userName,word,[right],wrong) values(?,?,?,?)";
            PreparedStatement pstmt = getCoonection().prepareStatement(SQL);
            pstmt.setString(1, name);
            pstmt.setString(2, word);
            pstmt.setInt(3, right);
            pstmt.setInt(4, wrong);
            pstmt.executeUpdate();
            System.out.println("����ɼ��ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            change_grade(name, word, right, wrong);
            System.out.println("----------------����ɼ�ʧ��");
        }
    }

    //�޸ĳɼ�
    public static void change_grade(String name, String word, int right, int wrong) {
        try {
            String SQL = "update ylbGrade set [right] = [right] + ?,wrong = wrong + ? where userName = ? and word = ?";
            PreparedStatement pstmt = getCoonection().prepareStatement(SQL);
            pstmt.setInt(1, right);
            pstmt.setInt(2, wrong);
            pstmt.setString(3, name);
            pstmt.setString(4, word);
            pstmt.executeUpdate();
            System.out.println("----------------�޸ĳɼ��ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------�޸ĳɼ�ʧ��");
        }
    }

    //�����µ��ʺ�����
    public static void write_userInfo(String user, String password) {
        try {
            String SQL = "insert into ylbUserInfo(userName,password) values(?,?)";
            PreparedStatement pstmt = getCoonection().prepareStatement(SQL);
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("----------------�����ʺ�����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------�����ʺ�����ʧ��");
        }
    }

    //��ȡ�ʺ�����
    public static boolean check_userInfo(String user, String passWord) {
        try {
            String SQL = "select userName,passWord from ylbUserInfo where userName= ? and passWord= ? ";
            PreparedStatement pstmt = getCoonection().prepareStatement(SQL);
            pstmt.setString(1, user);
            pstmt.setString(2, passWord);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("----------------��ȡ�ʺ�����ɹ�");
            if (rs.next()) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------��ȡ�ʺ�����ʧ��");
        }
        return false;
    }

    public static boolean check_Info(String user) {
        try {
            String SQL = "select userName,passWord from ylbUserInfo where userName= ? ";
            PreparedStatement pstmt = getCoonection().prepareStatement(SQL);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------����ʧ��");
        }
        return false;
    }

    // question
    public static ResultSet read_questin(String table_name) {
        try {
            String SQL = "select * from " + table_name;
            PreparedStatement pstmt = SqlHelper.getCoonection().prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------����ʧ��");
        }
        return null;
    }

    public static ResultSet read_gread() {
        String SQL = "select g.word,1.0*sum([right])/( sum([right])+sum(wrong)) r from ylbGrade  g join ylbWord w on g.word=w.word group by g.word";
        return SqlHelper.executeQuery(SQL);
    }
}