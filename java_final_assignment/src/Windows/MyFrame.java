package Windows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MyFrame extends Frame {

    private Dialog exitDialog;
    private Label exitLabel;
    private Button yesButton;
    private Button noButton;


    public MyFrame() {
        super("杨良博");
        exitDialog = new Dialog(this, "确认退出", Dialog.ModalityType.APPLICATION_MODAL);
        exitDialog.setBounds(729, 360, 240, 148);
        exitLabel = new Label("你确定要退出么");
        yesButton = new Button("是");
        noButton = new Button("否");
        exitDialog.setLayout(new FlowLayout());
        exitDialog.add(exitLabel);
        exitDialog.add(yesButton);
        exitDialog.add(noButton);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitDialog.setVisible(false);
            }
        });
        exitDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitDialog.setVisible(false);
            }
        });

        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(1920 / 2 - 450 / 2 - 100, 1080 / 2 - 290 / 2 - 100, 450, 275);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitDialog.setVisible(true);
            }
        });

    }
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage image;
        try {
            URL is = this.getClass().getResource("/work.jpg");
            image = ImageIO.read(is);
            g.drawImage(image, 0, 0, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
