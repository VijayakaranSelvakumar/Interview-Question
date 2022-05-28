import java.util.*;
import java.io.*;

public class Employee {   
        public static void main(String[] args) {
            String line = "";  
            String splitBy = ",";  
            HashMap<String,String> Designation=new HashMap<>();
            HashMap<String,String> Salary_details=new HashMap<>();
            HashMap<String,Object> Employee_details=new HashMap<>();
            try   
            {  
            //parsing a CSV file into BufferedReader class constructor  
            BufferedReader Position = new BufferedReader(new FileReader("Employee_Position.csv"));  
            BufferedReader Salary = new BufferedReader(new FileReader("Employee_Salary.csv"));  
            BufferedReader Employee = new BufferedReader(new FileReader("Employee_table.csv"));  
            Position.readLine();
            while ((line = Position.readLine()) != null)   //returns a Boolean value  
            {  
            String[] designation = line.split(splitBy);    // use comma as separator  
            String[] exp =designation[0].split("-");
            if(exp.length==1)
            continue;
            for(Integer val=Integer.parseInt(exp[0]);val<=Integer.parseInt(exp[1]);val++)
            {
                Designation.put(val.toString(),designation[1]);
            }
            }  
            Salary.readLine();
            while ((line = Salary.readLine()) != null)   //returns a Boolean value  
            {  
            String[] salary = line.split(splitBy);    // use comma as separator  
            Salary_details.put(salary[0],salary[1]);
            }  
            Employee.readLine();
            while ((line = Employee.readLine()) != null)   //returns a Boolean value  
            {  
            String[] employee = line.split(splitBy);    // use comma as separator  
            HashMap<String,String> emp=new HashMap<>();
            emp.put("EmployeeId",employee[0]);
            emp.put("EmployeeName",employee[1]);
            emp.put("Experience",employee[2]);
            //System.out.println(Double.parseDouble(employee[2]));
            String exp[]  = employee[2].split("[.]");
            String desg=" "; 
            if(Designation.containsKey(exp[0]))
            {
                desg=Designation.get(exp[0]);
            }
            else
            {
                desg="Senior Lead Developer";
            }
           
            emp.put("Designation",desg);
            String sal=Salary_details.get(desg);
            emp.put("Salary",sal);

            Employee_details.put(employee[0],emp);
            }  
            System.out.println(Salary_details);
            System.out.println(Designation);
            System.out.println(Employee_details);


            Position.close();
            Salary.close();
            Employee.close();
            }   
            catch (Exception e )   
            {  
            e.printStackTrace();  
            }  

    }
}
