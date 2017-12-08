package Windows;

import java.awt.*;

public class ChooseDicWindows extends MyFrame {
    private Button Get4;
    private Button Get6;

    public ChooseDicWindows() {
        super();
        init();
    }

    private void init() {
        Get4 = new Button("Ó¢ÓïËÄ¼¶²âÊÔ");
        Get6 = new Button("Ó¢ÓïÁù¼¶²âÊÔ");

        Get4.setBounds(120, 100, 80, 60);
        Get6.setBounds(240, 100, 80, 60);

        this.add(Get4);
        this.add(Get6);
    }

    public Button getGet4() {
        return Get4;
    }

    public Button getGet6() {
        return Get6;
    }
}
