package Services;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintFile {

     public static void PrintFiles ( String FileName, String des) {// to create file inside the project file.
      try {
          PrintWriter w = new PrintWriter (FileName);
          w.write (des);
          w.close ();
          Tools.CreateFolder ("Test","./PrintFilesFolder/");
       }catch(FileNotFoundException ex){
          System.out.println(ex.getMessage ());
       }
     }

     public static void PrintFiles2 ( String path, String des) { // to create file inside the specific  folder.
        try {
            PrintWriter w = new PrintWriter (path);
            w.write (des);
            w.close ();
            Tools.CreateFolder ("Test","./PrintFilesFolder/");
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage ());
        }
     }

    }
