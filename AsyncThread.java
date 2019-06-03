import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsyncThread extends Thread{
    String a1="", b1="";
    public AsyncThread(String a,String b)
    {
    a1=a;
    b1=b;
    }
    public void run(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDetail","vinoth","vinoth");
    PreparedStatement stmt=con.prepareStatement("insert into Detail values(?,?,?)");
            stmt.setString(1,a1);
            stmt.setString(2,b1);
            stmt.setString(3,Thread.currentThread().getName());
            stmt.execute();
            con.close();

    }
    catch(Exception e){ System.out.println(e);}
    }
public static void main(String args[]){
List<String> fname=new ArrayList<String>();
        fname.add("Vinoth");
        fname.add("Sesha");
        fname.add("Sachin");
        fname.add("Dinesh");
        fname.add("Karan");
    List<String> lname=new ArrayList<String>();
lname.add("Kumar");
        lname.add("Janarthan");
        lname.add("Sabarish");
        lname.add("Kumar");
        lname.add("Kumar");
        AsyncThread obj;
        for(int i=0;i<5;i++)
        {
                obj=new AsyncThread(fname.get(i),lname.get(i));
                obj.start();
        }   
}
}