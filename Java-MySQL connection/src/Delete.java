import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/tb";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
			
			String sqldelete=  "DELETE FROM korisnici WHERE korisnickoIme = ?";
			PreparedStatement ps= conn.prepareStatement(sqldelete);
			ps.setString(1, "ABC");
			int obrisanpodatak=ps.executeUpdate();
	
		if(obrisanpodatak>0)
			System.out.println("Podatak je uspesno obrisan.");
		} catch (SQLException e) {
		
		e.printStackTrace();
	}

}}
