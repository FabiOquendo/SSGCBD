package gestionconsultassqlmodels.generate.conexionBD;



import java.sql.DriverManager;

import com.mysql.jdbc.Connection;



public class DataConnection {

	/**
	 * atibutos de la clase
	 */
	private static Connection con;
	private static DataConnection INSTANCE = null;
	
	/**
	 * Constructor
	 */
	public DataConnection() {
		
	}
	
	/**
	 * datos de la conexion
	 */
	public static void performConnection(){
		
		String host = "127.0.0.1";
		String user = "root";
		String pass = "12345";
		String dtbs = "sysinfo";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs
					+ "?" + "user=" + user + "&password=" + pass;
					con = (Connection) DriverManager.getConnection(newConnectionURL);
					System.out.println("Conexi�n efectuada con �xito");
		}catch (Exception e) {
			System.out.println("Error en la conexi�n");
		}
	}
	
	/**
	 * crear una instancia de una conexion
	 */
	private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new DataConnection();
            performConnection();
        }
    }
 
    /**
     * metodo para obtener una instancia, si ya existe la retorna, sino la crea
     * @return instancia si existe
     */
    public static DataConnection getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    public Connection getConnection(){
    	return con;
    }
    /**
	 * metodo para cerrar la conexi�n
	 */
	public void closeConnection() {
		try {
			con.close();
		}catch (Exception e) {
			System.out.println("Error en el cierre de conexi�n");
		}
	}
}
