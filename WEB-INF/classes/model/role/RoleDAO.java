package model.role;

import database.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
	public List<Role> getRole(){
		String sql = "SELECT * FROM role";
		List<Role> roles = new ArrayList<>();
		
		try(
			Connection conn = DBConnexion.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql);
			ResultSet rs = stm.executeQuery()){
				
			while (rs.next()){
				Role role = new Role();
				role.setId(rs.getInt("Id_role"));
				role.setNom(rs.getString("nom"));
				roles.add(role);
			}	
				
			}catch (Exception e) {
            e.printStackTrace();
        }
		return roles;
	}
}