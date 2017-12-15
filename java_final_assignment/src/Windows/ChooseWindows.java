package Windows;

import java.awt.*;

public class ChooseWindows extends MyFrame {
    private Button searchModuleButton;
    private Button testModuleButton;
    private Button translateModuleButton;

    public ChooseWindows() {
        super();
        init();
    }

    private void init() {
        searchModuleButton = new Button("���ҵ���");
        searchModuleButton.setBounds(120, 100, 80, 60);
        searchModuleButton.setBackground(Color.YELLOW);

        testModuleButton = new Button("����ģʽ");
        testModuleButton.setBounds(240, 100, 80, 60);
        testModuleButton.setBackground(Color.CYAN);

        translateModuleButton = new Button("��������");
        translateModuleButton.setBounds(180, 170, 80, 60);
        translateModuleButton.setBackground(Color.WHITE);

        this.add(translateModuleButton);
        this.add(searchModuleButton);
        this.add(testModuleButton);
    }

    public Button getSearchModuleButton() {
        return searchModuleButton;
    }

    public Button getTestModuleButton() {
        return testModuleButton;
    }

    public Button getTranslateModuleButton() {
        return translateModuleButton;
    }

}
