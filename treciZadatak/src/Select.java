import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Select {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/grad";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
			//upit unutar promenljive
			String sqlselect = "SELECT * from spisakbiblioteka";
		//kreiranje objekta za komunikaciju sa bazom
			java.sql.Statement stmt=conn.createStatement();
		ResultSet result= stmt.executeQuery(sqlselect);// izvrsavanje(namena) nad bazom
		while(result.next()) { //prolazak kroz skup podataka iz baze dokle god ima sledeci u bazi
			Integer bibliotekaID = result.getInt(1);
			String imeBiblioteke= result.getString(2);
			String ulica = result.getString(3);
			Integer broj= result.getInt(4);
			
			StringBuilder builder = new StringBuilder();
			builder.append("ID: ");
			builder.append(bibliotekaID);
			builder.append("\nIme: ");
			builder.append(imeBiblioteke);
			builder.append("\nulica: ");
			builder.append(ulica);
			builder.append("\nbroj: ");
			builder.append(broj);
			
			System.out.println(builder.toString());
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
