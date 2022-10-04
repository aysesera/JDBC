package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "ayse123..");
        Statement st = con.createStatement();
//1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan
// number_of_employees değerlerini 16000 olarak UPDATE edin.


      String sql1="UPDATE companies\n" +
              "SET number_of_employees = 16000\n" +
              "WHERE number_of_employees < (SELECT AVG(number_of_employees)\n" +
              "                             FROM companies)";
      int updateSatirSayisi=st.executeUpdate(sql1);// kac satır degistigini soyler int doner
        System.out.println("updateSatirSayisi = " + updateSatirSayisi);
         //field,column = sütun
        //record,row = satir


        String sql2="SELECT * FROM companies";
       ResultSet result1=st.executeQuery(sql2);
       while (result1.next()){
           System.out.println(result1.getInt(1)+"---"+result1.getString(2)+"---"+result1.getString(3));
       }

       st.close();
       con.close();
       result1.close();
    }
}