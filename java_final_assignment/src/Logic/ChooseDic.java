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
    private ActionListener get4_to_test = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            to_test("ylbQuestionBankGet4");
        }
    };
    private ActionListener get6_to_test = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            to_test("ylbQuestionBankGet6");
        }
    };

    private void to_test(String table_name) {
        try {
            import_question_bank(table_name);
        } catch (SQLException ss) {
            ss.printStackTrace();
        }
        testWindows.setVisible(true);
        chooseDicWindows.setVisible(false);
        test.test();
    }

    public ChooseDic(ChooseDicWindows chooseDicWindows, TestWindows testWindows, Test test) {
        this.chooseDicWindows = chooseDicWindows;
        this.testWindows = testWindows;
        this.test = test;
        this.chooseDicWindows.getGet4().addActionListener(get4_to_test);
        this.chooseDicWindows.getGet6().addActionListener(get6_to_test);
    }

    private void import_question_bank(String table_name) throws SQLException {
        ResultSet rs = SqlHelper.read_questin(table_name);
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
