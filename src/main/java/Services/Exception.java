package Services;


import javax.swing.*;

public class Exception extends Throwable {
    public static  void main (String[] args) {

        try {
           // Functions here!

        } catch(java.lang.Exception ex){

            if ((ex.getMessage().equals ("/ by zero"))){
             // System.out.println(ex.getMessage ());
                JOptionPane.showMessageDialog (null, " here is logic error ");// to show the exception message alert
             }
            else {
                JOptionPane.showMessageDialog (null, " here is other issue  ");// to show the exception message alert

            }
        }

    }
}
