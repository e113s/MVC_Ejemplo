package Ejemplo1;

/**
 *
 * @author Eder González
 * Es posible actualizar el modelo gracias al controlador asociado con ContactEditView
 * En este ejemplo, la gestion de eventos de Java (y por extensión el patrón Observer)
 * gestiona la comunicación entre ContactEditView y su controlador asociado.
 * ContactEditController actualiza ContactModel cuando el comportamiento de 
 * actualización es desencadenado por ContactEditView, llamando al método
 * updateModel con nuevos datos proporcionados por los campos editables de las
 * vistas asociadas.
 */

import java.awt.event.*;

public class ContactEditController implements ActionListener{
    
    private ContactModel model;
    private ContactEditView view;
    
    public ContactEditController(ContactModel m, ContactEditView v){
        model = m;
        view = v;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if(source == view.getUpdateRef()){
            updateModel();
        }
    } 
    
    private void updateModel(){
        String firstName = null;
        String lastName = null;
        
        if(isAlphabetic(view.getFirstName())){
            firstName = view.getFirstName();
        }
        
        if(isAlphabetic(view.getLastName())){
            lastName = view.getLastName();
        }
        
        model.updateModel(firstName, lastName, view.getTitle(), view.getOrganization());
    }
    
    private boolean isAlphabetic(String input){
        char [] testChars = {'1','2','3','4','5','6','7','8','9','0'};
        
        for(int i = 0; i < testChars.length; i++){
            if(input.indexOf(testChars[i]) != -1){ 
                return false;
            }
        }
        
        return true;
    }
}
