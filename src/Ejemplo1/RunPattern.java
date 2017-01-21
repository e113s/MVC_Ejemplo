package Ejemplo1;

/**
 *
 * @author Eder González
 * La clase RunPattern ejecuta el ejemplo de este patrón, creando el modelo y las
 * interfaces gráficas para las dos vistas asociadas. La información de actualización
 * proporcionada por ContactEditView se refleja en ContactDisplayView, poniendo
 * en evidencia el hecho de que un único modelo puede proporcionar información
 * a múltiples objetos vista.
 */

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunPattern {
    
    public static void main(String[] args){
        
        ContactModel model = new ContactModel();
        ContactEditView editorView = new ContactEditView(model);
        model.addContactView(editorView);
        createGui(editorView, "Contact Edit Window");
        
        ContactDisplayView displayView = new ContactDisplayView();
        model.addContactView(displayView); 
        createGui(displayView, "Contact Display Window");
    }
    
    private static void createGui(JPanel contents, String title){
        JFrame applicationFrame = new JFrame(title);
        applicationFrame.getContentPane().add(contents);
        applicationFrame.addWindowListener(new WindowCloseManager());
        applicationFrame.pack();
        applicationFrame.setVisible(true);
        applicationFrame.setResizable(false); 
    }
    
    private static class WindowCloseManager extends WindowAdapter{
        public void windowClosing(WindowEvent evt){
            System.exit(0); 
        }
    }
}
