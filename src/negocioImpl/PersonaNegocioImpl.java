package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado = false;
		if(persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado = pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona) {
		boolean estado = false;
		if(persona.getDni()>0)
		{
			estado = pdao.delete(persona);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		
		return pdao.readAll();
	}



}
