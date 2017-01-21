package Ejemplo1;

/**
 *
 * @author Eder González
 * La clase ContactModel contiene un ArrayList de objetos ContactView,
 * actualizándolos cuando cambia el modelo. El comportamiento estándar para todas las
 * vistas se define en el método refreshContactView de la interfaz ContactView
 */

public interface ContactView {
    
    public void refreshContactView(String firstName, String lastName, String title, String organization);
}
