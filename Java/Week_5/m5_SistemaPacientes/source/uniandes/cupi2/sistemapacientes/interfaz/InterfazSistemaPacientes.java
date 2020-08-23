package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.*;
import javax.swing.*;

import uniandes.cupi2.sistemapacientes.mundo.*;

public class InterfazSistemaPacientes extends JFrame {
	
	private PanelDatosPaciente panelDatosPaciente;
	private PanelDatosMuestra panelDatosMuestra;
	private PanelExtensiones panelExtensiones;
	
	// Definir Atributo para guardar Asociación con la Clase Princupla del Mundo
	private SistemaPacientes sistemaPacientes;
	
	
	public InterfazSistemaPacientes() {
		
		setTitle("Sistema de Pacientes");
		setSize(700, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		// Crear Objecto de la Clase Principal del Mundo
		sistemaPacientes = new SistemaPacientes();
		
		// Crear Objectos de las divisiones del Panel
		panelDatosPaciente = new PanelDatosPaciente(this);
		panelDatosMuestra = new PanelDatosMuestra(this);
		panelExtensiones = new PanelExtensiones(this);
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);

	}
	
	/**
	 * Actualiza la información del paciente dado por parámetro
	 * @param pPaciente Paciente del cual se mostrarón los datos.
	 */
	public void actualizarInfoPaciente(Paciente pPaciente) {
		String nombre = pPaciente.darNombre();
		String apellido = pPaciente.darApellido();
		
		String sexo = "F";
		int iSexo = pPaciente.darSexo();
		if (iSexo == 2)
			sexo = "M";
		
		String fechaTomaMuestra = pPaciente.darFechaTomaMuestra();
		String fechaN = pPaciente.darFechaNacimiento();
		String imagen = pPaciente.darImagen();
		double volumenMuestra = pPaciente.darVolumenMuestra();
		double volumenEritrocitos = pPaciente.darVolumenEritrocitos();
		int conteoLeucocitos = pPaciente.darConteoLeucocitos();
		int conteoPlaquetas = pPaciente.darConteoPlaquetas();
		boolean enAyuna = pPaciente.darEnAyunas();
		
		panelDatosPaciente.actualizarCampos(nombre, apellido, sexo, fechaN, imagen);
		panelDatosMuestra.actualizarCampos(fechaTomaMuestra, enAyuna, volumenMuestra, 
				volumenEritrocitos, conteoLeucocitos, conteoPlaquetas);
		panelDatosMuestra.limpiarCampos();				
	}
	
	
	/**
	 * Calcula y muestra el valor de hematorito del paciente
	 */
	public void calcularHematocrito() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		
		if ((pVolumenMuestra.trim().equals("")) || (pVolumenEritrocitos.trim().equals(""))) {
			JOptionPane.showMessageDialog(this,"Debe ingresar los datos.",
					"Calcular Hematocrito", JOptionPane.ERROR_MESSAGE);
		}else if((pVolumenMuestra.trim().matches("[0123456789.]*")) &&
				(pVolumenEritrocitos.trim().matches("[0123456789.]*"))) {
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			
			double hematocrito = sistemaPacientes.darPacienteActual().calcularHematocrito();
			hematocrito = Math.round((hematocrito * 100.0) / 100.0);
			panelDatosMuestra.mostrarHematocrito(" " +  hematocrito);
		}else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.",
					"Calcular Hematocrito", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Calcula y muestra el valor de Leucocitos del paciente
	 */
	public void calcularLeucocitos() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		String pConteoLeucocitos = panelDatosMuestra.darConteoLeucocitos();
		
		if ((pVolumenMuestra.trim().equals("")) || (pVolumenEritrocitos.trim().equals(""))
				|| (pConteoLeucocitos.trim().equals(""))) {
			JOptionPane.showMessageDialog(this,"Debe ingresar los datos.",
					"Calcular Leucocitos", JOptionPane.ERROR_MESSAGE);
		}else if((pVolumenMuestra.trim().matches("[0123456789.]*")) &&
				(pVolumenEritrocitos.trim().matches("[0123456789.]*")) &&
				(pConteoLeucocitos.trim().matches("[0123456789.]*"))) {
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			int conteoLeucocitos = Integer.parseInt(pConteoLeucocitos.trim());
			
			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			sistemaPacientes.darPacienteActual().cambiarConteoLeucocitos(conteoLeucocitos);
			
			double Leucocitos = sistemaPacientes.darPacienteActual().calcularLeucocitos();
			Leucocitos = Math.round((Leucocitos * 100.0) / 100.0);
			panelDatosMuestra.mostrarLeucocito(" " + Leucocitos);
		}else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.",
					"Calcular Hematocrito", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void calcularEdad(){		
		int pEdad = sistemaPacientes.darPacienteActual().darEdad();								
		panelDatosPaciente.mostrarEdad(" " + pEdad);
	
								
	}
	
	/**
	 * Muestra un mensaje indicando la muestra está en ayunas o no
	 * dependiendo de la selección o deselección que haya hecho el
	 * usuario en el panel de los datos de la muestra
	 */
	public void cambiarEnAyunas() {
		if (panelDatosMuestra.estaEnAyunas()) {
			JOptionPane.showMessageDialog(this, "En ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "No en ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	/**
	 * Avanza al siguiente paciente y actualiza la información de la interfaz
	 * @param pPaciente Paciente del cual se mostrarón los datos.
	 */
	public void avanzar() {
		Paciente actual = sistemaPacientes.darPacienteSiguiente();
		actualizarInfoPaciente(actual);
	}
	/**
	 * Metodo para la extensión 1
	 */
	public void reqFuncOpcion1() {
		String resultado = sistemaPacientes.metodo1();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Metodo para la extensión 2
	 */
	public void reqFuncOpcion2() {
		String resultado = sistemaPacientes.metodo2();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Retroceder al anterior paciente y actualiza la información de la interfaz
	 * @param pPaciente Paciente del cual se mostrarón los datos.
	 */
	public void retroceder() {
		Paciente actual = sistemaPacientes.darPacienteAnterior();
		actualizarInfoPaciente(actual);
	}
}
