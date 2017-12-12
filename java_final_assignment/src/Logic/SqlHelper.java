package Logic;

import java.sql.*;

public class SqlHelper {
    private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ylb";
    private static final String userName = "sa";
    private static final String userPwd = "123456";

    public static Connection getCoonection() {
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(dbURL, userName, userPwd);
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
            return stmt.executeQuery(SQL);
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
        PreparedStatement pstmt = null;
        try {
            String SQL = "insert into ylbGrade(userName,word,[right],wrong) values(?,?,?,?)";
            pstmt = getCoonection().prepareStatement(SQL);
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
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException ss) {
                ss.printStackTrace();
            }
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
            return !rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------��ȡ�ʺ�����ʧ��");
        }
        return true;
    }

    public static boolean check_Info(String user) {
        try {
            String SQL = "select userName,passWord from ylbUserInfo where userName= ? ";
            PreparedStatement pstmt = getCoonection().prepareStatement(SQL);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
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
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------����ʧ��");
        }
        return null;
    }

    public static ResultSet read_gread() {
        String SQL = "select g.word,1.0*sum(wrong)/( sum([right])+sum(wrong)) r from ylbGrade  g join ylbWord w on g.word=w.word group by g.word";
        return SqlHelper.executeQuery(SQL);
    }
}