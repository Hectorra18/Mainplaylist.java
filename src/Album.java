import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String nombre;
    private String artista;

    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    public Cancion findSong(String titulo) {

        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion) {

        if (findSong(titulo) != null) {
            return false;
        } else {
            canciones.add(new Cancion(titulo,duracion));
            return true;
        }
    }

    public boolean addToPlayList(int numero, LinkedList<Cancion> lista) {

        if (numero >= 1 && numero <= canciones.size()) {
            lista.add(canciones.get(numero - 1));
            return true;
        } else {

            return false;
        }

    }


    public boolean addToPlayList(String titulo, LinkedList<Cancion> lista) {

        Cancion cancion = findSong(titulo);
        if (cancion != null) {
            lista.add(cancion);
            return true;
        } else {
            return false;
        }

    }

}


