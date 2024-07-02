package DatabaseConnectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public final class DatabaseConnection {
	
	
	private  DatabaseConnection() 
	{	
	}
	
	private static  Connection  con = null;
	
	public static Connection getConnection() {
		
		if(con==null) {
			try {
				
			Class.forName(DatabaseData.DATABASE_DRIVER);
			con=DriverManager.getConnection(DatabaseData.DATABAE_URL,DatabaseData.DATABASE_USER,DatabaseData.DATABASE_PASSWORD);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		return con;
	}
}
