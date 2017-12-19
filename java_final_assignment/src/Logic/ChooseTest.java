package Logic;

import Sql.TestData;
import Windows.ChooseTestWindows;
import Windows.TestWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ChooseTest {
    private ChooseTestWindows chooseTestWindows;
    private TestWindows testWindows;

    public ChooseTest(ChooseTestWindows chooseTestWindows) {
        this.chooseTestWindows = chooseTestWindows;
        this.chooseTestWindows.getGET4TestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toTestWindows("ylbQuestionBankGet4");
            }
        });
        this.chooseTestWindows.getGET6TestButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toTestWindows("ylbQuestionBankGet6");
            }
        });
    }

    public TestWindows getTestWindows() {
        return testWindows;
    }

    public void setTestWindows(TestWindows testWindows) {
        this.testWindows = testWindows;
    }

    private void toTestWindows(String tableName) {
        try {
            TestData.importQuestionBank(tableName);
        } catch (SQLException ss) {
            ss.printStackTrace();
        }
        testWindows.setVisible(true);
        chooseTestWindows.setVisible(false);
    }
}
