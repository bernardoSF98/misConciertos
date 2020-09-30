package cl.inacap.misconciertos.dto;

public class Evento {
    //private
    private String nombreArtistTxt;
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombreArtistTxt() {
        return nombreArtistTxt;
    }

    public void setNombreArtistTxt(String nombreArtistTxt) {
        this.nombreArtistTxt = nombreArtistTxt;
    }
}
