import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;


public class SwingEventWindow {

    private int rdoChecked = 1;
    //input field
    private JTextField input;
    //radio buttons
    private JRadioButton totalBtn;
    private JRadioButton averageBtn;
    private JRadioButton maxBtn;
    private JRadioButton minBtn;
    //calculate button
    private JButton calculateBtn;
    //result field
    private JTextField result;
    

    public void createAndShowGUI () {
        //defining the frame
        JFrame frame = new JFrame (  "Excel Functionality");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
        frame. setSize( 400, 200);
        //defining the panel for input field
        JPanel inputPanel = new JPanel ();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER)) ;

        //creating components

        //defining input field
        input = new JTextField( 28);
        inputPanel.add(input);

        // defining radio Buttons
        totalBtn = new JRadioButton( "Total");
        averageBtn = new JRadioButton (  "Average");
        maxBtn = new JRadioButton( "Maximum");
        minBtn = new JRadioButton(  "Minimum");
        //defining the Panel for radio buttons and adding them to panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout (new FlowLayout (FlowLayout.CENTER)) ;
        radioPanel. add (totalBtn); radioPanel. add (averageBtn);
        radioPanel. add (maxBtn); radioPanel.add (minBtn);
         //creating Button Group for radio Buttons
       ButtonGroup btnGroup = new ButtonGroup() ;
       btnGroup.add(averageBtn);
       btnGroup.add(totalBtn);
       btnGroup.add(maxBtn);
       btnGroup.add(minBtn);

       //ActionListener for radio Buttons

       //for total Button
       totalBtn.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent e) {
        rdoChecked = 1;
        }
        });
        averageBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        rdoChecked = 2;
        }});

        maxBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        rdoChecked = 3;
        }});

        minBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        rdoChecked = 4;
        }});

        //defining the calculate button 
        calculateBtn = new JButton ( "Calculate");
        result = new JTextField(20);
        result.setEditable(false);
        //adding action listener on each of these componente
        calculateBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String inputData =input.getText();
                ArrayList<Double> numbers= parseNumbers(inputData);
                Excel excel= new Excel(numbers);
                 
                double output;
                if (rdoChecked == 1) {
                    output = excel. findTotal();
                } else if (rdoChecked == 2) {
                    output = excel. findAvg();
                } else if (rdoChecked == 3) {
                    output = excel. findMax();
                } else {
                    output = excel. findMin();
                }
                    result.setText(Double.toString(output));
        
            }
        });
        //defining Panel for calulate Button
        JPanel buttonPanel = new JPanel ();
        buttonPanel. setLayout (new FlowLayout (FlowLayout .CENTER)) ;
        buttonPanel.add (calculateBtn);

        //defining Panel for result Button
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout (new FlowLayout (FlowLayout .CENTER)) ;
        resultPanel.add (result);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout (new BorderLayout()) ;
        mainPanel. add (inputPanel, BorderLayout.NORTH) ; 
        mainPanel.add (radioPanel, BorderLayout. CENTER);
        // Combine the buttonPanel and resultanel into a single panel
        JPanel buttonAndResultPanel = new JPanel();
        buttonAndResultPanel.setLayout (new GridLayout(1,2)); 
        buttonAndResultPanel.add (buttonPanel); 
        buttonAndResultPanel.add(resultPanel);
        mainPanel.add (buttonAndResultPanel, BorderLayout.SOUTH);
        frame. add (mainPanel);
        frame. setVisible(true);
    }
        // Implement event handlers here if required
    
        private ArrayList<Double> parseNumbers (String inputText) {
            ArrayList<Double> numbers = new ArrayList<>();
            String[] inputValues = inputText.split (",") ;
            for (String value : inputValues) {
                 try {
                 double number = Double.parseDouble (value.trim());
                 numbers. add (number);
                 } catch (NumberFormatException e) {
            
                 }
                 
            }   return numbers;
        }      


        
               
    }

    


