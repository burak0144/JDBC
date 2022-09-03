package jdbc_brk.dbWork_callableStatement;

import java.sql.Connection;

public class Main_brk {
    public static void main(String[] args) {
       DBWork_brk baglanti=new DBWork_brk();
        Connection conn =baglanti.postgresBaglanti("burak","postgres","665532");

        DBWork_brk tabloOlusturma=new DBWork_brk();
        tabloOlusturma.tabloOlusturma(conn,"new");
    }
}
