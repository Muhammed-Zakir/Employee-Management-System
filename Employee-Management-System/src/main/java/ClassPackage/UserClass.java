
package ClassPackage;

import java.io.BufferedReader;
import java.io.IOException;

public class UserClass {
    FileOperations fs=new FileOperations("Users.txt");
     
    private String UserId;
    private String Password;
    private String UserType;

    public UserClass(){}
    public UserClass(String UserId, String Password) 
    {
        this.UserId = UserId;
        this.Password = Password;
    }

    public UserClass(String UserId, String Password, String UserType) {
        this.UserId = UserId;
        this.Password = Password;
        this.UserType = UserType;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    
    public boolean addNewUser() {
        if(!fs.createANewFile()){
            String record = UserId + " " + Password+ " " + UserType ;      
            System.err.println(UserId + " " + Password+ " " + UserType);
            return fs.WriteToFile(record);
        }
        return false;
    }
    
    public boolean validateLogin() {
        try {
            String[] words;            
            BufferedReader UserbufferedReader  = fs.readAFile();
            String user;

            while ((user = UserbufferedReader.readLine()) != null)
            {              
                words = user.split(" ");
                    
                if (words[0].equals(UserId) && words[1].equals(Password)) {
                    this.setUserId(words[0]);
                    this.setPassword(words[1]);
                    this.setUserType(words[2]);
                    return true;
                }
            }
        } catch (IOException ex) {
            System.out.println("Error Validating Login"+ex);
        }
       
        return false;
    }
    
    public String viewAllUsers() {
        String user, allUsers = " ";
        String[] words;

        BufferedReader bufferedReader = fs.readAFile();
        try {
            while ((user = bufferedReader.readLine()) != null) {    
                words = user.split(" ");
                System.err.println(user);
                allUsers = allUsers + words[0] +  "\t" +  words[1] + "\t" + words[2]+ "\n";
                
            }
        } catch (IOException ex) {
              System.out.println("Error view All Users"+ex);
        }       
        
        return allUsers;
    }
}
