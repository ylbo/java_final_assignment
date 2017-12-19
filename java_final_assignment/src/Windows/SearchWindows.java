package Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchWindows extends MyFrame {
    private Label searchLabel;
    private TextField enterWordField;
    private Button searchWordButton;
    private TextArea meaningArea;
    private Button exitButton;

    private ChooseWindows chooseWindows;

    public ChooseWindows getChooseWindows() {
        return chooseWindows;
    }

    public void setChooseWindows(ChooseWindows chooseWindows) {
        this.chooseWindows = chooseWindows;
    }

    public SearchWindows()
    {
        super();
        init();
    }
    
    private void init()
    {
        searchLabel = new Label("输入单词");
        searchLabel.setBounds(15, 35, 60, 20);

        enterWordField = new TextField();
        enterWordField.setBounds(80, 35, 240, 20);

        meaningArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        meaningArea.setBounds(15, 60, 410, 160);

        searchWordButton = new Button("搜索");
        searchWordButton.setBounds(340, 35, 80, 20);
        exitButton = new Button("退出查询");
        exitButton.setBounds(340, 230, 80, 20);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        this.add(searchLabel);
        this.add(enterWordField);
        this.add(searchWordButton);
        this.add(meaningArea);
        this.add(exitButton);
    }

    private void exit() {
        this.getChooseWindows().setVisible(true);
        this.setVisible(false);
    }
    public TextField getEnterWordField() {
        return enterWordField;
    }

    public Button getSearchWordButton() {
        return searchWordButton;
    }

    public TextArea getMeaningArea() {
        return meaningArea;
    }
}
