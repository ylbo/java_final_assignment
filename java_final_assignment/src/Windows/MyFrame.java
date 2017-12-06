package Windows;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MyFrame extends Frame {

    public MyFrame(String s) {
        super(s);
        this.setLayout(null);
        this.setBounds(1920 / 2 - 450 / 2 - 100, 1080 / 2 - 290 / 2 - 100, 450, 275);
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
