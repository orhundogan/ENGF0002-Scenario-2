import javax.swing.*;
import java.awt.*;

public class TTGeneratorGraphics extends JPanel {


    public static boolean variableAmountClicked = false;
    public static boolean expressionClicked = false;
    public static Integer variableAmount;
    public static String expression;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTable(g);
        if(variableAmountClicked == true){
            if(variableAmount == 1){
                drawLines1(g);
            }
            if(variableAmount == 2){
                drawLines2(g);
            }
            if(variableAmount == 3){
                drawLines3(g);
            }
        }

        if(expressionClicked == true){
            if(variableAmount == 1){
                fillCells1(g);
            }
            if(variableAmount == 2){
                fillCells2(g);
            }
            if(variableAmount == 3){
                fillCells3(g);
            }
        }

    }

    private void drawTable(Graphics g){     // Draws the table
        g.drawRect(20, 0, 380, 207);
    }

    private void drawLines1(Graphics g){
        // Vertical
        g.drawLine(210, 0, 210, 207);
        // Horizontal
        g.drawLine(20, 69, 400, 69);
        g.drawLine(20, 138, 400, 138);
    }

    private void fillCells1(Graphics g){
        g.setColor(Color.BLUE);
        g.drawString("A", 105, 34);
        g.setColor(Color.BLACK);
        g.drawString("0", 105, 103);
        g.drawString("1", 105, 172);
    }

    private void drawLines2(Graphics g){
        // Vertical
        g.drawLine(120, 0, 120, 207);
        g.drawLine(220, 0, 220, 207);
        // Horizontal
        g.drawLine(20, 47, 400, 47);
        g.drawLine(20, 87, 400, 87);
        g.drawLine(20, 127, 400, 127);
        g.drawLine(20, 167, 400, 167);
    }

    private void fillCells2(Graphics g){
        g.setColor(Color.BLUE);
        g.drawString("A", 65, 23);
        g.drawString("B", 165, 23);
        g.setColor(Color.BLACK);
        g.drawString("0", 65, 63);
        g.drawString("0", 65, 103);
        g.drawString("1", 65, 143);
        g.drawString("1", 65, 183);
        g.drawString("0", 165, 63);
        g.drawString("1", 165, 103);
        g.drawString("0", 165, 143);
        g.drawString("1", 165, 183);
    }

    private void drawLines3(Graphics g){
        // Vertical
        g.drawLine(100, 0, 100, 207);
        g.drawLine(180, 0, 180, 207);
        g.drawLine(260, 0, 260, 207);
        // Horizontal
        g.drawLine(20, 23, 400, 23);
        g.drawLine(20, 46, 400, 46);
        g.drawLine(20, 69, 400, 69);
        g.drawLine(20, 92, 400, 92);
        g.drawLine(20, 115, 400, 115);
        g.drawLine(20, 138, 400, 138);
        g.drawLine(20, 161, 400, 161);
        g.drawLine(20, 184, 400, 184);
    }

    private void fillCells3(Graphics g){
        g.setColor(Color.BLUE);
        g.drawString("A", 55, 15);
        g.drawString("B", 135, 15);
        g.drawString("C", 215, 15);
        g.setColor(Color.BLACK);
        g.drawString("0", 55, 38);
        g.drawString("0", 55, 61);
        g.drawString("0", 55, 84);
        g.drawString("0", 55, 107);
        g.drawString("1", 55, 130);
        g.drawString("1", 55, 153);
        g.drawString("1", 55, 176);
        g.drawString("1", 55, 199);

        g.drawString("0", 135, 38);
        g.drawString("0", 135, 61);
        g.drawString("1", 135, 84);
        g.drawString("1", 135, 107);
        g.drawString("0", 135, 130);
        g.drawString("0", 135, 153);
        g.drawString("1", 135, 176);
        g.drawString("1", 135, 199);

        g.drawString("0", 215, 38);
        g.drawString("1", 215, 61);
        g.drawString("0", 215, 84);
        g.drawString("1", 215, 107);
        g.drawString("0", 215, 130);
        g.drawString("1", 215, 153);
        g.drawString("0", 215, 176);
        g.drawString("1", 215, 199);

    }

}
