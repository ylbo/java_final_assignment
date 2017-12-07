package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Data {
    //��ŵ��ʺ͵�����˼
    public static Map<String, String> word = new HashMap<String, String>();
    //����˻�����
    public static Map<String, String> userInfo = new HashMap<String, String>();
    //��¼��ȡ����
    public static Map<String, Integer> right = new HashMap<String, Integer>();
    //��¼�������
    public static Map<String, Integer> wrong = new HashMap<String, Integer>();


    //��ȡ���ʺʹ���
    public static void read_word() throws SQLException {
        String SQL = "SELECT word, meaning FROM ylbWord ";
        ResultSet rs = SqlHelper.executeQuery(SQL);
        while (rs.next()) {
            Data.word.put(rs.getString("word"), rs.getString("meaning"));
            Data.right.put(rs.getString("word"), 0);
            Data.wrong.put(rs.getString("word"), 0);
        }
        System.out.println("��ȡ�ɹ�");
    }

    //��ȡ�ʺ�����
    public static void read_userInfo() throws SQLException {
        String SQL = "SELECT userName, password FROM ylbUserInfo ";
        ResultSet rs = SqlHelper.executeQuery(SQL);
        while (rs.next()) {
            Data.userInfo.put(rs.getString("userName"), rs.getString("password"));
        }
        System.out.println("��ȡ�ɹ�");
    }

    //�����µ��ʺ�����
    public static void write_userInfo(String user, String password) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------�������ݿ�ɹ�");

            PreparedStatement pstmt = conn.prepareStatement("insert into ylbUserInfo(userName,password) values(?,?)");
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("���³ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------����ʧ��");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("�ر�ʧ��");
            }
        }
    }

    //д��ɼ�
    public static void write_grade(String name, String word, int right, int wrong) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------�������ݿ�ɹ�");

            PreparedStatement pstmt = conn.prepareStatement("insert into ylbGrade(userName,word,[right],wrong) values(?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, word);
            pstmt.setInt(3, right);
            pstmt.setInt(4, wrong);
            pstmt.executeUpdate();
            System.out.println("���³ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            change_grade(name,word,right,wrong);
            System.out.println("----------------����ʧ��");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("�ر�ʧ��");
            }
        }
    }

    //�޸ĳɼ�
    public static void change_grade(String name, String word, int right, int wrong) {
        Connection conn = null;
        try {
            conn = SqlHelper.getCoonection();
            System.out.println("---------------�������ݿ�ɹ�");

            PreparedStatement pstmt = conn.prepareStatement("update ylbGrade set [right] = [right] + ?,wrong = wrong + ? where userName = ? and word = ?");
            pstmt.setInt(1, right);
            pstmt.setInt(2, wrong);
            pstmt.setString(3, name);
            pstmt.setString(4, word);
            pstmt.executeUpdate();
            // pstmt=conn.prepareStatement("update ylbGrade set  where userName = ? and word = ?");

            System.out.println("���³ɼ��ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------����ʧ��");
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("�ر�ʧ��");
            }
        }
    }

    //��ȡ�ɼ�
    public static ResultSet read_gread(String name) {
        String SQL = "select g.word,1.0*sum([right])/( sum([right])+sum(wrong)) r from ylbGrade  g join ylbWord w on g.word=w.word group by g.word";
        return SqlHelper.executeQuery(SQL);
    }

    // ��ѯ����������˼
    public static ResultSet search_word_meaning()
    {
        String SQL = "select * from ylbWord";
        return SqlHelper.executeQuery(SQL);
    }
}
