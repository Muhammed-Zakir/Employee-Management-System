
package ClassPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperations {
    
    private static String FILE_PATH = "D:\\Files2\\";


    File file;
    private String fileName;
    
    public FileOperations(String fileName)
    {
        this.fileName = fileName;        
        createANewFile();
    }
    
     public boolean createANewFile() {
        try {
            file = new File(FILE_PATH + fileName);
            if (file.createNewFile()){
                System.out.println("File Created: " + file.getName());
                return true;
            }
            
            System.out.println("File Already Exisit !");
            return false;
        } catch(IOException e) {
            System.out.println("Something went wrong with creating file" + e);
            return false;
        }
    }
     
public boolean WriteToFile(String record)
        {
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(record);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();

            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong with writing" + e);
            return false;
        }
    }

public BufferedReader readAFile() {
        if(!createANewFile())
        {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                return bufferedReader;
            } catch (IOException ex) {
                System.out.println("Something went wrong with Reading the file" + ex);
            }
        }       
        return null;
    }
}

