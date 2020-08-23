package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class PanelDatosMuestra extends JPanel implements ActionListener{
	
	// Declarar en el Panel los Atributos de Tipo JLabel
	// Etiquetas y zonas de Texto
	private JLabel labFTomaMuestra;
	private JTextField txtFTomaMuestra;
	
	private JLabel labVolumenMuestra;
	private JTextField txtVolumenMuestra;
	
	private JLabel labVolumenEritrocitos;
	private JTextField txtVolumenEritrocitos;
	
	private JLabel labConteoLeucocitos;
	private JTextField txtConteoLeucocitos;
	
	private JLabel labConteoPlaquetas;
	private JTextField txtConteoPlaquetas;
	
	private JButton butHematocrito;
	private JTextField txtHematocrito;
	
	private JButton butLeucocitos;
	private JTextField txtLeucocitos;
	
	private JCheckBox cbAyunas;
	
	// Declarar constantes para los nombres de los Eventos
	private final static String AYUNAS = "En ayunas";
	private final static String CALCULAR_HEMATOCRITO = "CALCULAR HEMATOCRITO";
	private final static String CALCULAR_LEUCOCITOS = "CALCULAR LEUCOCITOS";
	
	// Incluir una Asociación a la Ventana Principal
	private InterfazSistemaPacientes principal;
	
	public PanelDatosMuestra(InterfazSistemaPacientes v) {
		setLayout(new GridLayout(6, 4, 10, 10));
		TitledBorder border = BorderFactory.createTitledBorder("Información de la Muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		// Atributo llamado "principal" almacenamos la ref a la Ventana Principal
		principal = v;
		
		// Crear las Etiquetas(new) en el Método Constructor del Panel
		labFTomaMuestra = new JLabel("Fecha Toma de Muestra");
		labVolumenMuestra = new JLabel("Volumen de Muestra");
		labVolumenEritrocitos = new JLabel("Volumen de Eritrocitos");
		labConteoLeucocitos = new JLabel("Conteo de Leucocitos");
		labConteoPlaquetas = new JLabel("Conteo de Plaquetas");
				
		txtFTomaMuestra = new JTextField(15);
		txtVolumenMuestra = new JTextField(7);
		txtVolumenEritrocitos = new JTextField(7);
		txtConteoLeucocitos = new JTextField(7);
		txtConteoPlaquetas = new JTextField(7);
		txtHematocrito = new JTextField(7);
		txtLeucocitos = new JTextField(7);
		
		// Crear Objetos y se Asocia a la constante respectiva 
		butHematocrito = new JButton("Calcular Hematocrito");
		butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);
		butLeucocitos = new JButton("Calcular Leucocitos");
		butLeucocitos.setActionCommand(CALCULAR_LEUCOCITOS);
		cbAyunas = new JCheckBox("En ayunas");
		cbAyunas.setActionCommand(AYUNAS);
				
		/**
		 * Llamado al método addActionListener sobre los botones
		 * para indicar que el panel es el encargado de atender el
		 * evento que se genere cuando se presiona el botón
		 * Note que this en este caso es el panel mismo
		 */
		butHematocrito.addActionListener(this);
		butLeucocitos.addActionListener(this);
		cbAyunas.addActionListener(this);
		
		// Agregar las Etiquetas al Panel(add)
		add(labFTomaMuestra);
		add(txtFTomaMuestra);
		add(new JLabel(""));
		add(cbAyunas);
		
		add(labVolumenMuestra);
		add(txtVolumenMuestra);
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(labVolumenEritrocitos);
		add(txtVolumenEritrocitos);
		add(butHematocrito);
		add(txtHematocrito);
		
		add(labConteoLeucocitos);
		add(txtConteoLeucocitos);
		add(butLeucocitos);
		add(txtLeucocitos);
		
		add(labConteoPlaquetas);
		add(txtConteoPlaquetas);
		add(new JLabel(""));
		add(new JLabel(""));
		
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
		add(new JLabel(""));
	}
	
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.contentEquals(CALCULAR_LEUCOCITOS)) {
			// Reacción al evento de calcular leucocitos
			principal.calcularLeucocitos();
		}else if(comando.equals(CALCULAR_HEMATOCRITO)) {
			// Reacción al evento de calcular leucocitos
			principal.calcularHematocrito();
		}else if(comando.equals(AYUNAS)) {
			// Reacción al evento AYUNAS
			principal.cambiarEnAyunas();
		}
	}
	
	/**
	 * Método que muestra el valor de hematocrito
	 * recibido por parámetro en el campo de texto 
	 * txtHematocrito
	 * @param pHematocrito
	 */
	public void mostrarHematocrito(String pHematocrito) {
		txtHematocrito.setText(pHematocrito);
	}
	
	/**
	 * Método que muestra el valor de leucocito
	 * recibido por parámetro en el campo de texto 
	 * txtLeucocito
	 * @param pLeucocito
	 */
	public void mostrarLeucocito(String pLeucocito) {
		txtLeucocitos.setText(pLeucocito);
	}
	
	/**
	 * Método que muestra el valor de "en ayunas"
	 * de acuerdo al recibido por parámetro 
	 * en la caja de chequeo cbAyunas
	 * @param enAyunas Indica true o false si la muestra es en ayunas o no
	 */
	public void mostrarAyunas(boolean pEnAyunas) {
		cbAyunas.setSelected(pEnAyunas);
	}
	
	public String darVolumenMuestra() {
		String rta = txtVolumenMuestra.getText(); 
		return rta;
	}
	
	public String darVolumenEritrocitos() {
		String rta = txtVolumenEritrocitos.getText(); 
		return rta;
	}
	
	public String darConteoLeucocitos() {
		String rta = txtConteoLeucocitos.getText(); 
		return rta;
	}
	
	public String darConteoPlaquetas() {
		String rta = txtConteoPlaquetas.getText(); 
		return rta;
	}
	
	public boolean estaEnAyunas() {
		return cbAyunas.isSelected();
	}
	
	public void limpiarCampos() {
		txtHematocrito.setText("");
		txtLeucocitos.setText("");
	}
	
	/**
	 * Actualiza los campos del panel con la información que entra como parámetro
	 */
	public void actualizarCampos(String pFechaMuestra, boolean pEnAyunas,
			double pVolumenMuestra, double pVolumenEritrocitos,
			int pConteoLeucocitos, int pConteoPlaquetas) {
			
			txtFTomaMuestra.setText(pFechaMuestra);
			txtVolumenMuestra.setText(pVolumenMuestra + "");
			txtVolumenEritrocitos.setText(pVolumenEritrocitos + "");
			txtConteoLeucocitos.setText(pConteoLeucocitos + "");
			txtConteoPlaquetas.setText(pConteoPlaquetas + "");
			cbAyunas.setSelected(pEnAyunas);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
