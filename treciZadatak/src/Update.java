import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/grad";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
		
		String sqlupdate="UPDATE spisakbiblioteka SET imeBiblioteke=?,ulica=?,broj=? WHERE bibliotekaID=?";
		
		
		PreparedStatement ps= conn.prepareStatement(sqlupdate);
		
		ps.setString(1, "Narodna biblioteka new");
		ps.setString(2, "Skerliceva new");
		ps.setInt(3, 2);
		
		ps.setInt(4, 1);
		
		int promenjenPodatak = ps.executeUpdate();
		
		if(promenjenPodatak>0)
			System.out.println("Uspesno je izvrsena izmena.");
		
		
		
		} catch (SQLException e) {
		e.printStackTrace();
	}

}}
