    /**
     * File Name:       CalculatorSplashScreen.java
     * Author:          Multani Aman, 040877727
     * Course:          CST8221 - JAP, 301
     * Assignment:      1 - Part 1 And Part 2
     * Date:            16 March 2018
     * Professor:       Svillen Ranev
     * Purpose:         Displays the splash screen before the calculator program.  
     * Class list:      CalculatorSplashScreenController
     *                  
     */
    package calculator;

    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.awt.Toolkit;
    import javax.swing.BorderFactory;
    import javax.swing.ImageIcon;
    import javax.swing.JProgressBar;

    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JWindow;
    /**
     *
     * @author Aman Multani
     * @version 1.0
     * @see   calculator
     * @since 1.8.0_102 
     */

    public class CalculatorSplashScreen extends JWindow {
     /** Swing components are serializable and require serialVersionUID */
      private static final long serialVersionUID = 6248477390124803341L;
      /** Splash screen duration */
      private final int duration;
    /**
      Default constructor. Sets the show time of the splash screen.
    */
      public CalculatorSplashScreen(int duration) {
        this.duration = duration;
      }
    /*Builds a splash screen window */
      public void showSplashWindow() {
        /**create content pane**/
        JPanel content = new JPanel(new BorderLayout());
        /** create panel to hold process component */
        JPanel panel = new JPanel(new BorderLayout());


        /** To set the progressBar to show the loading progress */
        JProgressBar progress = new JProgressBar();
        progress.setMinimum(0);
        progress.setMaximum(duration);
        /*set the bg color to white*/
        progress.setBackground(Color.WHITE);
        /*set the foregroung color to red*/
        progress.setForeground(Color.RED);
        /*the dimensions */
        progress.setPreferredSize(new Dimension(10, 20));


        /** To display the content when progressing */
        JLabel progressLabel = new JLabel("Loading Calculator. Please wait...");
        progressLabel.setForeground(Color.RED);
        /*alignment of the bar*/
        progressLabel.setHorizontalAlignment(JLabel.CENTER);
        /*font size and font type */
        progressLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 15));
        progressLabel.setOpaque(false);


        content.setBackground(Color.WHITE);
        panel.setOpaque(false);

        /** To add processBar into panel */
        panel.add(progress, BorderLayout.NORTH);
        panel.add(progressLabel, BorderLayout.SOUTH);

        // Set the windows position
        int width =  300+10;
        int height = 360+10;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        //set the location and the size of the splash screen
        setBounds(x,y,width,height);

        // Create the splash screen
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("superman.gif"))); 
        JLabel demo = new JLabel("Aman Multani's App Splash Window ", JLabel.CENTER);
        demo.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));

        content.add(panel, BorderLayout.NORTH);
        content.add(label, BorderLayout.CENTER);
        content.add(demo, BorderLayout.SOUTH);

        // create custom RGB color
        Color customColor = new Color(44, 197, 211);
        content.setBorder(BorderFactory.createLineBorder(customColor, 10));

        //replace the window content pane with the content JPanel
        setContentPane(content);

        //show splash screen
        setVisible(true);

        try {
                    for (int i = 0 ; i < duration; ++i) {
                                    progress.setValue(i);
                                    Thread.sleep(1);
                            }
        }
        catch (InterruptedException e) {/*can be use to log an error*/}
        //destroy the window and release all resources
        dispose();
      }//end  of showsplashwindow
    }//end of calculatorsplashscreen