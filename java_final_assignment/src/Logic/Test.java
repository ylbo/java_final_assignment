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
        if (f >= 0f && f < 0.2f)
            return "*";
        if (f > 0.2f && f < 0.4f)
            return "**";
        if (f >= 0.4f && f < 0.6f)
            return "***";
        if (f >= 0.6f && f < 0.8f)
            return "****";
        if (f >= 0.8f && f <= 1.0f)
            return "*****";
        //出错就显示6个零
        return "000000";
    }

    public Test(TestWindows testWindows, StringBuilder loged_in_user_name) {
        this.testWindows = testWindows;
        this.loged_in_user_name = loged_in_user_name;
        System.out.println(this.loged_in_user_name);
        for (int i = 0; i < testWindows.getOption().length; i++) {
            int finalI = i;
            testWindows.getOption()[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    judge_answer(Integer.toString(finalI + 1));
                    test();
                }
            });
        }
        testWindows.getButton_show_words_difficulty().addActionListener(show_word_difficulty);
        testWindows.getResult_dialog().addWindowListener(result_dialog);
    }

    private void judge_answer(String user_option) {
        if (user_option.compareTo(right_option) == 0) {
            testWindows.getResult_label_dialog().setText("");
            testWindows.getLabel_dialog_right_option_1().setText("回答正确");
            testWindows.getLabel_dialog_right_option_2().setText("");
            SqlHelper.write_grade(new String(loged_in_user_name), question.get(question.size() - 1).get(0), 1, 0);
            testWindows.getResult_dialog().setVisible(true);
            question.remove(question.size() - 1);
        } else {
            testWindows.getResult_label_dialog().setText("回答错误,你的选择是" + user_option);
            testWindows.getLabel_dialog_right_option_1().setText("正确答案是");
            testWindows.getLabel_dialog_right_option_2().setText(right_option + ":  " + question.get(question.size() - 1).get(Integer.parseInt(right_option)));
            SqlHelper.write_grade(new String(loged_in_user_name), question.get(question.size() - 1).get(0), 0, 1);
            testWindows.getResult_dialog().setVisible(true);
            question.add(0, question.get(question.size() - 1));
            question.remove(question.size() - 1);
        }
    }

    public void test() {
        testWindows.getTextArea_question().setText("");
        try {
            append_question_and_options(question.size() - 1, question);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            finish_test();
        }
    }

    private void append_question_and_options(int index, ArrayList<ArrayList<String>> t) {
        testWindows.getTextArea_question().setText(t.get(index).get(0) + "\r\n");
        for (int i = 0; i < 4; i++) {
            testWindows.getTextArea_question().append((i + 1) + ": " + t.get(index).get(i + 1) + "\r\n");
        }
        right_option = t.get(index).get(5);
    }

    private void finish_test() {
        testWindows.getTextArea_question().setText("考试结束");
        this.question.clear();
        testWindows.getButton_show_words_difficulty().setVisible(true);
        for (int i = 0; i < testWindows.getOption().length; i++) {
            testWindows.getOption()[i].setVisible(false);
        }
        testWindows.invalidate();
    }
}
