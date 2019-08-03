package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.Principal;
import modelo.Ventanas;

public class Navegadores implements ActionListener {

	private Principal princi;
	private Ventanas venta;

	public Navegadores(Principal princi) {
		this.princi = princi;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		venta = new Ventanas();
		Object source = evt.getSource();
		if (source == princi.getBtnAgregarIngre()) {
			venta.crearVentanaAgregarIngre(princi);
		} else if (source == princi.getBtnAgregarPlati()) {
			venta.crearVentanaAgregarPlati(princi);
		} else if (source == princi.getBtnAgregarRece()) {
			venta.crearVentanaAgregarRece(princi);
		} else if (source == princi.getBtnGestionarIngre()) {
			venta.crearVentanaGestionarIngre(princi);
		} else if (source == princi.getBtnGestionarPlat()) {
			venta.crearVentanaGestionarPlat(princi);
		} else if (source == princi.getBtnGestionarRece()) {
			venta.crearVentanaGestionarRece(princi);
		} else if (source == princi.getBtnReportes()) {
			venta.crearVentanaReporte(princi);
		}
		
	}

}
