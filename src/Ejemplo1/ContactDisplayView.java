package Ejemplo1;

/**
 *
 * @author Eder González
 * En este ejemplo se utilizan dos vistas. La primera, ContactDisplayView, muestra
 * la información del modelo actualizada pero no soporta un controlador, es un 
 * ejemplo de comportamiento "sólo ver"
 */

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class ContactDisplayView extends JPanel implements ContactView{

    private JTextArea display;
    
    public ContactDisplayView(){
        createGui();
    }
    
    public void createGui(){
        setLayout(new BorderLayout());
        display = new JTextArea(10, 40);
        display.setEditable(false); 
        JScrollPane scrollDisplay = new JScrollPane(display);
        this.add(scrollDisplay, BorderLayout.CENTER);
    }
    
    @Override
    public void refreshContactView(String firstName, String lastName, String title, String organization) {
        display.setText("UPDATED CONTACT:\nNEW VALUES:\n" +
                "\tName: " + firstName + " " + lastName + 
                "\n" + "\tTitle: " + title + "\n" + 
                "\tOrganization: " + organization);
    }
}
