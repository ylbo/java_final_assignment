package Logic;

import Sql.SqlHelper;
import Sql.TestData;
import Windows.TestWindows;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    private TestWindows testWindows;

    private WindowListener closeShowResultDialog = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            testWindows.getShowResultDialog().setVisible(false);
        }
    };
    private ActionListener clickedShowWordDifficulty = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (TestData.question.size() == 0) {
                testWindows.getQuestionArea().setText("单词难度展示 星星越多难度越高\n\r");
                try {
                    ResultSet set = SqlHelper.readGread();
                    while (set.next()) {
                        testWindows.getQuestionArea().append(set.getString("word") + "......." +
                                showStarts(Float.parseFloat(set.getString("r"))) + "\r\n");
                    }
                } catch (SQLException SQL) {
                    System.out.println("button_show_words_difficulty");
                }
            }
        }
    };
    private String right_option;

    public Test(TestWindows testWindows) {
        this.testWindows = testWindows;
        for (int i = 0; i < testWindows.getOptions().length; i++) {
            int finalI = i;
            testWindows.getOptions()[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    judgeAnswer(Integer.toString(finalI + 1));
                    test();
                }
            });
        }
        testWindows.getShowWordsDifficultyButton().addActionListener(clickedShowWordDifficulty);
        testWindows.getShowResultDialog().addWindowListener(closeShowResultDialog);
    }

    private String showStarts(float f) {
        if (f >= 0.8f && f <= 1.0f)
            return "*****";
        if (f >= 0.6f)
            return "****";
        if (f >= 0.4f)
            return "***";
        if (f >= 0.2f)
            return "**";
        if (f >= 0.0f && f < 0.2f)
            return "*";
        //出错就显示6个零
        return "000000";
    }

    private void judgeAnswer(String user_option) {
        if (user_option.compareTo(right_option) == 0) {
            testWindows.getShowResultLableOfDialog()[0].setText("");
            testWindows.getShowResultLableOfDialog()[1].setText("回答正确");
            testWindows.getShowResultLableOfDialog()[2].setText("");
            SqlHelper.writeGrade(SqlHelper.account, TestData.question.get(TestData.question.size() - 1).get(0), 1, 0);
            testWindows.getShowResultDialog().setVisible(true);
        } else {
            testWindows.getShowResultLableOfDialog()[0].setText("回答错误,你的选择是" + user_option);
            testWindows.getShowResultLableOfDialog()[1].setText("正确答案是:  " + right_option);
            testWindows.getShowResultLableOfDialog()[2].setText(TestData.question.get(TestData.question.size() - 1).get(Integer.parseInt(right_option)));
            SqlHelper.writeGrade(SqlHelper.account, TestData.question.get(TestData.question.size() - 1).get(0), 0, 1);
            testWindows.getShowResultDialog().setVisible(true);
            TestData.question.add(0, TestData.question.get(TestData.question.size() - 1));
        }
        TestData.question.remove(TestData.question.size() - 1);
    }

    public void test() {
        testWindows.getQuestionArea().setText("");
        try {
            appendQuestionAndOptions(TestData.question.size() - 1, TestData.question);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            finishTest();
        }
    }

    private void appendQuestionAndOptions(int index, ArrayList<ArrayList<String>> t) {
        testWindows.getQuestionArea().setText(t.get(index).get(0) + "\r\n");
        for (int i = 0; i < 4; i++) {
            testWindows.getQuestionArea().append((i + 1) + ": " + t.get(index).get(i + 1) + "\r\n");
        }
        right_option = t.get(index).get(5);
    }

    private void finishTest() {
        testWindows.getQuestionArea().setText("考试结束");
        TestData.question.clear();
        testWindows.getShowWordsDifficultyButton().setVisible(true);
        for (int i = 0; i < testWindows.getOptions().length; i++) {
            testWindows.getOptions()[i].setVisible(false);
        }
        testWindows.invalidate();
    }
}
