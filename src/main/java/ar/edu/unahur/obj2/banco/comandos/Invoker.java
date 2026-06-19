package ar.edu.unahur.obj2.banco.comandos;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<IComando> lote = new ArrayList<>();
    private IComando ultimoComando;

    public void ejecutar(IComando comando){
        comando.ejecutar();
        ultimoComando = comando;
    }

    public void ejecutarLote(){
        lote.forEach(IComando::ejecutar);
        lote.clear();
    }

    public void cargarComando(IComando comando){
        lote.add(comando);
    }

    public void deshacer(){
        if (ultimoComando != null){
            ultimoComando.deshacer();
            ultimoComando = null;
        }
    }
}
