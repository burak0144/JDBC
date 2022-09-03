package jdbc_brk.dbWork_callableStatement;

import java.sql.SQLException;

public class Z01_CallableStatement {
    public static void main(String[] args) throws SQLException {
        DBWork_brk con =new DBWork_brk();
        con.postgresBaglanti("burak","postgres","665532");
        con.getStatement();
        //1. Örnek: İki parametre ile çalışıp bu parametreleri carparak return yapan bir FONKSIYON oluşturun.
        String sql="CREATE OR REPLACE FUNCTION carpmaF(x numeric,y numeric)\n" + //fonsyiyonu olusturuyoruz
                "returns numeric\n" +
                "language plpgsql\n" +  //lang ismi onemli dogru girilmeli
                "as\n" +
                "$$\n" +
                "begin\n" +
                "return x*y;\n" +  //yapacagimiz islem
                "end\n" +
                "$$";
        con.functionOlusturma(6,8);

        //Silindirin hacmini hesaplayin
        String sql2="CREATE OR REPLACE FUNCTION silindirinHacmiF(r numeric,h numeric)\n" + //fonsyiyonu olusturuyoruz
                "returns numeric\n" +
                "language plpgsql\n" +  //lang ismi onemli dogru girilmeli
                "as\n" +
                "$$\n" +
                "begin\n" +
                "return 3.14*x*x*y;\n" +  //yapacagimiz islem
                "end\n" +
                "$$";
        con.functionOlusturma2(3,5);


    }
}
