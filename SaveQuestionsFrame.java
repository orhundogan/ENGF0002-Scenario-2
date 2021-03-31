import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SaveQuestionsFrame implements ActionListener {

    JFrame frame = new JFrame();

    JLabel title = new JLabel("Save Question", SwingConstants.CENTER);
    JLabel variableAmountLabel = new JLabel("Amount of variables: ");
    JLabel expressionLabel = new JLabel("Expression: ");

    String amountArray[]={"1", "2", "3"};
    JComboBox cb = new JComboBox(amountArray);

    JButton exitButton = new JButton("Exit");
    JButton saveButton = new JButton("Save");
    JButton variableDoneButton = new JButton("Done");
    JButton expressionDoneButton = new JButton("Done");

    JTextField expressionTextField = new JTextField();
    JTextField answer1 = new JTextField();
    JTextField answer2 = new JTextField();
    JTextField answer3 = new JTextField();
    JTextField answer4 = new JTextField();
    JTextField answer5 = new JTextField();
    JTextField answer6 = new JTextField();
    JTextField answer7 = new JTextField();
    JTextField answer8 = new JTextField();
    ArrayList<JTextField> fields = new ArrayList<JTextField>();     // Used to save
    JTextField[] answers = {answer1, answer2,answer3, answer4,answer5, answer6,answer7, answer8};

    JPanel panel = new SaveQuestionGraphics();

    SaveQuestionsFrame(){

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

        saveButton.setFocusable(false);
        saveButton.setBounds(265, 350, 100, 40);
        saveButton.addActionListener(this);

        for(int i = 0; i<answers.length; i++){
            answers[i].setHorizontalAlignment(JTextField.CENTER);   // Aligning all elements
        }

        panel.setBounds(0, 140, 420, 210);
        panel.setLayout(null);
        panel.setBackground(new Color(0xFFCC99));

        frame.add(panel);
        frame.add(title);
        frame.add(saveButton);
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

        if(e.getSource() == variableDoneButton){
            variableDoneButton.setEnabled(false);
            cb.setEnabled(false);
            expressionLabel.setVisible(true);
            expressionDoneButton.setVisible(true);
            expressionTextField.setVisible(true);
            if(cb.getSelectedItem() == "1"){
                expressionLabel.setText("Expression (Use A): ");
            }
            else if(cb.getSelectedItem() == "2"){
                expressionLabel.setText("Expression (Use A-B): ");
            }
            else if(cb.getSelectedItem() == "3"){
                expressionLabel.setFont(new Font("Monoscoped", Font.PLAIN, 11));
                expressionLabel.setText("Expression (Use A-B-C): ");
            }
            SaveQuestionGraphics.variableAmount = Integer.parseInt((String) cb.getSelectedItem());
            SaveQuestionGraphics.variableAmountClicked = true;
            panel.repaint();
        }

        if(e.getSource() == expressionDoneButton){
            expressionDoneButton.setEnabled(false);
            expressionTextField.setEnabled(false);
            SaveQuestionGraphics.expression = expressionTextField.getText();
            SaveQuestionGraphics.expressionClicked = true;
            if(cb.getSelectedItem() == "1") {
                completeTable1(expressionTextField.getText());
            }
            if(cb.getSelectedItem() == "2"){
                completeTable2(expressionTextField.getText());
            }
            if(cb.getSelectedItem() == "3"){
                completeTable3(expressionTextField.getText());
            }
            panel.repaint();
        }

        if(e.getSource() == exitButton){
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
            SaveQuestionGraphics.expressionClicked = false;
            SaveQuestionGraphics.variableAmountClicked = false;
        }

        if(e.getSource() == saveButton){
            if(cb.getSelectedItem() == "1"){
                fields.add(answer1);
                fields.add(answer2);
            } else if(cb.getSelectedItem() == "2"){
                fields.add(answer1);
                fields.add(answer2);
                fields.add(answer3);
                fields.add(answer4);
            } else if(cb.getSelectedItem() == "3"){
                fields.add(answer1);
                fields.add(answer2);
                fields.add(answer3);
                fields.add(answer4);
                fields.add(answer5);
                fields.add(answer6);
                fields.add(answer7);
                fields.add(answer8);
            }

            saveFile(Integer.parseInt((String) cb.getSelectedItem()), expressionTextField.getText(), fields);
            frame.dispose();
            LaunchPage launchPage = new LaunchPage();
            SaveQuestionGraphics.expressionClicked = false;
            SaveQuestionGraphics.variableAmountClicked = false;
        }

    }



    public void completeTable1(String exp){
        JLabel expression = new JLabel(exp, SwingConstants.CENTER);
        expression.setFont(new Font("Lucida", Font.PLAIN, 13));
        expression.setBounds(210, 0,190, 69 );
        expression.setForeground(Color.BLUE);
        answer1.setBounds(210, 93, 190, 20);
        answer2.setBounds(210, 162, 190, 20);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(expression);
    }

    public void completeTable2(String exp){
        JLabel expression = new JLabel(exp, SwingConstants.CENTER);
        expression.setFont(new Font("Lucida", Font.PLAIN, 13));
        expression.setBounds(220, 0,180, 47 );
        expression.setForeground(Color.BLUE);
        answer1.setBounds(220, 53, 180, 20);
        answer2.setBounds(220,93 ,180, 20);
        answer3.setBounds(220, 133, 180, 20);
        answer4.setBounds(220, 173, 180, 20);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel.add(expression);
    }

    public void completeTable3(String exp){
        JLabel expression = new JLabel(exp, SwingConstants.CENTER);
        expression.setFont(new Font("Lucida", Font.PLAIN, 13));
        expression.setBounds(260, 0,140, 23 );
        expression.setForeground(Color.BLUE);
        answer1.setBounds(260, 27,140 , 15);
        answer2.setBounds(260, 50,140 , 15);
        answer3.setBounds(260, 73,140 , 15);
        answer4.setBounds(260, 96,140 , 15);
        answer5.setBounds(260, 119,140 , 15);
        answer6.setBounds(260, 142,140 , 15);
        answer7.setBounds(260, 165,140 , 15);
        answer8.setBounds(260, 188,140 , 15);
        panel.add(answer1);
        panel.add(answer2);
        panel.add(answer3);
        panel.add(answer4);
        panel.add(answer5);
        panel.add(answer6);
        panel.add(answer7);
        panel.add(answer8);
        panel.add(expression);
    }

    public void saveFile(int amount, String exp, ArrayList<JTextField> fields){
        String fileName = JOptionPane.showInputDialog("File Name: ");
        fileName = "exercises/" + fileName + ".txt";
        File file = new File(fileName);
        try {
            PrintWriter output = new PrintWriter(file);
            output.println(amount);
            output.println(exp);
            for(int i = 0; i<fields.size(); i++){
                output.println(fields.get(i).getText());
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
