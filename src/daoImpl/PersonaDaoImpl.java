package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {

	private static final String insert = "INSERT INTO Personas(Dni, Nombre, Apellido) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM Personas WHERE Dni = ?";
	private static final String readall = "SELECT * FROM Personas";
	
	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate()>0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}


	public boolean delete(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona.getDni()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleteExitoso;
	}


	public List<Persona> readAll() {

		PreparedStatement statement;
		ResultSet resultset;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			while (resultset.next()) {
			
			personas.add(getPersona(resultset));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return personas;
	}


	private Persona getPersona(ResultSet resultset) throws SQLException{
		int Dni =  resultset.getInt("Dni");
		String Nombre = resultset.getString("Nombre");
		String Apellido = resultset.getString("Apellido");
		return new Persona(Dni,Nombre,Apellido);
	}





}
