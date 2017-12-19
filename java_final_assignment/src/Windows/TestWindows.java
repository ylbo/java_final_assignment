package Windows;

import Logic.Test;
import Sql.TestData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestWindows extends MyFrame {
    private TextArea questionArea;
    private Button[] options = new Button[4];
    private Button exitButton;
    private Button showWordsDifficultyButton;
    private Dialog showResultDialog;
    private Label[] showResultLableOfDialog = new Label[3];
    private ChooseWindows chooseWindows;
    private Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public TestWindows() {
        super();
        init();
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b == true) {
            this.getTest().test();
        }
    }

    private void init() {

        questionArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        questionArea.setBounds(15, 40, 420, 170);

        for (int i = 0; i < 4; i++) {
            options[i] = new Button("  " + Integer.toString(i + 1) + "  ");
            options[i].setBounds(10 + i * 80, 230, 80, 20);
            this.add(options[i]);
        }

        showWordsDifficultyButton = new Button("展示单词难度");
        showWordsDifficultyButton.setBounds(250, 230, 80, 20);
        showWordsDifficultyButton.setVisible(false);
        exitButton = new Button("退出考试");
        exitButton.setBounds(330, 230, 80, 20);

        showResultDialog = new Dialog(this, "杨良博", Dialog.ModalityType.APPLICATION_MODAL);
        showResultDialog.setLayout(null);
        showResultDialog.setBounds(729, 360, 240, 148);
        for (int i = 0; i < 3; i++) {
            showResultLableOfDialog[i] = new Label("", Label.CENTER);
            showResultLableOfDialog[i].setBounds(0, 40 + i * 20, 240, 20);
            showResultDialog.add(showResultLableOfDialog[i]);
        }
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });

        this.add(questionArea);
        this.add(showWordsDifficultyButton);
        this.add(exitButton);

    }

    private void exit() {
        TestData.question.clear();
        reset();
        this.getChooseWindows().setVisible(true);
        this.setVisible(false);
    }

    private void reset() {
        for (int i = 0; i < this.getOptions().length; i++) {
            this.getOptions()[i].setVisible(true);
        }
    }

    public Button[] getOptions() {
        return options;
    }

    public TextArea getQuestionArea() {
        return questionArea;
    }

    public Button getShowWordsDifficultyButton() {
        return showWordsDifficultyButton;
    }

    public Dialog getShowResultDialog() {
        return showResultDialog;
    }

    public Label[] getShowResultLableOfDialog() {
        return showResultLableOfDialog;
    }

    public ChooseWindows getChooseWindows() {
        return chooseWindows;
    }

    public void setChooseWindows(ChooseWindows chooseWindows) {
        this.chooseWindows = chooseWindows;
    }

}
