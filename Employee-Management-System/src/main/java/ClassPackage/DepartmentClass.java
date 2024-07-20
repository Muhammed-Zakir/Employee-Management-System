
package ClassPackage;
import java.io.BufferedReader;
public class DepartmentClass {
    FileOperations fs = new FileOperations("Department.txt");
    private String  DeptId;
    private String  DeptName;
    private String DeptLocation;
    private int  Deptsize;

    public String getDeptId() {
        return DeptId;
    }

    public void setDeptId(String DeptId) {
        this.DeptId = DeptId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String DeptName) {
        this.DeptName = DeptName;
    }

    public String getDeptLocation() {
        return DeptLocation;
    }

    public void setDeptLocation(String DeptLocation) {
        this.DeptLocation = DeptLocation;
    }

    public int getDeptsize() {
        return Deptsize;
    }

    public void setDeptsize(int Deptsize) {
        this.Deptsize = Deptsize;
    }
    

    public boolean addDepartment() {
        
        if(!fs.createANewFile())
        {
            String record = DeptId + " " + DeptName + " " + DeptLocation + " " + Deptsize;
            System.err.println(DeptId + " " + DeptName + " " + DeptLocation + " " + Deptsize);
            return fs.WriteToFile(record);
        }
        return false;
    } 
    
    public String viewAllDepartment() 
      {
        String Department, allDepartment = " ";
        
        String[] words = null;
        
        //int count = 0;
        
        BufferedReader bufferedReader = fs.readAFile();
        try {
            while ((Department = bufferedReader.readLine()) != null)
            {     
                words = Department.split(" ");
                System.err.println(Department);
          allDepartment = allDepartment + words[0] + "\t" + words[1] + "\t" + words[2] + "\t" + words[3] +"\n";

                //count++;      
            }
        } catch (Exception ex) {
            System.out.println("Error view All Department"+ex);
        }
        return allDepartment;
    }
       

}
