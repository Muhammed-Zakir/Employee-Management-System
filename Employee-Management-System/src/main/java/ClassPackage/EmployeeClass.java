
package ClassPackage;

import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EmployeeClass {
    
    FileOperations fs = new FileOperations("Employee.txt");
    
    private String  EmployeeId;
    private String  EmployeeName;
    private int Age;
    private String  Address;
    private String Deparment;
    
    
public EmployeeClass(){}

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String EmployeeId) 
    {
        this.EmployeeId = EmployeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) 
    {
        this.EmployeeName = EmployeeName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) 
    {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) 
    {
        this.Address = Address;
    }

    public String getDeparment() {
        return Deparment;
    }

    public void setDeparment(String Deparment)
    {
        this.Deparment = Deparment;
    }


    public boolean addEmployee() {
        
        if(!fs.createANewFile())
        {
            String record = EmployeeId + " " + EmployeeName + " " + Age + " " + Address+" " + Deparment;
            System.err.println(EmployeeId + " " + EmployeeName + " " + Age + " " + Address+" " + Deparment);
            return fs.WriteToFile(record);
        }
        return false;
    } 
    
    public String viewAllEmployee() 
      {
        String Employee, allEmployee = " ";
        
        String[] words;
        
        
        BufferedReader bufferedReader = fs.readAFile();
        try {
            while ((Employee = bufferedReader.readLine()) != null)
            {     
                words = Employee.split(" ");
                System.err.println(Employee);
          allEmployee = allEmployee + words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3] + "\t" + words[4] +"\n";
   
            }
        } catch (IOException ex) {
            System.out.println("Error view All Employee"+ex);
        }
        return allEmployee;
    }
       
    
       public String searchByEmployeeID(String EmployeeID){   
        BufferedReader br = fs.readAFile();
        String empLine,allEmployee = " ";
        String[] Emp;
        
        outerloop:
        try {
            while((empLine=br.readLine())!=null){
                Emp=empLine.split(" ");
                
                for (String word : Emp) {
                    if (word.equals(EmployeeID)) {
                         allEmployee = allEmployee + Emp[0] + "\t" + Emp[1] + "\t" + Emp[2] + "\t" + Emp[3] + "\t" + Emp[4] +"\n";

                    }
                }
                
            }   } catch (IOException ex) {  
            JOptionPane.showMessageDialog(null,"Error While Searching by EmployeeID" ,
                        "Search a Employee", JOptionPane.ERROR_MESSAGE);
        }
        return allEmployee;
    }
       
       public String searchByEmployeeName(String EmployeeName){ 
        BufferedReader br = fs.readAFile();
        String empLine,allEmployee=" ";
        String[] Emp;
        
        outerloop:
        try {
            while((empLine=br.readLine())!=null){
                Emp=empLine.split(" ");
                
                for (String word : Emp) {
                    if (word.equals(EmployeeName)) {
                         allEmployee = allEmployee + Emp[0] + "\t" + Emp[1] + "\t" + Emp[2] + "\t" + Emp[3] + "\t" + Emp[4] +"\n";
                    }
                }  
            }   } catch (IOException ex) {
             JOptionPane.showMessageDialog(null,"Error While Searching by Name" ,
                        "Search a Employee", JOptionPane.ERROR_MESSAGE);
        }
        return allEmployee;
    }
    
    public String searchByDepartment(String Department){ 
        BufferedReader br = fs.readAFile();
        String empLine,allEmployee=" ";
        String[] Emp;
        
        outerloop:
        try {
            while((empLine=br.readLine())!=null){
                Emp=empLine.split(" ");
                
                for (String word : Emp) {
                    if (word.equals(Department)) {
                        allEmployee = allEmployee + Emp[0] + "\t" + Emp[1] + "\t" + Emp[2] + "\t" + Emp[3] + "\t" + Emp[4] +"\n";
                    }
                }
            }   } catch (IOException ex) {
             JOptionPane.showMessageDialog(null,"Error While Searching by Department" ,
                        "Search a Employee", JOptionPane.ERROR_MESSAGE);
        }
         return allEmployee;
    }
}



