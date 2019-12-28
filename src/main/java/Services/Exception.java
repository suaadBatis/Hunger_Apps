package Services;


import javax.swing.*;

public class Exception extends Throwable {
    public static  void main (String[] args) {

        try {
            int x = 5;
            int y = 1;
            int r = x / y;
            System.out.println (r);

            String str []= new String[5];
            str [0] = "123";
            System.out.println(str[5]);

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
