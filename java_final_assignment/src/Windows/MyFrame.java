package Windows;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyFrame extends Frame {

    private Dialog dialog_exit;
    private Label label_exit;
    private Button button_yes;
    private Button button_no;


    public MyFrame() {
        super("杨良博");
        dialog_exit = new Dialog(this, "确认退出");
        dialog_exit.setBounds(729, 360, 240, 148);
        label_exit = new Label("你确定要退出么");
        button_yes = new Button("是");
        button_no = new Button("否");
        dialog_exit.setLayout(new FlowLayout());
        dialog_exit.add(label_exit);
        dialog_exit.add(button_yes);
        dialog_exit.add(button_no);

        button_yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button_no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog_exit.setVisible(false);
            }
        });
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(1920 / 2 - 450 / 2 - 100, 1080 / 2 - 290 / 2 - 100, 450, 275);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog_exit.setVisible(true);
            }
        });

    }
    public void paint(Graphics g) {
        super.paint(g);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("C:\\Users\\VULCAN\\Desktop\\work.jpg"));//注意地址的形式，笔者是在Mac上写的
            g.drawImage(image, 0, 0, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
