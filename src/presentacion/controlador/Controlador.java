package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.PanelListarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnIngresoPersona;
	private PanelListarPersona pnListarPersona;
	private PersonaNegocio pneg;
	private ArrayList<Persona> personaEnTabla;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pneg)
	{
		this.ventanaPrincipal = vista;
		this.pneg = pneg;
		
		///INSTANCIAR PANELES
		this.pnIngresoPersona = new PanelAgregarPersona();
		
		///Menu Frame
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->AbrirPanelAgregar(a));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->AbrirPanelListar(a));
		
	}
	

	private void AbrirPanelListar(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnListarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}


	public void AbrirPanelAgregar(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnIngresoPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
