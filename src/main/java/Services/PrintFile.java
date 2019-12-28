package Services;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintFile {

    public static void PrintFiles ( String FileNAme, String des) throws FileNotFoundException {
        PrintWriter w = new PrintWriter (FileNAme);
        w.write (des);
        w.close ();
    }
}