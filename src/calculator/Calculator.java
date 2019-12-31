
    /**
     * File Name:       Calculator.java
     * Author:          Multani Aman, 040877727
     * Course:          CST8221 - JAP, 301
     * Assignment:      1 - Part 1 And Part 2
     * Date:            16 March 2018
     * Professor:       Svillen Ranev
     * Purpose:         Main method.  
     * Class list:      Calculator
     *                  
     */
    package calculator;

    import java.awt.Dimension;
    import javax.swing.JFrame;
    import java.awt.EventQueue;

    /**
     * @author Aman Multani
     * @version 1.0
     * @see   calculator
     * @since 1.8.0_102 
     */
    public class Calculator {
         /**
          * main method displays the splash screen and creates the calculator
         * @param args the command line arguments
         */
        public static void main(String[] args) {
         CalculatorSplashScreen splashScreen = new CalculatorSplashScreen(5000);
         splashScreen.showSplashWindow();


         EventQueue.invokeLater(new Runnable(){ 
              @Override
            public void run(){

               /*setting the frame */
               JFrame frame = new JFrame();
               frame.setTitle("Calculator");
               int width = 320;
               int height = 520;
               frame.setMinimumSize(new Dimension(width, height));
               // set up the Close button on the frame
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setContentPane(new CalculatorViewController());
               /*Make the GUI Visible*/
               frame.setVisible(true);
            }      
        });            
        }    
    }