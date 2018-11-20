package Modelo;

public class Motor {
    private int id;
    private String combustible;
    private String potencia;

    public Motor(String combustible, String potencia) {
        this.id = 0;
        this.combustible = combustible;
        this.potencia = potencia;
    }

    public Motor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", combustible='" + combustible + '\'' +
                ", potencia='" + potencia + '\'' +
                '}';
    }
}