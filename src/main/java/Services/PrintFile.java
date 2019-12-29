package Services;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintFile {

    public static void PrintFiles ( String FileName, String des) {
      try {
          PrintWriter w = new PrintWriter (FileName);
          w.write (des);
          w.close ();
        // need to save all files to the specific folder
      }catch(FileNotFoundException ex){
          System.out.println(ex.getMessage ());
      }
    }
}