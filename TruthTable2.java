import javax.swing.*;
import java.awt.*;

public class TruthTable2 extends JPanel {

    public static int mouse = 0;

    public void paintComponent(Graphics g){     // Filling table according to current page
        if(mouse == 1){
            drawTable(g);
            g.setColor(new Color(0x00b300));
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            fillInputs(g);
        }

        if(mouse == 2){
            drawTable(g);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            fillInputs(g);
            g.setColor(new Color(0x00b300));
            fillMainVariables(g);
        }

        if(mouse == 3){
            drawTable(g);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            fillInputs(g);
            fillMainVariables(g);
            g.setColor(new Color(0x00b300));
            fillOtherVariables(g);
        }

        if(mouse == 4){
            drawTable(g);
            g.setFont(new Font("TimesRoman", Font.BOLD, 14));
            fillInputs(g);
            fillMainVariables(g);
            fillOtherVariables(g);
            g.setColor(new Color(0x00b300));
            fillOutputs(g);
        }

    }

    private void fillInputs(Graphics g){        // Fills Inputs
        g.drawString("A", 63, 22);
        g.drawString("!A", 138, 22);
        g.drawString("B", 213, 22);
        g.drawString("!A Λ B", 288, 22);
    }

    private void fillMainVariables(Graphics g){     // Fills main variables A and B
        g.drawString("0", 63, 66);
        g.drawString("0", 63, 107);
        g.drawString("1", 63, 148);
        g.drawString("1", 63, 189);
        g.drawString("0", 213, 66);
        g.drawString("1", 213, 107);
        g.drawString("0", 213, 148);
        g.drawString("1", 213, 189);
    }

    private void fillOtherVariables(Graphics g){        // Fills suplementary variables
        g.drawString("1", 138, 66);
        g.drawString("1", 138, 107);
        g.drawString("0", 138, 148);
        g.drawString("0", 138, 189);
    }

    private void fillOutputs(Graphics g){       // Fill outputs
        g.drawString("0", 288, 66);
        g.drawString("1", 288, 107);
        g.drawString("0", 288, 148);
        g.drawString("0", 288, 189);
    }

    private void drawTable(Graphics g){     // Draws the table
        super.paintComponent(g);
        g.drawRect(30, 0, 360, 208);
        g.drawLine(105, 0, 105, 208);
        g.drawLine(180, 0, 180, 208);
        g.drawLine(255, 0, 255, 208);
        g.drawLine(30, 44, 390, 44);
        g.drawLine(30, 85, 390, 85);
        g.drawLine(30, 126, 390, 126);
        g.drawLine(30, 167, 390, 167);
    }

}
