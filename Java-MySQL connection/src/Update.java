import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/tb";
		String username="root";
		String password = "";
		
		System.out.println("Konekcija....");
		
		try (Connection conn= DriverManager.getConnection(url,username,password)){
	
			System.out.println("Uspesna konekcija ka bazi!");
		
		String sqlupdate="UPDATE korisnici SET lozinka=?,ime=?,email=? WHERE korisnickoIme=?";
		// jedna kolona se koristi za uslov (ovde je to korisnickoIme)
		
		PreparedStatement ps= conn.prepareStatement(sqlupdate);
		
		ps.setString(1, "123korisnik");
		ps.setString(2, "Neko");
		ps.setString(3, "neko@gmail.com");
		
		ps.setString(4, "korisnik1");// uslov iz 4og upitnika,koji se koristi kao uslov se ne menja!
		
		int promenjenPodatak = ps.executeUpdate();
		
		if(promenjenPodatak>0)
			System.out.println("Uspesno je izvrsena izmena.");
		
		
		
		} catch (SQLException e) {
		e.printStackTrace();
	}

}}
