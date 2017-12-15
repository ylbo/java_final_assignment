package Windows;

import java.awt.*;

public class TestWindows extends MyFrame {
    private TextArea questionArea;
    private Button[] options = new Button[4];
    private Button exitButton;
    private Button showWordsDifficultyButton;
    private Dialog showResultDialog;
    private Label[] showResultLableOfDialog = new Label[3];

    public TestWindows() {
        super();
        init();
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

        this.add(questionArea);
        this.add(showWordsDifficultyButton);
        this.add(exitButton);

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

    public Button getExitButton() {
        return exitButton;
    }

    public Dialog getShowResultDialog() {
        return showResultDialog;
    }

    public Label[] getShowResultLableOfDialog() {
        return showResultLableOfDialog;
    }

}
