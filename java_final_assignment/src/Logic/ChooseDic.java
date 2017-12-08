package Logic;

import Windows.ChooseDicWindows;
import Windows.TestWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChooseDic {
    private ChooseDicWindows chooseDicWindows;
    private TestWindows testWindows;
    private Test test;
    private ActionListener get4_to_test = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                import_get4_word();
            } catch (Exception ss) {
                ss.printStackTrace();
            }
            testWindows.setVisible(true);
            chooseDicWindows.setVisible(false);
            test.test();
        }
    };
    private ActionListener get6_to_test = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            import_get6_word();
            testWindows.setVisible(true);
            chooseDicWindows.setVisible(false);
            test.test();
        }
    };

    public ChooseDic(ChooseDicWindows chooseDicWindows, TestWindows testWindows, Test test) {
        this.chooseDicWindows = chooseDicWindows;
        this.testWindows = testWindows;
        this.test = test;
        this.chooseDicWindows.getGet4().addActionListener(get4_to_test);
        this.chooseDicWindows.getGet6().addActionListener(get6_to_test);
    }

    private void import_get4_word() throws SQLException {
        ResultSet rs = SqlHelper.read_questin("questionBank");
        while (rs.next()) {
            ArrayList<String> arr = new ArrayList<String>();
            arr.add(rs.getString("question"));
            arr.add(rs.getString("option1"));
            arr.add(rs.getString("option2"));
            arr.add(rs.getString("rightOption"));
            test.question.add(arr);
        }
    }

    private void import_get6_word() {

    }
}
