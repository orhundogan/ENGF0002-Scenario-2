import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TruthTableGeneratorFrame implements ActionListener {

    public static JFrame frame = new JFrame();

    JLabel title = new JLabel("Generator", SwingConstants.CENTER);
    JLabel variableAmountLabel = new JLabel("Amount of variables: ");
    JLabel expressionLabel = new JLabel("Expression: ");


    JLabel answer1;
    JLabel answer2;
    JLabel answer3;
    JLabel answer4;
    JLabel answer5;
    JLabel answer6;
    JLabel answer7;
    JLabel answer8;


    String amountArray[]={"1", "2", "3"};
    JComboBox cb = new JComboBox(amountArray);

    JButton exitButton = new JButton("Finish");
    JButton checkButton = new JButton("Check");
    JButton variableDoneButton = new JButton("Done");
    JButton expressionDoneButton = new JButton("Done");

    public static JTextField expressionTextField = new JTextField(enterExpressionFrame.expression);

    JPanel panel = new TTGeneratorGraphics();

    TruthTableGeneratorFrame(){

        title.setFont(new Font("Monoscaped", Font.BOLD, 35));
        title.setForeground(Color.BLUE);
        title.setBounds(0,15,420,60);

        variableAmountLabel.setFont(new Font("Monoscaped", Font.PLAIN, 13));
        variableAmountLabel.setForeground(Color.BLACK);
        variableAmountLabel.setBounds(10, 80, 140, 20);

        cb.setBounds(160, 80, 150, 25);

        variableDoneButton.setFocusable(false);
        variableDoneButton.setBounds(320,80 ,90, 20);
        variableDoneButton.addActionListener(this);

        expressionLabel.setFont(new Font("Monoscoped", Font.PLAIN, 13));
        expressionLabel.setForeground(Color.BLACK);
        expressionLabel.setBounds(10, 110, 140, 20);
        expressionLabel.setVisible(false);

        expressionTextField.setBounds(160, 110, 150, 25);
        expressionTextField.setHorizontalAlignment(JTextField.CENTER);
        expressionTextField.setVisible(false);

        expressionDoneButton.setFocusable(false);
        expressionDoneButton.setBounds(320, 110, 90, 20);
        expressionDoneButton.addActionListener(this);
        expressionDoneButton.setVisible(false);

        exitButton.setFocusable(false);
        exitButton.setBounds(55, 350, 100, 40);
        exitButton.addActionListener(this);

        checkButton.setFocusable(false);
        checkButton.setBounds(265, 350, 100, 40);
        checkButton.addActionListener(this);

        panel.setBounds(0, 140, 420, 210);
        panel.setLayout(null);
        panel.setBackground(new Color(0xFFCC99));

        expressionTextField.setEnabled(false);

        frame.add(panel);
        frame.add(title);
        frame.add(checkButton);
        frame.add(exitButton);
        frame.add(variableAmountLabel);
        frame.add(expressionLabel);
        frame.add(cb);
        frame.add(variableDoneButton);
        frame.add(expressionTextField);
        frame.add(expressionDoneButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xFFCC99));
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  // Opens the frame at the middle of screen
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
            TTGeneratorGraphics.expressionClicked = false;
            TTGeneratorGraphics.variableAmountClicked = false;
        }

        if (e.getSource() == variableDoneButton) {
            variableDoneButton.setEnabled(false);
            cb.setEnabled(false);
            expressionLabel.setVisible(true);
            expressionDoneButton.setVisible(true);
            expressionTextField.setVisible(true);
            if (cb.getSelectedItem() == "1") {
                expressionLabel.setText("Expression (Use A): ");
            } else if (cb.getSelectedItem() == "2") {
                expressionLabel.setText("Expression (Use A-B): ");
            } else if (cb.getSelectedItem() == "3") {
                expressionLabel.setFont(new Font("Monoscoped", Font.PLAIN, 11));
                expressionLabel.setText("Expression (Use A-B-C): ");
            }
            TTGeneratorGraphics.variableAmount = Integer.parseInt((String) cb.getSelectedItem());
            TTGeneratorGraphics.variableAmountClicked = true;
            panel.repaint();
            enterExpressionFrame.varAmount = TTGeneratorGraphics.variableAmount;
            enterExpressionFrame enterExpressionFrame = new enterExpressionFrame();
        }

        if (e.getSource() == expressionDoneButton) {
            expressionDoneButton.setEnabled(false);
            expressionTextField.setEnabled(false);
            TTGeneratorGraphics.expression = expressionTextField.getText();
            TTGeneratorGraphics.expressionClicked = true;
            if (cb.getSelectedItem() == "1") {
                completeTable1(expressionTextField.getText());
            }
            if (cb.getSelectedItem() == "2") {
                completeTable2(expressionTextField.getText());
            }
            if (cb.getSelectedItem() == "3") {
                completeTable3(expressionTextField.getText());
            }
            enterExpressionFrame.frame.dispose();
            panel.repaint();
        }
        if (e.getSource() == checkButton) {
            if (cb.getSelectedItem() == "1") {
                    generateAnswers1(expressionTextField.getText());
            }
            if (cb.getSelectedItem() == "2") {
                generateAnswers2(expressionTextField.getText());
            }
            if (cb.getSelectedItem() == "3") {
                generateAnswers3(expressionTextField.getText());
            }
            panel.repaint();
        }
    }

    public void completeTable1(String exp){
        JLabel expression = new JLabel(exp, SwingConstants.CENTER);
        expression.setFont(new Font("Lucida", Font.PLAIN, 13));
        expression.setBounds(210, 0,190, 69 );
        expression.setForeground(Color.BLUE);
        panel.add(expression);
    }

    public void completeTable2(String exp){
        JLabel expression = new JLabel(exp, SwingConstants.CENTER);
        expression.setFont(new Font("Lucida", Font.PLAIN, 13));
        expression.setBounds(220, 0,180, 47 );
        expression.setForeground(Color.BLUE);
        panel.add(expression);
    }

    public void completeTable3(String exp){
        JLabel expression = new JLabel(exp, SwingConstants.CENTER);
        expression.setFont(new Font("Lucida", Font.PLAIN, 13));
        expression.setBounds(260, 0,140, 23 );
        expression.setForeground(Color.BLUE);
        panel.add(expression);
    }

  public void generateAnswers1(String exp){
        Model model = new Model(exp);
        Object[][] newArray = model.getArray();
        int colsAmount = newArray.length;

        answer1 = new JLabel(newArray[colsAmount - 1][0].toString(), SwingConstants.CENTER);
        answer1.setBounds(210, 69, 190, 69);

        answer2 = new JLabel(newArray[colsAmount - 1][1].toString(), SwingConstants.CENTER);
        answer2.setBounds(210, 138, 190, 69);

        panel.add(answer1);
        panel.add(answer2);
        }


    public void generateAnswers2(String exp){
        Model model = new Model(exp);
        Object[][] newArray = model.getArray();
        int colsAmount = newArray.length;

        answer1 = new JLabel(newArray[colsAmount -1][0].toString(), SwingConstants.CENTER);
        answer1.setBounds(220, 47,180, 40);
        answer2 = new JLabel(newArray[colsAmount -1][1].toString(), SwingConstants.CENTER);
        answer2.setBounds(220, 87,180, 40);
        answer3 = new JLabel(newArray[colsAmount -1][2].toString(), SwingConstants.CENTER);
        answer3.setBounds(220, 127,180, 40);
        answer4 = new JLabel(newArray[colsAmount -1][3].toString(), SwingConstants.CENTER);
        answer4.setBounds(220, 167,180, 40);

        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
    }

    public void generateAnswers3(String exp){
        Model model = new Model(exp);
        Object[][] newArray = model.getArray();
        int colsAmount = newArray.length;

        answer1 = new JLabel(newArray[colsAmount -1][0].toString(), SwingConstants.CENTER);
        answer1.setBounds(260, 23,140, 23);
        answer2 = new JLabel(newArray[colsAmount -1][1].toString(), SwingConstants.CENTER);
        answer2.setBounds(260, 46,140, 23);
        answer3 = new JLabel(newArray[colsAmount -1][2].toString(), SwingConstants.CENTER);
        answer3.setBounds(260, 69,140, 23);
        answer4 = new JLabel(newArray[colsAmount -1][3].toString(), SwingConstants.CENTER);
        answer4.setBounds(260, 92,140, 23);
        answer5 = new JLabel(newArray[colsAmount -1][4].toString(), SwingConstants.CENTER);
        answer5.setBounds(260, 115,140, 23);
        answer6 = new JLabel(newArray[colsAmount -1][5].toString(), SwingConstants.CENTER);
        answer6.setBounds(260, 138,140, 23);
        answer7 = new JLabel(newArray[colsAmount -1][6].toString(), SwingConstants.CENTER);
        answer7.setBounds(260, 161,140, 23);
        answer8 = new JLabel(newArray[colsAmount -1][7].toString(), SwingConstants.CENTER);
        answer8.setBounds(260, 184,140, 23);

        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel.add(answer5);
        panel.add(answer6);
        panel.add(answer7);
        panel.add(answer8);

    }
}
