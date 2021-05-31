package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelAgregarPersona extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	JLabel lblNombre;
	JLabel lblApellido;
	JLabel lblDni;
	JButton btnAceptar;


	public PanelAgregarPersona() {
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(103, 53, 46, 14);
		add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(103, 94, 46, 14);
		add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(103, 135, 46, 14);
		add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c<'a' || c>'z' )&&(c<'A') | c>'Z') e.consume();
			}
		});
		txtNombre.setBounds(178, 50, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c<'a' || c>'z' )&&(c<'A') | c>'Z') e.consume();
			}
		});
		txtApellido.setBounds(178, 91, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(c<'0' || c>'9') e.consume();
			}
		});
		txtDni.setBounds(178, 132, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonaNegocioImpl pn = new PersonaNegocioImpl();
				
				if(((txtDni.getText().isEmpty()) || (txtNombre.getText().isEmpty()) || (txtApellido.getText().isEmpty())) !=true)
				{
					
					Persona per = new Persona(Integer.parseInt(txtDni.getText()), txtNombre.getText(), txtApellido.getText());
					boolean v = pn.insert(per);
					if(v) {
						JOptionPane.showMessageDialog(null, "Agregado");
					}
					else {
						JOptionPane.showMessageDialog(null, "No se pudo agregar");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Completar campos");
				}
			}

			
		});
		btnAceptar.setBounds(178, 217, 89, 23);
		add(btnAceptar);

	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JTextField getTxtApellido() {
		return txtApellido;
	}


	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}


	public JTextField getTxtDni() {
		return txtDni;
	}


	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}


	public JLabel getLblNombre() {
		return lblNombre;
	}


	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}


	public JLabel getLblApellido() {
		return lblApellido;
	}


	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}


	public JLabel getLblDni() {
		return lblDni;
	}


	public void setLblDni(JLabel lblDni) {
		this.lblDni = lblDni;
	}


	public JButton getBtnAceptar() {
		return btnAceptar;
	}


	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}


		
	
}
