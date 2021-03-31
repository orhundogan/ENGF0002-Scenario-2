import javax.swing.*;
import java.awt.*;

public class TruthTable extends JPanel {

    public static int mouse = 0;

    public void paintComponent(Graphics g) { ;      // Filling table according to logic gate
        if (mouse == 1) {
            draw4Table(g);
            // Filling answers
            g.drawString("0", 280, 78);
            g.drawString("0", 280, 115);
            g.drawString("0", 280, 152);
            g.drawString("1", 280, 189);
        }
        if (mouse == 2) {
            draw4Table(g);
            // Filling answers
            g.drawString("0", 280, 78);
            g.drawString("1", 280, 115);
            g.drawString("1", 280, 152);
            g.drawString("1", 280, 189);
        }

        if (mouse == 3) {
            draw2Table(g);
            g.drawString("1", 280, 78);
            g.drawString("0", 280, 115);
        }

        if(mouse == 4){
            draw4Table(g);
            // Filling answers
            g.drawString("1", 280, 78);
            g.drawString("1", 280, 115);
            g.drawString("1", 280, 152);
            g.drawString("0", 280, 189);
        }

        if(mouse ==5){
            draw4Table(g);
            // Filling answers
            g.drawString("1", 280, 78);
            g.drawString("0", 280, 115);
            g.drawString("0", 280, 152);
            g.drawString("0", 280, 189);
        }

        if(mouse == 6){
            draw4Table(g);
            // Filling answers
            g.drawString("0", 280, 78);
            g.drawString("1", 280, 115);
            g.drawString("1", 280, 152);
            g.drawString("0", 280, 189);
        }

        if(mouse == 7){
            draw4Table(g);
            // Filling answers
            g.drawString("1", 280, 78);
            g.drawString("0", 280, 115);
            g.drawString("0", 280, 152);
            g.drawString("1", 280, 189);
        }
    }

    private void draw4Table(Graphics g){        // Truth table with 4 variables
        super.paintComponent(g);
        g.drawRect(30, 0, 360, 208);
        g.drawLine(210, 0, 210, 208);
        g.drawLine(30, 30, 390, 30);
        g.drawLine(30, 60, 390, 60);
        g.drawLine(120, 30, 120, 208);
        g.setColor(Color.BLUE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString("Input", 100, 15);
        g.drawString("Output", 280, 15);
        g.setColor(Color.red);
        g.drawString("A", 75, 45);
        g.drawString("B", 165, 45);
        g.drawString("O", 280, 45);
        g.setColor(Color.black);
        // Filling table
        g.drawString("0", 75, 78);
        g.drawString("0", 165, 78);
        g.drawString("0", 75, 115);
        g.drawString("1", 165, 115);
        g.drawString("1", 75, 152);
        g.drawString("0", 165, 152);
        g.drawString("1", 75, 189);
        g.drawString("1", 165, 189);
        g.setColor(new Color(0x00b300));
    }

    private void draw2Table(Graphics g){        // Truth table with 2 variables
        super.paintComponent(g);
        g.drawRect(30, 0, 360, 208);
        g.drawLine(210, 0, 210, 208);
        g.drawLine(30, 30, 390, 30);
        g.drawLine(30, 60, 390, 60);
        g.setColor(Color.BLUE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 14));
        g.drawString("Input", 100, 15);
        g.drawString("Output", 280, 15);
        g.setColor(Color.red);
        g.drawString("A", 120, 45);
        g.drawString("O", 280, 45);
        g.setColor(Color.black);
        g.drawString("0", 120, 78);
        g.drawString("1", 120, 115);
        g.setColor(new Color(0x00b300));
    }
}


