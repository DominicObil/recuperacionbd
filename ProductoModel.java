

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProductoModel {
    public static void insertProducto(Connection con, Producto producto) throws SQLException{
        String sql="INSERT INTO products VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement sentencia=con.prepareStatement(sql);

        sentencia.setString(1, producto.getProductCode());
        sentencia.setString(2, producto.getProductName());
        sentencia.setString(3, producto.getProductLine());
        sentencia.setString(4, producto.getProductScale());
        sentencia.setString(5, producto.getProductVendor());
        sentencia.setString(6, producto.getProductDescription());
        sentencia.setInt(7, producto.getQuantityInStock());
        sentencia.setInt(8, producto.getBuyPrice());
        sentencia.setInt(9, producto.getMSRP());

        sentencia.executeUpdate();
    }

}
