
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LineaModel {
        public static void insertLinea(Connection con, Linea linea) throws SQLException {

        String sql="INSERT INTO productlines VALUES (?, NULL, NULL, NULL)";

       /* COMPLETAR AQUI*/
        PreparedStatement sentencia=con.prepareStatement(sql);
        sentencia.setString(1, linea.getProductLine());
        sentencia.executeUpdate();
    }
}
