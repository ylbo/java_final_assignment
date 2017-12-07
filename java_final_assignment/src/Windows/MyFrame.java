package Windows;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MyFrame extends Frame {

    public MyFrame(String s) {
        super(s);
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(1920 / 2 - 450 / 2 - 100, 1080 / 2 - 290 / 2 - 100, 450, 275);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
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
