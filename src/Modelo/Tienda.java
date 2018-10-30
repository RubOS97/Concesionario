package Modelo;

import java.util.ArrayList;

public class Tienda extends ArrayList<Coche> {

    public ArrayList<Coche> getTienda(){
        return this;
    }

    @Override
    public String toString() {
        String texto="";
        for (int i = 0; i < getTienda().size(); i++) {
            texto+=getTienda().get(i).toString()+"\n";
        }
        return texto;
    }
}
