package View.Dialogs;
import javax.swing.JOptionPane;

/***
 * Develop by joseline
 * 
 * Clase para enviar mensajes de realizado satisfactoriamente Y error
 * 
 * **/

public abstract class Messages {

	
	public static void showMessage(String msg){
		 JOptionPane.showMessageDialog(null, msg,"Realizado satisfactoriamente",JOptionPane.NO_OPTION); 
		}
	
	public static void showAlert(String msg){
		 JOptionPane.showMessageDialog(null, msg,"",JOptionPane.NO_OPTION); 
		}
	public static void showError(String msg){
		
		msg="ERROR"+msg+"\n Intentalo de nuevo.";
		 JOptionPane.showMessageDialog(null, msg,"ERROR",JOptionPane.OK_OPTION); 
	}
	
	
}
