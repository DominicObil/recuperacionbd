

import java.sql.*;
import java.util.Scanner;

public class Consultas {	
	  public static void empleadosOficinaMayor(Connection connection) {
	        try {

	        	Statement statement = connection.createStatement();	        	
	        	statement.setQueryTimeout(30);
	        	
	            Scanner sc = new Scanner(System.in);
	            System.out.println("\nIntroduzca el número de cliente (p.e 151): ");
	            //Cliente número 151 tiene un total de pagos de 177.913,95
	            
	            String cn = sc.nextLine(); 
           
	            // COMPLETAR AQUI
	            
	            String sql = "SELECT e.* " +
	                     "FROM employees e " +
	                     "WHERE e.officeCode = ( " +
	                     "SELECT o.officeCode " +
	                     "FROM offices o " +
	                     "INNER JOIN employees e ON o.officeCode = e.officeCode " +
	                     "GROUP BY o.officeCode " +
	                     "ORDER BY COUNT(e.employeeNumber) DESC " +
	                     "LIMIT 1 " +
	                     ")";
	        
	     
	        PreparedStatement sentencia = connection.prepareStatement(sql);
	  


	            ResultSet rs=sentencia.executeQuery();

	            while (rs.next()) {
	            	System.out.println("--pagosCliente-----------");
	            	System.out.println("Número cliente: "+cn);
	                System.out.println("Nombre :" + rs.getString(1));
	                System.out.println("Importe total :" + rs.getString(2) + " euros");
	                System.out.println("-------------------------");
	            }    

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	    }
	  
	  
	  public static void informeCategoría(Connection connection) {
	        try {

	        	Statement statement = connection.createStatement();	        	
	        	statement.setQueryTimeout(30);
	   
	            Scanner sc = new Scanner(System.in);
	            System.out.println("\nIntroduzca el nombre de la categoría: (P.e Shssss) ");
	             
	            String cn = sc.nextLine();

	            
	            

	                        

	    
	            // COMPLETAR AQUI

	            String sql = "SELECT p.productName, SUM(od.quantityOrdered) AS totalUnidadesVendidas " +
                        "FROM products p " +
                        "JOIN orderdetails od ON p.productCode = od.productCode " +
                        "WHERE p.productLine = ? " +
                        "GROUP BY p.productName";

               PreparedStatement sentencia = connection.prepareStatement(sql);
               sentencia.setString(1, cn);
	            
	            ResultSet rs=sentencia.executeQuery();

	            System.out.println("--informeCategoría-----------");
           	 	System.out.println("Nombre categoría: "+cn);
           	 	
	            while (rs.next()) {
	                 System.out.println("Nombre producto :" + rs.getString(1));
	                 System.out.println("Unidades vendidas :" + rs.getInt(2)+"\n");
	             	}
	            	System.out.println("-------------------------");
	         }  catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	}  
	  
	
	 
    public static void main(String[] args) {
		Conexion conexion = new Conexion();
		     		
		try {
			Connection connection = conexion.conectar();
			
			empleadosOficinaMayor(connection);
			informeCategoría(connection);
				
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
 }
