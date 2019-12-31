    /**
     * File Name:       CalculatorViewController.java
     * Author:          Multani Aman, 040877727
     * Course:          CST8221 - JAP, 301
     * Assignment:      1 - Part 1 And Part 2
     * Date:            16 March 2018
     * Professor:       Svillen Ranev
     * Purpose:         class build the GUI of the calculator  
     * Class list:      CalculatorViewController, Controller
     *                  
     */
    package calculator;

    /*All the import statements*/
    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.KeyEvent;


    import javax.swing.AbstractAction;
    import javax.swing.Action;
    import javax.swing.BorderFactory;
    import javax.swing.Box;
    import javax.swing.ButtonGroup;
    import javax.swing.JButton;
    import javax.swing.JCheckBox;
    import javax.swing.JComponent;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JRadioButton;
    import javax.swing.JTextField;
    import javax.swing.KeyStroke;



    /**
     * Class which builds the GUI of a Calculator
     * @author Aman Multani
     * @version 1.0
     * @see Calculator
     * @since 1.8.0_102
     */
    public class CalculatorViewController extends JPanel{

         private JTextField display1; // the calculator display1 field reference   
         private JTextField display2; // the calculator display2 field reference
         private JLabel error; // the mode/error display label reference 
         private JButton dotButton; // the decimal point (dot) button reference 
         private String StringInput = ""; // this is the user string input

         /*array which stores the number and the operation */
         public static final String[] NumberPad = {"7", "8","9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".","\u00B1","+" };
         /*reference for action event*/
         CalculatorModel calc = new CalculatorModel(); 

         Controller controller = new Controller(); // controller reference (actionCommand)

        /**
         * Default constructor which builds GUI of a calculator.
         * @param N/A
         */
        public CalculatorViewController(){
            /*refernce to the Controller for handling th eevnts */
            /*setting the layout for the whole panel*/
            setLayout(new BorderLayout());
            /*sets the black border*/
            setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));

            /*setting the text panel layout and its border*/
            JPanel displayPanel= new JPanel();
            displayPanel.setLayout(new GridLayout(2,0));
            displayPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));

            /*setting the buttonpanel , its layout and the border */
            JPanel KeyButton = new JPanel();
            KeyButton.setLayout(new GridLayout(4,4,3,3));
            KeyButton.setBorder(BorderFactory.createEmptyBorder(3,2,3,2 ));   

           /*A loop for the placement of the buttons in the number panel*/
            for(int i=0;i<NumberPad.length;i++){
               if(NumberPad[i].equals("\u00B1")){
               KeyButton.add(createButton("\u00B1","\u00B1",Color.BLACK,Color.PINK, controller));  
                }else if (NumberPad[i].equals(".")){
                      dotButton=createButton(NumberPad[i],NumberPad[i],Color.BLACK,Color.BLUE, controller); 
                       KeyButton.add(dotButton);
                }else if (NumberPad[i].equals("-")||NumberPad[i].equals("+")||NumberPad[i].equals("/")||NumberPad[i].equals("*")){
                      KeyButton.add(createButton(NumberPad[i],NumberPad[i],Color.BLACK,Color.CYAN, controller));     
                }else{
                      KeyButton.add(createButton(NumberPad[i],NumberPad[i],Color.BLACK,Color.BLUE, controller));  
                }   

            }


            /*creating a new button for the clear "C"*/    
            JPanel clear = new JPanel(); 
            /*assigning the size*/
            clear.setLayout(new GridLayout(1,1,1,1));
            /*Creating a new Button for equal "="*/
            JPanel equal = new JPanel();
            /*assigning the size*/
            equal.setLayout(new GridLayout(1,1,1,1));

            clear.add(createButton("C", "C", Color.BLACK, Color.RED, controller )); 
            equal.add(createButton("=", "=", Color.BLACK, Color.MAGENTA, controller));


            /*creating a button and setting a text value to it */
            JRadioButton SinglePreciButton = new JRadioButton(".0", false);
            /*Setting the background color and the actionlistener to it */
            SinglePreciButton.setBackground(Color.YELLOW);
            SinglePreciButton.addActionListener(controller);

            /*creating a button and setting a default text value to it */
            JRadioButton DoublePreciButton = new JRadioButton(".00", true);
            /*Setting the background color and the actionlistener to it */
            DoublePreciButton.setBackground(Color.YELLOW);
            DoublePreciButton.addActionListener(controller);

            /*creating a button and setting a text value to it */
            JRadioButton SciButton = new JRadioButton("Sci");
            /*Setting the background color and the actionlistener to it */
            SciButton.setBackground(Color.YELLOW);
            SciButton.addActionListener(controller);


            /*creating a panel for 3 radio button together */
            JPanel RadioBotton = new JPanel();
            /*setting the layout for button*/
            RadioBotton.setLayout(new GridLayout(1, 0, 1,0));
            /*Adding all toghter at once*/
            RadioBotton.add(SinglePreciButton);
            RadioBotton.add(DoublePreciButton);
            RadioBotton.add(SciButton);

            /*creating the checkbox with the text value*/
            JCheckBox CheckBoxMode = new JCheckBox("Int");
            /*Setting the background color and the actionlistener to it */
            CheckBoxMode.setBackground(Color.GREEN);
            CheckBoxMode.addActionListener(controller);
            CheckBoxMode.setLayout (new BorderLayout());

            /*creaking a horizontal box to handle the checkbox and all the radio buttons*/
            Box boxCheck = Box.createHorizontalBox();
            boxCheck.setBackground(Color.BLACK);
            boxCheck.add(CheckBoxMode);
            /*to set the alignment in the container*/
            boxCheck.add(Box.createHorizontalStrut(127));
            boxCheck.add(SinglePreciButton);
            boxCheck.add(DoublePreciButton);
            boxCheck.add(SciButton);

            /*creating a buttonGroup for grouping the Checkbox and radiobuttons*/
            ButtonGroup PreciButtonGroup = new ButtonGroup();
            /*including the check box and buttons in the ButtonGroup*/
            PreciButtonGroup.add(CheckBoxMode);
            PreciButtonGroup.add(SinglePreciButton);
            PreciButtonGroup.add(DoublePreciButton);
            PreciButtonGroup.add(SciButton);

            display1 = new JTextField();
            /*TextFeild with 16 coloums and 30 height*/
            display1.setPreferredSize(new Dimension(16, 30)); 
            /*Background set to white*/
            display1.setBackground(Color.WHITE); 
            /*cannot be editable*/
            display1.setEditable(false);  
            /*Aligned to the right side*/
            display1.setHorizontalAlignment(JTextField.RIGHT);  
            /*set no border*/
            display1.setBorder(null); 

            display2= new JTextField();
            /*TextFeild with 16 coloums and 30 height*/
            display2.setPreferredSize(new Dimension(16, 30)); 
            /*Background set to white*/
            display2.setBackground(Color.WHITE); 
            /*cannot be editable*/
            display2.setEditable(false);  
            /*Aligned to the right side*/
            display2.setHorizontalAlignment(JTextField.RIGHT);
            /*displays 0.0 when GUI is made visible for the first time */
            display2.setText("0.0"); 
            /*set no border*/
            display2.setBorder(null); 

            /*adding the display1 and diaplay2 into the main panel displaypanel*/
            displayPanel.add(display1);
            displayPanel.add(display2);

            /*creating a new lable for the mode/error*/
            error = new JLabel("F");
            /*setting up the dimensions*/
            error.setPreferredSize(new Dimension(35,55));
            /*making the button transparent*/
            error.setOpaque(true);
            /*backgroung color*/
            error.setBackground(Color.YELLOW);
            /*seting up the border line 1 for left and right*/
            error.setBorder(BorderFactory.createMatteBorder(0,1,0,1, Color.BLACK));
            /*setting the font size and font to the bold */
            error.setFont(new Font(error.getFont().getName(), Font.BOLD, 25));
            /*the text "F" in horizontal and in center */
            error.setHorizontalAlignment(JLabel.CENTER);

            /*creating a JButton for the backspace */
            JButton backspaceButton = new JButton("\u21E6");        
            /*setting up the dimensions*/
            backspaceButton.setPreferredSize(new Dimension(35, 55)); 
            /*making the button transparent*/
            backspaceButton.setOpaque(true);
            /*backgroung color*/
            backspaceButton.setBackground(Color.YELLOW); 
            /*seting up the border line 1 for left and right*/
            backspaceButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
            /*the tool tip*/
            backspaceButton.setToolTipText("Backspace(Alt-B)"); 
            /*setting the font size and font to the bold */
            backspaceButton.setFont(new Font(backspaceButton.getFont().getName(), Font.BOLD, 25));
            /*reaction will take place with "Alt-B" key*/
            backspaceButton.setMnemonic('B');
            /*text to display on click*/
            backspaceButton.setActionCommand("\u21E6");
            backspaceButton.addActionListener(controller);

            /*a panel containig the error/mode lable,  backspace , textfiled , checkbox and the radio buttons*/
            JPanel northPanel= new JPanel();
            /*setting up the borderlayout*/
            northPanel.setLayout(new BorderLayout());
            /*adding the button into the panel "F" , "backspace button" and the display panel with position*/
            northPanel.add(error,BorderLayout.WEST);
            northPanel.add(displayPanel,BorderLayout.CENTER);
            northPanel.add(backspaceButton,BorderLayout.EAST);

            /*creatingbthe temp panel for the adding purpose of the clear panel*/
            JPanel ClearPanel= new JPanel();
            /*setting the borderlayout*/
            ClearPanel.setLayout(new BorderLayout()); 

            /*setting the panel for check box and radio button*/
            JPanel ModePanel = new JPanel();
            ModePanel.setLayout(new BorderLayout());
            ModePanel.setBackground(Color.BLACK);
            ModePanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            /*adding the Boxcheck componenet into panel*/ 
            ModePanel.add(boxCheck);
            /*adding the modepanel into north panel */
            northPanel.add(ModePanel, BorderLayout.SOUTH);
            /*adding the north panel into the temporary panel named clearpanel*/
            ClearPanel.add(northPanel,BorderLayout.NORTH);
            /*adding the clear button into clearpanel for display*/
            ClearPanel.add(clear);

            /*adding the clearpanel into the whole panel*/
            add(ClearPanel,BorderLayout.NORTH);
            /*adding the keyButtons in the whole panel */
            add(KeyButton,BorderLayout.CENTER);
            /*adding the equal panel into the whole panel*/
            add(equal,BorderLayout.SOUTH);
        }

        /**
         * A method for creating JButton and group of relative buttons.
         * @param text-the textlabel button
         * @param ac - buttons action string.
         * @param fg - color for foreground button.
         * @param bg - color of the background.
         * @param handler - ActionListener button.
         * @return - reference to the button .
         */

       private JButton  createButton(String text, String ac, Color fg, Color bg, ActionListener handler){

           JButton button = new JButton(); //create a new button
           /**set new button properties**/
           button.setText(text);	
           button.setForeground(fg);
           button.setBackground(bg);
           /*if ac is bull then assign the actioncommand*/
           if (ac == null){
               button.setActionCommand(ac);
                }
           /*properties for the button font*/
           button.setFont(button.getFont().deriveFont(20F));
           /*setting the handler to an action event for the button*/
           button.addActionListener(handler);

            
                    switch(text) {
                    case "=":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), text);
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_MASK), text);
                            break;
                    case "+":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), text);
                            break;
                    case "/":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), text);
                            break;
                    case "-":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), text);
                            break;
                    case "*":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), text);
                            break;
                    case ".":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), text);
                            break;
                    case "c":
                    case "C":
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), text);
                            break;
                    default:
                            button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(text), text);
    }
                    button.getActionMap().put(text, (Action) handler);
                    /*return a reference to the button*/
                    return button;
       }


        /**
         * Controller which takes care of all the inner workings of the Calculator.
         * @author Aman Multani
         * @version 1.0
         * @see Calculator
         * @since 1.8.0_102
         */

    public class Controller extends AbstractAction {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                            /*returns the string identifying the command for event*/
                            String AC = e.getActionCommand(); 

                            int number = -1; 

                            try {  /*Parses the string argument as a signed decimal integer*/
                                    number = Integer.parseInt(AC); 

                            } /*whitout any opertion or string passed this will work*/
                            catch (NumberFormatException eA) { 
                                System.out.print("");
                            } /*Checking if the number is >=0 or not and and the errorstate is false or not */
                            if (number >= 0 && calc.getErrorState()== false ) { 
                                    display2.setText("");
                                    /*string is added to the actionCommand for more than one digit number*/
                                    StringInput += AC; 
                                    /*displaying the input string by the user on display2*/
                                    display2.setText(StringInput);
                            }  

                            /*checking for the single precision ".0" mode and the errorstate is false or not */
                            if (".0".equals(AC)&& calc.getErrorState()== false ){ 
                                /*checks if the Int check box is selected or not  */
                                    if (calc.getMode().equals("Int")){
                                            StringInput = "";
                                            /*displaying the textfield on the display2*/
                                            display2.setText("0.0");
                                    } 
                                    /*the error lable is set to "F" textfeild */
                                    error.setText("F");
                                    /*the mode is set to float*/
                                    calc.setMode(".0");
                                    /*setting the bg color to yellow when in F mode*/
                                    error.setBackground(Color.YELLOW); 
                                    /*makes the dot button clickable and focusable*/
                                    dotButton.setEnabled(true);
                                    /*dot button bg color blue */
                                    dotButton.setBackground(Color.BLUE);

                            }/**checking for the double precision ".00" mode and the errorstate is false or not */ 
                            else if (".00".equals(AC)&& calc.getErrorState()== false){ 
                                    /*checks if the Int check box is selected or not  */
                                    if (calc.getMode().equals("Int")){ 
                                            /*sets the user input to null*/	
                                            StringInput = "";
                                            /*displaying the textfield on the display2*/
                                            display2.setText("0.0");
                                    } 
                                    /*the error lable is set to "F" textfeild */
                                    error.setText("F");
                                    /*the mode is set to float*/
                                    calc.setMode(".00");
                                    /*setting the bg color to yellow when in F mode*/
                                    error.setBackground(Color.YELLOW);
                                    /*makes the dot button clickable and focusable*/
                                    dotButton.setEnabled(true);
                                    /*dot button bg color blue */
                                    dotButton.setBackground(Color.BLUE);

                            }/*checking for the Scintific precision "Sci" mode and the errorstate is false or not */
                            else if ("Sci".equals(AC)&& calc.getErrorState()== false){ 
                                    /*checks if the Int check box is selected or not  */
                                    if (calc.getMode().equals("Int")){ 
                                        /*sets the user input to null*/	
                                        StringInput = "";
                                        /*displaying the textfield on the display2*/
                                        display2.setText("0.0");
                                    } 
                                    /*the mode is set to the actionCommand*/
                                    calc.setMode(AC);
                                    /*the error lable is set to "F" textfeild */
                                    error.setText("F");
                                    /*setting the bg color to yellow when in F mode*/
                                    error.setBackground(Color.YELLOW);
                                    /*makes the dot button clickable and focusable*/
                                    dotButton.setEnabled(true); 
                                    /*dot button bg color blue */
                                    dotButton.setBackground(Color.BLUE);


                            }/*checking for "Int" mode and the errorstate is false or not */
                            else if ("Int".equals(AC)&& calc.getErrorState()== false){ 
                                    /*sets the user input to null*/
                                    StringInput = "";
                                    /*displayes the textfeild on the display2*/
                                    display2.setText("0");
                                    /*the mode is set to the "Int"*/
                                    calc.setMode("Int");
                                    /*the error lable is set to "I" textfeild */
                                    error.setText("I");
                                    /*the bg color of check box mode is turn green*/
                                    error.setBackground(Color.green);
                                    /*makes the dot button non-clickable and non-focusable*/
                                    dotButton.setEnabled(false); 
                                    /*when the dot button is disable the color chnage to (178,156,250)*/
                                    dotButton.setBackground(new Color(178,156,250));

                            }  
                            /*Now checking for the operation and the errrorstate is false. If ActionCommand matches the operator "+" then proceed*/    
                            if ("+".equals(AC) && calc.getErrorState()== false){ 				
                                    /* before going furthere we check if the first operand or userInput String is empty or not */
                                    if(!StringInput.isEmpty()){
                                            /*setting the first string or as we say Number*/
                                            calc.setOperand1(StringInput); 
                                            /* setting the second string or as we say Number*/
                                            calc.setOperand2(StringInput);
                                    }
                                    /*the arithmatic operation is selected for the calculation */
                                    calc.setArithmeticOp(AC);
                                    /*displaying the userinput and the operation symbol on the display1*/
                                    display1.setText(calc.getOperand1()+ "+");
                                    /*Now again the userinput is set to null*/
                                    StringInput = "";


                            }/*Now checking for the operation and the errrorstate is false. If ActionCommand matches the operator "-" then proceed*/ 
                            else if ("-".equals(AC)&& calc.getErrorState()== false){ 			
                                    /* before going furthere we check if the first operand or userInput String is empty or not */
                                    if(!StringInput.isEmpty()){
                                            /*setting the first string or as we say Number*/
                                            calc.setOperand1(StringInput);
                                            /* setting the second string or as we say Number*/
                                            calc.setOperand2(StringInput);
                                    }
                                    /*the arithmatic operation is selected for the calculation */
                                    calc.setArithmeticOp(AC);
                                    /*display the userinput and the operation symbol on the display1*/
                                    display2.setText( calc.getOperand1()+"-");
                                    /*Now again the userinput is set to null*/
                                    StringInput = "";


                            }/*Now checking for the operation and the errrorstate is false. If ActionCommand matches the operator "/" then proceed*/ 
                            else if ("/".equals(AC) && calc.getErrorState()== false){                                 
                                    /* before going furthere we check if the first operand or userInput String is empty or not */
                                    if(!StringInput.isEmpty()){
                                            /*setting the first string or as we say Number*/
                                            calc.setOperand1(StringInput);
                                            /* setting the second string or as we say Number*/
                                            calc.setOperand2(StringInput);
                                    }        
                                    /*the arithmatic operation is selected for the calculation */
                                    calc.setArithmeticOp(AC);
                                    /*display the userinput and the operation symbol on the display1*/
                                    display1.setText(calc.getOperand1()+ "/");
                                    /*Now again the userinput is set to null*/
                                    StringInput = "";

                            }/*Now checking for the operation and the errrorstate is false. If ActionCommand matches the operator "*" then proceed*/ 
                            else if ("*".equals(AC)&& calc.getErrorState()== false){ 
                                    /*but before going furthere we check if the first operand or userInput String is empty or not */
                                    if(!StringInput.isEmpty()){
                                            /*setting the first string or as we say Number*/
                                            calc.setOperand1(StringInput);
                                            /* setting the second string or as we say Number*/
                                            calc.setOperand2(StringInput);
                                    }
                                    /*the arithmatic operation is selected for the calculation */
                                    calc.setArithmeticOp(AC);
                                    /*display the userinput and the operation symbol on the display1*/
                                    display1.setText(calc.getOperand1()+ "*");
                                    /*Now again the userinput is set to null*/
                                    StringInput = "";

                            }/*checking if the Action Command is equal to the "C" clear button*/
                            else if ("C".equals(AC)){ // calls ResetCalc method
                                    /*check the mode if it is in "Int" */
                                    if (calc.getMode().equals("Int")){
                                            /*calling the ResetCalc method */
                                            calc.ResetCalc();
                                            /*sets the textfeild of the display1 to null*/
                                            display1.setText("");
                                            /*sets the textfeild of the display2 to "0"*/
                                            display2.setText("0");
                                            /*sets the user input to null*/
                                            StringInput = "";

                                    } else {/*if the mode is not "int"*/

                                            /*calling the ResetCalc method */
                                            calc.ResetCalc();
                                            /*sets the textfeild of the display1 to null*/
                                            display1.setText("");
                                            /*sets the textfeild of the display2 to "0"*/
                                            display2.setText("0");
                                            /*sets the user input to null*/
                                            StringInput = "";
                                            /*the error lable is set to "F" textfeild */
                                            error.setText("F");
                                            /*sets the bg color to yellow */
                                            error.setBackground(Color.YELLOW);
                                            /*set the errorstate to false*/
                                            calc.setErrorState(false);
                                    }
                            }/*when  the "=" action command is given to get the total of artimatic operations*/ 
                            else if ("=".equals(AC)&& calc.getErrorState()== false){ 

                                    if ( calc.getTotal().equals("")){ 
                                    /*sets the user input to null*/	
                                        StringInput = "";
                                        return;
                                    }
                                    /*if the input string is empty */
                                            if (!StringInput.isEmpty()){
                                                /*then take the second operand for calculation*/
                                                    calc.setOperand2(StringInput);
                                            }
                                    /*chechs if any number is divided by 0 and the input is 0*/
                                    if (calc.getTotal().equals("/") && StringInput.equals("0")){
                                        /*if the first operand or input is zero then display the error massage on  display2*/
                                        if (calc.getOperand1().equals("0")){
                                                    display2.setText("Result is undefined");
                                            } else {
                                            /*if the second operand is 0 then display this massage on display 2*/
                                                    display2.setText("cannot divide by zero");
                                            }
                                            /*the error lable is set to "E" textfeild */
                                            error.setText("E");
                                            /*set the bg color of the error lable to RED*/
                                            error.setBackground(Color.RED);
                                            /*set the error state to true*/
                                            calc.setErrorState(true);

                                    } else {
                                        /*set the display1 textfeild to null*/
                                            display1.setText("");
                                            /*get the answer for the aritmatic operation in the desire format by calling the method*/
                                            display2.setText((calc.RadioAndCheck()));
                                            calc.setOperand1(calc.RadioAndCheck());
                                            /*sets the user input to null*/
                                            StringInput ="";
                                    }

                            }/*when  the "[+-]" plusMinus action command is given by the user  */ 
                            else if ("\u00B1".equals(AC)&& calc.getErrorState()== false){ 
                                    /*check the length of the userinput number button is empty */ 
                                if (StringInput.isEmpty()){
                                            /*set the display1 textfield to null*/
                                            display1.setText("");
                                            /*set the display2 textfield to "0"*/
                                            display2.setText("0");

                                    } 
                                        /*if the string contains "-"*/
                                        if (StringInput.contains("-")){
                                                StringBuilder strB = new StringBuilder(StringInput);
                                                    strB.deleteCharAt(0);
                                                    /*inputString to the stringBuilder*/
                                                    StringInput = strB.toString();
                                                    /*display the input string by the user on the display2*/
                                                    display2.setText(StringInput);
                                            } else {
                                                /*the inputString have the value  " - " + userInput*/
                                                    StringInput = "-" + StringInput;
                                                    /*display the textfield on the display2*/
                                                    display2.setText(StringInput);
                                            }

                            }/*when  the "." action command is given and the errorstate is false*/
                            else if (".".equals(AC)&& calc.getErrorState()== false){ 
                                    /*checks if the user used the "." in any operation */
                                    if (StringInput.contains(".")){
                                            return;
                                    }		
                                    /*the new string is the userString input + "." */
                                    StringInput += AC; 
                                    /*display the new the new inputString on the display2 textfield*/
                                    display2.setText(StringInput);

                            }       
                           /*when  the "Backspace" action command is given to clear the last strininput by gthe user*/ 
                            else if ("\u21E6".equals(AC)&& calc.getErrorState()==false){ 
                                    /*check if the input length is > 0  and in situation where there are more than 1 number in the textfield remove from the last digit */
                                    int length = StringInput.length();
                                    String back = "";
                                    /*checckes if the string length is >1*/
                                    if(length > 1){
                                        /*looping and deleting each degit one by one when the "backspace is clicked"*/
                                            for(int i = 0 ; i < length-1 ; i++){
                                                    back += StringInput.charAt(i);
                                            }
                                            StringInput = back;
                                            /*displaying the output */
                                            display2.setText(StringInput);
                                    }
                                    /*when the last digit is left  the display is directly change in "0"  */
                                    if(StringInput.equals("-") || length == 1){
                                            StringInput = "";
                                            display2.setText("0");
                                        }

                            } 
                    } 

            } 

    }

