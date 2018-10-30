package Modelo;

public class Motor {
    private String combustible;
    private String potencia;

    public Motor(String combustible, String potencia) {
        this.combustible = combustible;
        this.potencia = potencia;
    }

    public Motor() {
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
                "combustible='" + combustible + '\'' +
                ", potencia='" + potencia + '\'' +
                '}';
    }
}