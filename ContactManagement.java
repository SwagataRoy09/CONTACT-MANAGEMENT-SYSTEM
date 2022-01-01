import java.sql.*;
import java.util.Scanner;

public class ContactManagement {
    static Statement management() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContactManagement", "root", "root");
        Statement st = con.createStatement();
        return st;
    }

    static void insert(String name, String no) throws Exception {
        String query = "insert into contacts values('" + name + "','" + no + "')";
        management().executeUpdate(query);
    }

    static void delete(String name) throws Exception {
        String query = "delete from contacts where name='" + name + "'";
        management().executeUpdate(query);
    }

    static void deleteAll() throws Exception {
        String query = "delete from contacts";
        management().executeUpdate(query);
    }

    static void display() throws Exception {
        String query = "select * from contacts";
        String query1 = "select  exists (select false from contacts)";

            ResultSet rs = management().executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));

        }
    }

    static void search(String name) throws Exception {
        String query = "select * from contacts order by name";
        ResultSet rs = management().executeQuery(query);
        boolean flag = true;
        while (rs.next()){
            if (rs.getString(1).contains(name)){
                flag=true;
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
        }
        if(!flag){
            System.out.println(" NAME NOT FOUND ");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1]INSERT CONTACT\n" + "[2]DELETE PARTICULAR CONTACT\n" + "[3]DISPLAY\n" +"[4]SEARCH\n"+"[5]DELETE ALL CONTACT\n"+"[6]EXIT");
        while (true) {
            System.out.println("ENTER YOUR CHOICE");
            char ch = sc.next().charAt(0);
            switch (ch) {
                case '1' -> {
                    System.out.println(" ENTER THE NAME OF THE PERSON ");
                    sc.nextLine();
                    String name = sc.nextLine().toUpperCase();
                    System.out.println(" ENTER THE CONTACT NUMBER ");
                    String no = sc.next();
                    insert(name, no);
                }
                case '2' -> {
                    System.out.println("ENTER THE NAME YOU WANT TO DELETE");
                    sc.nextLine();
                    String n = sc.nextLine().toUpperCase();
                    delete(n);
                }
                case '3' -> {

                    display();
                }
                case '4'->{
                    System.out.println("ENTER THE NAME YOU WANT TO SEARCH");
                    sc.nextLine();
                    String n = sc.nextLine().toUpperCase();
                    search(n);
                }
                case '5'->{
                    System.out.println("ALL CONTACTS ARE DELETED");
                    deleteAll();
                }
                case '6' -> System.exit(0);

            }
        }
    }
}
