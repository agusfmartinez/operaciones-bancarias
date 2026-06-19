package ar.edu.unahur.obj2.banco;

import ar.edu.unahur.obj2.banco.comandos.DepositarCommand;
import ar.edu.unahur.obj2.banco.comandos.IComando;
import ar.edu.unahur.obj2.banco.comandos.Invoker;
import ar.edu.unahur.obj2.banco.comandos.RetirarCommand;
import ar.edu.unahur.obj2.banco.observer.Auditoria;
import ar.edu.unahur.obj2.banco.observer.NotificacionCliente;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1234, 10000.00);

        cuenta.agregarObservador(new Auditoria());
        cuenta.agregarObservador(new NotificacionCliente());

        // Ejecucion individual
        // Depositar $70000
        // Retirar $5000
        // Retirar $16000
        // Depositar $9000
        System.out.println("Ejecucion individual");
        IComando depo1 = new DepositarCommand(cuenta, 7000.00);
        IComando reti1 = new RetirarCommand(cuenta, 5000.00);
        IComando reti2 = new RetirarCommand(cuenta, 16000.00);
        IComando depo2 = new DepositarCommand(cuenta, 9000.00);
        Invoker invoker = new Invoker();

        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        invoker.ejecutar(depo1);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        invoker.ejecutar(reti1);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        invoker.ejecutar(reti2);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());

        invoker.ejecutar(depo2);
        System.out.println("[SALDO] -> " + cuenta.getSaldo());


        // Ejecucion por lote
        // Retirar $5000
        // Depositar $300000
        // Retirar $50000
        System.out.println("Ejecucion por lote");
        IComando reti3 = new RetirarCommand(cuenta, 5000.00);
        IComando depo3 = new DepositarCommand(cuenta, 30000.00);
        IComando reti4 = new RetirarCommand(cuenta, 50000.00);

        invoker.cargarComando(reti3);
        invoker.cargarComando(depo3);
        invoker.cargarComando(reti4);

        invoker.ejecutarLote();
        System.out.println("[SALDO] -> " + cuenta.getSaldo());
    }
}
