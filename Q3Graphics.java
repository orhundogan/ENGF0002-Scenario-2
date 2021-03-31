import javax.swing.*;
import java.awt.*;

public class Q3Graphics extends JPanel {

    public void paintComponent(Graphics g) {
        drawTable(g);
    }

    private void drawTable(Graphics g){     // Draws the table
        super.paintComponent(g);
        g.drawRect(20, 0, 380, 270);
        // Vertical Lines
        g.drawLine(90, 0, 90, 270);
        g.drawLine(160, 0, 160, 270);
        g.drawLine(230, 0, 230, 270);
        g.drawLine(310, 0, 310, 270);
        // Horizontal Lines
        g.drawLine(20, 30, 400, 30);
        g.drawLine(20, 60, 400, 60);
        g.drawLine(20, 90, 400, 90);
        g.drawLine(20, 120, 400, 120);
        g.drawLine(20, 150, 400, 150);
        g.drawLine(20, 180, 400, 180);
        g.drawLine(20, 210, 400, 210);
        g.drawLine(20, 240, 400, 240);
        fillInputs(g);
        fillMainVariables(g);
    }

    private void fillInputs(Graphics g){
        g.setColor(Color.BLUE);
        g.drawString("A", 50, 15);
        g.drawString("B", 120, 15);
        g.drawString("C",  190, 15);
        g.drawString("B∨C",  260, 15);
        g.drawString("A∧(B∨C)", 330, 15);
    }

    private void fillMainVariables(Graphics g){
        g.setColor(Color.BLACK);
        // A
        g.drawString("0", 50, 45);
        g.drawString("0", 50, 75);
        g.drawString("0", 50, 105);
        g.drawString("0", 50, 135);
        g.drawString("1", 50, 165);
        g.drawString("1", 50, 195);
        g.drawString("1", 50, 225);
        g.drawString("1", 50, 255);
        //B
        g.drawString("0", 120, 45);
        g.drawString("0", 120, 75);
        g.drawString("1", 120, 105);
        g.drawString("1", 120, 135);
        g.drawString("0", 120, 165);
        g.drawString("0", 120, 195);
        g.drawString("1", 120, 225);
        g.drawString("1", 120, 255);
        // C
        g.drawString("0", 190, 45);
        g.drawString("1", 190, 75);
        g.drawString("0", 190, 105);
        g.drawString("1", 190, 135);
        g.drawString("0", 190, 165);
        g.drawString("1", 190, 195);
        g.drawString("0", 190, 225);
        g.drawString("1", 190, 255);
    }



}
