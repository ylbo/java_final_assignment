package Logic;

import Windows.TestWindows;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Test {

    private TestWindows testWindows;
    public ArrayList<ArrayList<String>> question = new ArrayList<ArrayList<String>>();
    private StringBuilder loged_in_user_name;
    private WindowListener result_dialog = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            testWindows.getResult_dialog().setVisible(false);
        }
    };
    private ActionListener show_word_difficulty = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (question.size() == 0) {
                testWindows.getTextArea_question().setText("单词难度展示 星星越多难度越高\n\r");
                try {
                    ResultSet set = SqlHelper.read_gread();
                    while (set.next()) {
                        testWindows.getTextArea_question().append(set.getString("word") + "......." +
                                show_start_number(Float.parseFloat(set.getString("r"))) + "\r\n");
                    }
                } catch (SQLException SQL) {
                    System.out.println("button_show_words_difficulty");
                }
            }
        }
    };
    private String right_option;

    private String show_start_number(float f) {
        if (f >= Float.parseFloat("0") && f <= Float.parseFloat("0.2"))
            return "*";
        if (f > Float.parseFloat("0.2") && f < Float.parseFloat("0.4"))
            return "**";
        if (f >= Float.parseFloat("0.4") && f < Float.parseFloat("0.6"))
            return "***";
        if (f >= Float.parseFloat("0.6") && f < Float.parseFloat("0.8"))
            return "****";
        if (f >= Float.parseFloat("0.8") && f <= Float.parseFloat("1.0"))
            return "*****";
        //出错就显示6个零
        return "000000";
    }
    private ActionListener submint_button = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (testWindows.getTextField_answer().getText().compareTo(right_option) == 0) {
                System.out.println(right_option);
                testWindows.getResult_label_dialog().setText("回答正确");
                SqlHelper.write_grade(new String(loged_in_user_name), question.get(question.size() - 1).get(Integer.parseInt(right_option)), 1, 0);
                testWindows.getResult_dialog().setVisible(true);
                question.remove(question.size() - 1);
            } else {
                testWindows.getResult_label_dialog().setText("回答错误");
                SqlHelper.write_grade(new String(loged_in_user_name), question.get(question.size() - 1).get(Integer.parseInt(right_option)), 0, 1);
                testWindows.getResult_dialog().setVisible(true);
                question.add(0, question.get(question.size() - 1));
                question.remove(question.size() - 1);
            }
            test();
        }
    };

    public Test(TestWindows testWindows, StringBuilder loged_in_user_name) {
        this.testWindows = testWindows;
        this.loged_in_user_name = loged_in_user_name;
        System.out.println(this.loged_in_user_name);
        testWindows.getButton_submit().addActionListener(submint_button);
        testWindows.getButton_show_words_difficulty().addActionListener(show_word_difficulty);

        //testWindows.getButton_put_grade().addActionListener(put_grade);
        testWindows.getResult_dialog().addWindowListener(result_dialog);
    }

    public void test() {
        testWindows.getTextField_answer().setText("");
        testWindows.getTextArea_question().setText("");
        if (question.size() == 0) {
            finish_test();
            return;
        }
        ss(question.size() - 1, question);
    }

    private void ss(int index, ArrayList<ArrayList<String>> t) {
        testWindows.getTextArea_question().setText(t.get(index).get(0) + "\r\n");
        testWindows.getTextArea_question().append("1: " + t.get(index).get(1) + "\r\n");
        testWindows.getTextArea_question().append("2: " + t.get(index).get(2));
        right_option = t.get(index).get(3);
    }

    private void finish_test() {
        testWindows.getTextArea_question().setText("考试结束");
        testWindows.getButton_submit().setVisible(false);
        testWindows.getTextField_answer().setVisible(false);
        testWindows.invalidate();
    }

    public void reset() {
        testWindows.getTextArea_question().setText("");
        testWindows.getTextField_answer().setVisible(true);
        testWindows.getButton_submit().setVisible(true);
    }
}
