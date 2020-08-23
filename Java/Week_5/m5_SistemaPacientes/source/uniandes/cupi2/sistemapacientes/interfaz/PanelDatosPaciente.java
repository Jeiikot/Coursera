package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelDatosPaciente extends JPanel implements ActionListener{
	
	// Declarar en el Panel los Atributos de Tipo JLabel
	// Etiquetas y zonas de Texto
	private JLabel labNombre;
	private JTextField txtNombre;
	
	private JLabel labApellido;
	private JTextField txtApellido;
	
	private JLabel labFNacimiento;
	private JTextField txtFNacimiento;
	
	private JLabel labSexo;
	private JTextField txtSexo;
		
	private JButton butEdad;
	private JTextField txtEdad;
	
	private JLabel labImagen;

	// Declarar constantes para los nombres de los Eventos
	private final static String CALCULAR_EDAD = "CALCULAR EDAD";
	
	// Incluir una Asociación a la Ventana Principal
	private InterfazSistemaPacientes principal;
	
	public PanelDatosPaciente(InterfazSistemaPacientes v) {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Datos del Paciente");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		// Atributo llamado "principal" almacenamos la ref a la Ventana Principal
		principal = v;
		
		// Panel donde se muestra la foto del paciente
		JPanel panelFoto;
		panelFoto = new JPanel();
		add(panelFoto, BorderLayout.EAST);
		
		// Panel donde se muestra la información del paciente
		JPanel panelInformacion;				
		panelInformacion = new JPanel();
		add(panelInformacion, BorderLayout.CENTER);
		
				
		// Crear las Etiquetas(new) en el Método Constructor del Panel
		labNombre = new JLabel("Nombre");
		labApellido = new JLabel("Apellido");
		labFNacimiento = new JLabel("Fecha de Nacimiento");
		labSexo = new JLabel("Sexo");
		
		txtNombre = new JTextField(15);
		txtApellido = new JTextField(15);
		txtFNacimiento = new JTextField(10);
		txtSexo = new JTextField(2);
		
		// Crear Objetos y se Asocia a la constante respectiva 
		butEdad = new JButton("Calcular Edad");
		butEdad.setActionCommand(CALCULAR_EDAD);
		txtEdad = new JTextField(10);
		
		/**
		 * Llamado al método addActionListener sobre los botones
		 * para indicar que el panel es el encargado de atender el
		 * evento que se genere cuando se presiona el botón
		 * Note que this en este caso es el panel mismo
		 */
		butEdad.addActionListener(this);
				
		// Configurar las Características de las Etiquetas con los
		// Métodos de las clases JLabel
		labNombre.setForeground(Color.BLACK);
		labApellido.setForeground(Color.BLACK);
		labFNacimiento.setForeground(Color.BLACK);
		labSexo.setForeground(Color.BLACK);
		
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.LIGHT_GRAY);
		txtNombre.setForeground(Color.BLUE);
		
		txtApellido.setEditable(false);
		txtApellido.setBackground(Color.LIGHT_GRAY);
		txtApellido.setForeground(Color.BLUE);
		
		txtFNacimiento.setEditable(false);
		txtFNacimiento.setBackground(Color.LIGHT_GRAY);
		txtFNacimiento.setForeground(Color.BLUE);
		
		txtSexo.setEditable(false);
		txtSexo.setBackground(Color.LIGHT_GRAY);
		txtSexo.setForeground(Color.BLUE);
		
		txtEdad.setEditable(false);
					
		// Agregar las Etiquetas al Panel de informacion(add)
		panelInformacion.setLayout(new GridLayout(6,2));
		panelInformacion.add(labNombre);
		panelInformacion.add(txtNombre);
		panelInformacion.add(labApellido);
		panelInformacion.add(txtApellido);
		panelInformacion.add(labFNacimiento);
		panelInformacion.add(txtFNacimiento);
		panelInformacion.add(labSexo);
		panelInformacion.add(txtSexo);
		panelInformacion.add(butEdad);
		panelInformacion.add(txtEdad);
		
		// Agregar las Etiquetas al Panel de foto del paciente(add)		
		labImagen = new JLabel("Foto");
		panelFoto.add(labImagen);	
	}
	
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(CALCULAR_EDAD)) {
			principal.calcularEdad();
		}
	}
	
	public void mostrarEdad(String pEdad) {
		txtEdad.setText(pEdad);
	}
	
	public String darEdad() {
		String rta = txtEdad.getText(); 
		return rta;
	}
	
	public void limpiarCampos() {
		txtEdad.setText("");
	}
	
	/**
	 * Actualiza los campos del panel con la información que entra como parámetro
	 */
	public void actualizarCampos(String pNombre, String pApellido,			
			String pSexo, String pFechaN, String pImagen) {
			
			txtNombre.setText(pNombre);
			txtApellido.setText(pApellido);
			txtSexo.setText(pSexo);
			txtFNacimiento.setText(pFechaN);
			labImagen.setIcon(new ImageIcon(pImagen));
			txtEdad.setText("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
