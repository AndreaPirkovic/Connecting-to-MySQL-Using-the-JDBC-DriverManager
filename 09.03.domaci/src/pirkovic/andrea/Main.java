package pirkovic.andrea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args)  {
		
		String url = "jdbc:mysql://localhost:3306/tb";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
			 try {
			
		Connection conn = DriverManager.getConnection(
					    url, username, password);
				
				
			System.out.println("Uspesna konekcija ka bazi.");
			String sqlinsert ="Insert into korisnici(korisnickoIme,lozinka,ime,email)values(?,?,?,?)";
			PreparedStatement ps;
			try {
		ps = conn.prepareStatement(sqlinsert);
				
		ps.setString(1,"ABC");
		ps.setString(2,"pass123");
		ps.setString(3,"Abc");
		ps.setString(4,"abc@gmail.com");
		
		int unetPodatak= ps.executeUpdate(); // metoda executeUpdate upisuje podatke
		
	// ako se izvrsio executeUpdate ispitujemo:
		
		if(unetPodatak>0)
		
		System.out.println("Podatak je upisan.");	
		
		
			
		
		//upit unutar promenljive
		String sqlselect = "SELECT * from korisnici";
	//kreiranje objekta za komunikaciju sa bazom
		Statement stmt=conn.createStatement();
	ResultSet result= stmt.executeQuery(sqlselect);// izvrsavanje(namena) nad bazom
	while(result.next()) { //prolazak kroz skup podataka iz baze dokle god ima sledeci u bazi
		String ki = result.getString(2);
		String lo= result.getString(3);
		String ime = result.getString(4);
		String email= result.getString(5);
		
		StringBuilder builder = new StringBuilder();
		builder.append("Korisnicko ime: ");
		builder.append(ki);
		builder.append("\nLozinka: ");
		builder.append(lo);
		builder.append("\nIme: ");
		builder.append(ime);
		builder.append("\nemail: ");
		builder.append(email);
		
		System.out.println(builder.toString());
	System.out.println("Upit je izvrsen.");	
		
		String sqlupdate="UPDATE korisnici SET lozinka=?,ime=?,email=? WHERE korisnickoIme=?";
		// jedna kolona se koristi za uslov (ovde je to korisnickoIme)
		
		ps = conn.prepareStatement(sqlupdate);
			
		
		ps.setString(1, "123korisnik");
		ps.setString(2, "Neko");
		ps.setString(3, "neko@gmail.com");
		
		ps.setString(4, "korisnik1");// uslov iz 4og upitnika,koji se koristi kao uslov se ne menja!
		
		int promenjenPodatak = ps.executeUpdate();
		
		if(promenjenPodatak>0)
			System.out.println("Uspesno je izvrsena izmena.");
		
			
	
	}
	
} catch (SQLException e) {
			
			e.printStackTrace();
		}
			 } catch (SQLException e) {
					
					e.printStackTrace();
				}
			 
	}

}
