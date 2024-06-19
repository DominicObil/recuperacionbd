


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transacciones {
    public static void main(String[] args) {
       Connection con=Conexion.conectar();

        try{
        	  con.setAutoCommit(false);

              Linea linea1 = new Linea("linea1");
              LineaModel.insertLinea(con, linea1);

              Producto producto1 = new Producto(
                  "sssss", "producto1", "linea1", "1:1",
                  "vendedor1", "descripcion1",
                  15, 5, 7
              );
              ProductoModel.insertProducto(con, producto1);
              con.commit();
              System.out.println("Transaccion lista");
            
               
        }catch (SQLException e){
            System.out.println("error: " +e.getMessage());
            try{
                if (con!=null){
                    System.out.println("Dejamos la BBDD en estado consistente.");
                	//COMPLETAR AQUI
                    con.rollback();
                }
            } catch (SQLException throwables){
                System.out.println("Error en el rollback");
                throwables.printStackTrace();
            }
        }
    }
}
