package Services;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Tools {

    public static void msgBox(String message){ // to displayed message in anywhere.
        JOptionPane.showMessageDialog (null, message);
    }

    public static void CreateFolder(String folderName, String path){ // to create any folder anywhere
        File file = new File(path+ "/" + folderName);
        file.mkdirs ();
    }
    public  static void CreateEmptyFile(String filename) throws IOException {
            File file = new File(filename);
            file.createNewFile ();
    }
    public static void createFileLines(String fileName, Object data[]) throws FileNotFoundException {
        PrintWriter p = new PrintWriter (fileName);
        for(Object obj : data) {
            p.println ( obj );
            p.close ();
        }
    }
}
