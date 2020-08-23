package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel implements ActionListener{
	
	// Declarar en el Panel los Atributos de Tipo JLabel
	// Etiquetas y zonas de Texto
	private JButton btnRetroceder;
	private JButton butOpcion1;	
	private JButton butOpcion2;	
	private JButton btnAvanzar;
	
	// Declarar constantes para los nombres de los Eventos
	private static final String AVANZAR = "AVANZAR";
	private static final String RETROCEDER = "RETROCEDER";
	private static final String OPCION_1 = "opcion1";
	private static final String OPCION_2 = "opcion2";
		
	// Incluir una Asociación a la Ventana Principal
	private InterfazSistemaPacientes principal;
	
	public PanelExtensiones(InterfazSistemaPacientes v) {
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de Extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		// Atributo llamado "principal" almacenamos la ref a la Ventana Principal
		principal = v;
		
		// Crear Objetos y se Asocia a la constante respectiva 
		btnRetroceder = new JButton("<");
		btnRetroceder.setActionCommand(RETROCEDER);
		butOpcion1 = new JButton("Opción 1");
		butOpcion1.setActionCommand(OPCION_1);
		butOpcion2 = new JButton("Opción 2");
		butOpcion2.setActionCommand(OPCION_2);
		btnAvanzar = new JButton(">");
		btnAvanzar.setActionCommand(AVANZAR);
		
		/**
		 * Llamado al método addActionListener sobre los botones
		 * para indicar que el panel es el encargado de atender el
		 * evento que se genere cuando se presiona el botón
		 * Note que this en este caso es el panel mismo
		 */
		btnRetroceder.addActionListener(this);
		butOpcion1.addActionListener(this);
		butOpcion2.addActionListener(this);
		btnAvanzar.addActionListener(this);
		
		// Agregar las Etiquetas al Panel(add)
		add(btnRetroceder);
		add(butOpcion1);
		add(butOpcion2);
		add(btnAvanzar);			
	}
	
	public void actionPerformed(ActionEvent evento) {		
		String comando = evento.getActionCommand();
		if(comando.contentEquals(RETROCEDER)) {
			principal.retroceder();		
		}else if(comando.equals(OPCION_1)) {
			principal.reqFuncOpcion1();
		}else if(comando.equals(OPCION_2)) {
			principal.reqFuncOpcion2();
		}else if(comando.equals(AVANZAR)){
			principal.avanzar();
		}
	}
	
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
