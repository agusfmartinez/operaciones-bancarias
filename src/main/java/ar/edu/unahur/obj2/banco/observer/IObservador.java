package ar.edu.unahur.obj2.banco.observer;

import ar.edu.unahur.obj2.banco.Cuenta;

public interface IObservador {
    void notificar(Cuenta cuenta, String operacion, Double monto);
}
