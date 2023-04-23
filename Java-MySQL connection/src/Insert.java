import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/tb";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
		String sqlinsert ="Insert into korisnici(korisnickoIme,lozinka,ime,email)values(?,?,?,?)";
		//upit koji vrsi dodavanje podataka unutar tabele
		//stavljamo upitnike umesto konkretnih vrednosti
		//tamo gde ce se naknadno upisivati vrednosti
		PreparedStatement  ps= conn.prepareStatement(sqlinsert);
		//za razliku od objekta Statement klase koji nema parametar,
		//preparedStatement ima parametar koji prosledjuje bazi
		//upis podataka:
		ps.setString(1,"ABC");
		ps.setString(2,"pass123");
		ps.setString(3,"Abc");
		ps.setString(4,"abc@gmail.com");
		
		int unetPodatak= ps.executeUpdate(); // metoda executeUpdate upisuje podatke
		
	// ako se izvrsio executeUpdate ispitujemo:
		
		if(unetPodatak>0)
		
		System.out.println("Podatak je upisan.");	
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}}


