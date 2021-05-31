package presentacion.vista;

import java.util.List;


import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JScrollPane;

public class PanelListarPersona extends JPanel {
	
	private String [] datos = {"DNI","Nombre","Apellido"};
	private JTable table_1;
    DefaultTableModel modelP = new DefaultTableModel(null,datos);

	public PanelListarPersona() {
		setLayout(null);
		
		modelP = new DefaultTableModel(null,datos);
		
		table_1 = new JTable(modelP);
		table_1.setBounds(10, 11, 380, 253);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(33, 39, 380, 250);
		add(spPersonas);
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(2).setResizable(false);

		
		
		spPersonas.setViewportView(table_1);

	}
	
	public void cargarTabla(List<Persona> cargar)
	{
		modelP.setRowCount(0); 
		modelP.setColumnCount(0);
		modelP.setColumnIdentifiers(datos);

		for (Persona p : cargar)
		{
			int Dni = p.getDni();
			String Nombre = p.getNombre();
			String Apellido = p.getApellido();
			Object[] fila = {Dni, Nombre, Apellido};
			modelP.addRow(fila);
		}
	}



}
