package jdbc_brk.dbWork_callableStatement;

import java.sql.*;

public class DBWork_brk {
    Connection conn = null;
    Statement st;
    CallableStatement cst;

    //Postgresql baglanti methodu
    public Connection postgresBaglanti(String dbName, String userName, String password) {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, userName, password);
            System.out.println("Baglanti saglandi");
        } catch (Exception e) {
            System.out.println("Baglanti saglanamadi");
        }
        return conn;
    }

    //Yeni table olusturma methodu
    public void tabloOlusturma(Connection conn, String tableName) {

        try {
            String sql = "Create table new (isim varchar(20),numara INTEGER )";
            st = conn.createStatement();
            st.execute(sql);
            System.out.println("Tablo olusturuldu");
        } catch (Exception e) {
            System.out.println("Tablo olusturulmadi");
        }
    }

    public Statement getStatement() {
        try {
            st = conn.createStatement();
            System.out.println("Adim olusturuldu");
        } catch (SQLException e) {
            System.out.println("hata verildi");
        }
        return st;
    }

    public CallableStatement functionOlusturma(int x, int y) {
        try {
            cst = conn.prepareCall("{? =call carpmaF(?,?)}");//1.soru isareti return olan
            cst.registerOutParameter(1, Types.NUMERIC);//return
            cst.setInt(2, x);//parametreler
            cst.setInt(3, y);//parametreler
            cst.execute();
            System.out.println("fonksiyon olusturuldu");
            System.out.println("sonuc = " + cst.getBigDecimal(1));
        } catch (SQLException e) {
            System.out.println("islem yapilamadi");
        }
        return cst;
    }

    public CallableStatement functionOlusturma2(int r, int h) {
        try {
            cst = conn.prepareCall("{? =call silindirinHacmiF(?,?)}");//1.soru isareti return olan
            cst.registerOutParameter(1, Types.NUMERIC);//return
            cst.setInt(2, r);//parametreler
            cst.setInt(3, h);//parametreler
            cst.execute();
            System.out.println("fonksiyon olusturuldu");
            System.out.println("silindirin hacmi = " + cst.getBigDecimal(1));
        } catch (SQLException e) {
            System.out.println("islem yapilamadi");
        }
        return cst;
    }
}