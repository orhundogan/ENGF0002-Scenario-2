import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Question2Frame implements ActionListener {

    JFrame frame = new JFrame();

    JLabel questionLabel = new JLabel("¬A ∨ (A ∧ B)", SwingConstants.CENTER);

    JButton exitButton = new JButton("Exit");
    JButton checkButton = new JButton("Check");

    JPanel panel = new Q2Graphics();

    JTextField answer11 = new JTextField();
    JTextField answer12 = new JTextField();
    JTextField answer13 = new JTextField();
    JTextField answer21 = new JTextField();
    JTextField answer22 = new JTextField();
    JTextField answer23 = new JTextField();
    JTextField answer31 = new JTextField();
    JTextField answer32 = new JTextField();
    JTextField answer33 = new JTextField();
    JTextField answer41 = new JTextField();
    JTextField answer42 = new JTextField();
    JTextField answer43 = new JTextField();

    Question2Frame(){
        questionLabel.setFont(new Font("Monoscaped", Font.BOLD, 20));
        questionLabel.setForeground(Color.BLACK);
        questionLabel.setBounds(0,15,420,35);

        exitButton.setFocusable(false);
        exitButton.setBounds(55, 350, 100, 40);
        exitButton.addActionListener(this);

        checkButton.setFocusable(false);
        checkButton.setBounds(265, 350, 100, 40);
        checkButton.addActionListener(this);

        panel.setBounds(0, 60, 420, 330);
        panel.setLayout(null);
        panel.setBackground(new Color(0xFFCC99));
        panel.add(answer11);
        panel.add(answer12);
        panel.add(answer13);
        panel.add(answer21);
        panel.add(answer22);
        panel.add(answer23);
        panel.add(answer31);
        panel.add(answer32);
        panel.add(answer33);
        panel.add(answer41);
        panel.add(answer42);
        panel.add(answer43);

        answer11.setBounds(160, 71, 70, 20);
        answer11.setHorizontalAlignment(JTextField.CENTER);
        answer12.setBounds(230, 71, 80, 20);
        answer12.setHorizontalAlignment(JTextField.CENTER);
        answer13.setBounds(310, 71, 90, 20);
        answer13.setHorizontalAlignment(JTextField.CENTER);
        answer21.setBounds(160, 125, 70, 20);
        answer21.setHorizontalAlignment(JTextField.CENTER);
        answer22.setBounds(230, 125, 80, 20);
        answer22.setHorizontalAlignment(JTextField.CENTER);
        answer23.setBounds(310, 125, 90, 20);
        answer23.setHorizontalAlignment(JTextField.CENTER);
        answer31.setBounds(160, 179, 70, 20);
        answer31.setHorizontalAlignment(JTextField.CENTER);
        answer32.setBounds(230, 179, 80, 20);
        answer32.setHorizontalAlignment(JTextField.CENTER);
        answer33.setBounds(310, 179, 90, 20);
        answer33.setHorizontalAlignment(JTextField.CENTER);
        answer41.setBounds(160, 233, 70, 20);
        answer41.setHorizontalAlignment(JTextField.CENTER);
        answer42.setBounds(230, 233, 80, 20);
        answer42.setHorizontalAlignment(JTextField.CENTER);
        answer43.setBounds(310, 233, 90, 20);
        answer43.setHorizontalAlignment(JTextField.CENTER);

        frame.add(questionLabel);
        frame.add(exitButton);
        frame.add(checkButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0xFFCC99));
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  // Opens the frame at the middle of screen

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == checkButton){
            checkCells(answer11, "1", panel);
            checkCells(answer12, "0", panel);
            checkCells(answer13, "1", panel);
            checkCells(answer21, "1", panel);
            checkCells(answer22, "0", panel);
            checkCells(answer23, "1", panel);
            checkCells(answer31, "0", panel);
            checkCells(answer32, "0", panel);
            checkCells(answer33, "0", panel);
            checkCells(answer41, "0", panel);
            checkCells(answer42, "1", panel);
            checkCells(answer43, "1", panel);
            checkButton.setEnabled(false);
        }

        if(e.getSource() == exitButton){
            frame.dispose();
            ExampleQuestionsFrame exampleQuestionsFrame = new ExampleQuestionsFrame();
        }

    }

    private void checkCells(JTextField textField, String correctAnswer, JPanel panel){
        String answer = textField.getText().replaceAll("\\s+","").toUpperCase();
        textField.setText("");
        textField.setVisible(false);
        JLabel label = new JLabel("", SwingConstants.CENTER);
        panel.add(label);
        label.setText(correctAnswer);
        label.setBounds(textField.getX(), textField.getY(), textField.getWidth(), textField.getHeight());
        if(answer.equals(correctAnswer)){
            label.setForeground(new Color(0x00b300));
        } else{
            label.setForeground(Color.RED);
        }
    }
}
