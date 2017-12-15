package Windows;

import java.awt.*;

public class ChooseDicWindows extends MyFrame {
    private Button GET4TestButton;
    private Button GET6TestButton;

    public ChooseDicWindows() {
        super();
        init();
    }

    private void init() {
        GET4TestButton = new Button("”¢”ÔÀƒº∂≤‚ ‘");
        GET6TestButton = new Button("”¢”Ô¡˘º∂≤‚ ‘");

        GET4TestButton.setBounds(120, 100, 80, 60);
        GET6TestButton.setBounds(240, 100, 80, 60);

        this.add(GET4TestButton);
        this.add(GET6TestButton);
    }

    public Button getGET4TestButton() {
        return GET4TestButton;
    }

    public Button getGET6TestButton() {
        return GET6TestButton;
    }
}
