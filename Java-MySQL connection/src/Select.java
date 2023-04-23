import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Select {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/tb";
		String username="root";
		String password = "";
		//konekcija ka bazi
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
		
			//upit unutar promenljive
			String sqlselect = "SELECT * from korisnici";
		//kreiranje objekta za komunikaciju sa bazom
			java.sql.Statement stmt=conn.createStatement();
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
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
