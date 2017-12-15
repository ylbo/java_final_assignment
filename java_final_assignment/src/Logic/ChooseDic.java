package Logic;

import Windows.ChooseDicWindows;
import Windows.TestWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ChooseDic {
    private ChooseDicWindows chooseDicWindows;
    private TestWindows testWindows;
    private Test test;

    public ChooseDic(ChooseDicWindows chooseDicWindows, TestWindows testWindows, Test test) {
        this.chooseDicWindows = chooseDicWindows;
        this.testWindows = testWindows;
        this.test = test;
        this.chooseDicWindows.getGET4TestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toTestWindows("ylbQuestionBankGet4");
            }
        });
        this.chooseDicWindows.getGET6TestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toTestWindows("ylbQuestionBankGet6");
            }
        });
    }

    private void toTestWindows(String tableName) {
        try {
            importQuestionBank(tableName);
        } catch (SQLException ss) {
            ss.printStackTrace();
        }
        testWindows.setVisible(true);
        chooseDicWindows.setVisible(false);
        test.test();
    }

    private void importQuestionBank(String tableName) throws SQLException {
        ResultSet rs = SqlHelper.inportQuestion(tableName);
        while (rs.next()) {
            ArrayList<String> arr = new ArrayList<String>();
            arr.add(rs.getString("question"));
            for (int i = 0; i < 4; i++) {
                arr.add(rs.getString("option" + (i + 1)));
            }
            arr.add(rs.getString("rightOption"));
            test.question.add(arr);
        }
        Collections.reverse(test.question);
        rs.close();
    }
}
