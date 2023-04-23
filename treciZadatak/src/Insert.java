import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/grad";
		String username="root";
		String password = "";
		System.out.println("Konekcija....");
		try (Connection conn= DriverManager.getConnection(url,username,password)){
			
			System.out.println("Uspesna konekcija ka bazi.");
		String sqlinsert ="Insert into spisakbiblioteka(bibliotekaID,imeBiblioteke,ulica,broj)values(?,?,?,?)";
		
		PreparedStatement  ps= conn.prepareStatement(sqlinsert);
		
		ps.setInt(1,1);
		ps.setString(2,"Narodna biblioteka");
		ps.setString(3,"Skerliceva");
		ps.setInt(4,1);
		 
		
		
		
		ps.setInt(1,2);
		ps.setString(2,"Gradska biblioteka");
		ps.setString(3,"Kneza Mihaila");
		ps.setInt(4,56);
		 
		
		int unetPodatak= ps.executeUpdate(); 
		
		if(unetPodatak>0)
		
		System.out.println("Podatak je upisan.");	
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}}


