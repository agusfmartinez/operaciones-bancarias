package ar.edu.unahur.obj2.banco.observer;

import ar.edu.unahur.obj2.banco.Cuenta;

public class NotificacionCliente implements IObservador{

    @Override
    public void notificar(Cuenta cuenta, String operacion, Double monto) {
        
        if("DEPOSITO".equals(operacion)){
            System.out.println("Se acreditaron $" + monto);
        }

        if("RETIRO".equals(operacion)){
            System.out.println("Se debitaron $" + monto);
        }
        
    }

}
