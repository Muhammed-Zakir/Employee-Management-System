
package ClassPackage;
import ClassPackage.FileOperations;
import java.io.BufferedReader;
import java.io.IOException;

public class DesignationClass {
    private String DesignationId;
    private String DesignationName;
    private String AssociatedDepartment;
    private int YrsOfExperience; 

    public String getDesignationId() {
        return DesignationId;
    }

    public void setDesignationId(String DesignationId) {
        this.DesignationId = DesignationId;
    }

    public String getDesignationName() {
        return DesignationName;
    }

    public void setDesignationName(String DesignationName) {
        this.DesignationName = DesignationName;
    }

    public String getAssociatedDepartment() {
        return AssociatedDepartment;
    }

    public void setAssociatedDepartment(String AssociatedDepartment) {
        this.AssociatedDepartment = AssociatedDepartment;
    }

    public int getYrsOfExperience() {
        return YrsOfExperience;
    }

    public void setYrsOfExperience(int YrsOfExperience) {
        this.YrsOfExperience = YrsOfExperience;
    }
   
    FileOperations fs=new FileOperations("Designations.txt");
    
    public boolean addNewDesignation(){
        if(!fs.createANewFile()){
            String record=DesignationId+" "+DesignationName+" "+" "+AssociatedDepartment+" "+YrsOfExperience;
            System.err.println(DesignationId+" "+DesignationName+" "+" "+AssociatedDepartment+" "+YrsOfExperience);
            return fs.WriteToFile(record);
        }
        return false;
    }
    
    public String viewAllDesignations() 
      {
        String Designation, allDesignation = " ";
        String[] words;

        BufferedReader bufferedReader = fs.readAFile();
        
        try {
            while ((Designation = bufferedReader.readLine()) != null)
            {     
                words = Designation.split(" ");
                System.err.println(Designation);
          allDesignation = allDesignation + words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3] +"\n";
 
            }
        } catch (IOException ex) {
            System.out.println("Error view All Designation"+ex);
        }
        return allDesignation;
    }
}
