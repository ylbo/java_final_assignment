package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class TestData {
    public static ArrayList<ArrayList<String>> question = new ArrayList<ArrayList<String>>();

    public static void importQuestionBank(String tableName) throws SQLException {
        ResultSet rs = importQuestion(tableName);
        while (rs.next()) {
            ArrayList<String> arr = new ArrayList<String>();
            arr.add(rs.getString("question"));
            for (int i = 0; i < 4; i++) {
                arr.add(rs.getString("option" + (i + 1)));
            }
            arr.add(rs.getString("rightOption"));
            question.add(arr);
        }
        Collections.reverse(question);
        rs.close();
    }

    private static ResultSet importQuestion(String table_name) {
        try {
            String SQL = "select * from " + table_name;
            PreparedStatement pstmt = SqlHelper.getCoonection().prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------¸üÐÂÊ§°Ü");
        }
        return null;
    }
}
