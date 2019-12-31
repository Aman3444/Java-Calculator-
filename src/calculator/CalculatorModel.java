
    /**
     * File Name:       CalculatorModel.java
     * Author:          Multani Aman, 040877727
     * Course:          CST8221 - JAP, 301
     * Assignment:      1 - Part 1 And Part 2
     * Date:            16 March 2018
     * Professor:       Svillen Ranev
     * Purpose:         class build the GUI of the calculator  
     * Class list:      CalculatorModel
     *                  
     */
    package calculator;

    import java.text.DecimalFormat;


    /**
     * This class class perform the calculation from that data input by the user
     * @author Aman Multani
     * @version 1.0
     * @see Calculator
     * @since 1.8.0_102
     */
    public class CalculatorModel {

        /*Declaration of the variable*/
            private String Op1; 
            private String Op2;
            private String mode;
            private boolean errorState;
            private String Operation;

            /**
            *
            *To initialize all the variables
            * 
            */

            public CalculatorModel() {
        /*initializing */
            errorState = false;
            Op1 = null;
            Op2 = null;
            Operation = null;
            mode = ".00";
    }

            /**
            * Setter method for the first operand.
            * @param op1 The first operand in the equation.
            */
            public void setOperand1(String op1){ 
                /*setting operand op1 */
                    this.Op1 = op1;
            }

            /**
            * Setter method for the second operand.
            * @param op2 The second operand in the equation.
            */
            public void setOperand2(String op2){
                /*setting operand op2*/
                    this.Op2 = op2;
            }

            /**
            * Getter method for returning the oprand1.
            * @return Op1 the first operand in the equation
            */

            public String getOperand1() { 
                /*getting operand op1 */
                    return Op1;
            }

            /**
            * Getter method for returning the oprand2.
            * @return Op2 the Second operand in the equation
            */
            public String getOperand2() {
                /*getting operand op2 */
                    return Op2;
            }

            /**
            * Getter method for returning the total from the calculation.
            * @return Operation 
            */
            public String getTotal() { 
                /*getting the total from the calculation*/
                    return Operation;
            }

            /**
            * Getter method for returning the errorstate.
            * @return errorState the first operand in the equation
            */
            public boolean getErrorState(){ 
                /*getting the error state*/
                    return errorState;
            }

            /**
            * Setter method for the ERRORSTATE field .
            * @param ERRORSTATE  the error state.
            */
            public void setErrorState(boolean ERRORSTATE){ 
                /*setting the error state */
                    errorState = ERRORSTATE;

            }

            /**
            * Setter method for the mode of the equation.
            *  @param mode Can be integer or float.
            */
            public void setMode(String mode){ 
                /*setting the moade*/
                    this.mode = mode;
            }

            /**
            * Getter method for the mode of the equation.
            * @param mode Can be integer or float.
            */
            public String getMode(){
                /*getting the mode*/
                    return mode;	
            }
            /**
            * Setter method for the operator.
            * @param Operation The operator of the equation.
            */
            public void setArithmeticOp(String Operation) {
                /*setting arithmetic operation */
                    this.Operation = Operation;
            }

            /*Setter for calculator operator*/
            public String getArithmeticOp(){
                    return Operation;
    }

            /*
            *This method will return float converted from a string value
            */
            public float converToFloat (String strng){ 
                /*converting the string to float and returning it*/
                    return Float.parseFloat(strng);
            } 


            /**
            * Method which performs the calculates the equation formed with the 
            * first operand, the operator, and the second operand.
            */
            private float Calculation(){ 

                /*if the operation is empty then return the operand2 into float value*/
                if (Operation.isEmpty()){ 
                            return converToFloat(Op2);
                    } 
                /*if the operand1 is empty then set the operand value to 0*/
                if (Op1.isEmpty()){
                            Op1 = "0";
                    }
                /*if operand2 is empty then set operand1 to same value of op2 */
                if(Op2.isEmpty()) {
                            this.Op2 = this.Op1;	
                    } 

                    /*cases for the operation*/
                    switch(Operation){

                    case "+": 
                        /*if addition then return the float value of both after addtition */
                        return converToFloat(Op1) + converToFloat(Op2);

                    case "-":
                        /*if subtraction then return the float value of both after subtraction */
                        return converToFloat(Op1) - converToFloat(Op2); 

                    case "*":
                        /*if multiplication then return the float value of both after multiplication */
                        return converToFloat(Op1) * converToFloat(Op2); 

                    case "/":
                        /*if division then return the float value of both after division */
                        return converToFloat(Op1) / converToFloat(Op2);
                    default :
                    }
                    return 0;
            }




        /**
         * Returns a result based on the mode, either
         * integer or floating point. If floating point, will also format
         * based on the precision set.
         * @return A string formatted depending on the mode and the precision.

         */
            public String RadioAndCheck(){ 
            /*Creates a DecimalFormat using the default pattern.*/	
                DecimalFormat Formatter;
                    /*check if the mode is "Int"*/
                    if (("Int".equals(mode))){
                        /*mals the math function to round off the integer */
                            return String.valueOf(Math.round(Calculation())); 
                    }/*check is the mode is double precision */ 
                    else if (mode.equals(".00")){
                        /*return the value into the decimal Formate*/
                        /*calling the calculation() and will return the reuslt on the mode */
                            Formatter = new DecimalFormat("0.00") ;
                            return Formatter.format(Calculation() ) ;
                    }/*check if the mode is single precision*/ 
                    else if (mode.equals(".0")){
                        /*return the value into the decimal Formate*/
                        /*calling the calculation() and will return the reuslt on the mode */
                            Formatter = new DecimalFormat("0.0");
                            return Formatter.format(Calculation()); 
                    }/*check if the mode is "Sci"*/
                    else if (mode.equals("Sci")){
                        /*return the value into the decimal but (scintific) Formate */
                        /*calling the calculation() and will return the reuslt on the mode */
                            Formatter = new DecimalFormat("0.#####E00");
                            return Formatter.format(Calculation());
                    } 
                    return "";
            } 

            /**
              * To reset all the variable to null in the text field.
              */
            public void ResetCalc(){ 
            /*reset everything to null*/	
                Op1 = null;
                Op2 = null;
                Operation = null;
            } 




    } 