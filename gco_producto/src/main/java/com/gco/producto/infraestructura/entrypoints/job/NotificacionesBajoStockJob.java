package com.gco.producto.infraestructura.entrypoints.job;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import  com.gco.producto.infraestructura.entrypoints.observador.*;

@Component
public class NotificacionesBajoStockJob {

    /**
     * Tarea programada para calcular el bajo stock de un producto
     */

    /**
     * este metodo ejecuta un observador para notificar bajo stock a sus observadores puede tener
     * los observadores que desee en este caso solo hay un observador
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void verificarBajoStock(){

        SujetoImp sujetoImp =new   SujetoImp();
        ObservadorBajoStock observadorBajoStock=new ObservadorBajoStock();

        //Implemente los observadores que desee que escuchen bajo stock.
        sujetoImp.Attach(observadorBajoStock);

        //Se genera la notificacion de bajo stock a los observadores
        sujetoImp.NotificarStockBajo();
    }
}
