import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        imprimirMenu();
        ArrayList<Album> album = new ArrayList<Album>();

        Album album1 = new Album("Global Warning", "Pitbull");
        Album album2 = new Album("Meteora", "Linkin Park");

        album1.addSong("Back in time", 3.27);
        album1.addSong("Drinks For You", 3.17);
        album1.addSong("Don't Stop the Party", 3.26);
        album1.addSong("Hope We Meet Again", 3.41);
        album1.addSong("Have Some Fun", 4.05);
        album1.addSong("Tchu Tchu Tcha", 3.26);
        album1.addSong("Las Night", 3.40);

        album2.addSong("Numb", 3.08);
        album2.addSong("Nobody's Listening", 2.59);
        album2.addSong("Don't Stay", 3.08);
        album2.addSong("Somewhere I Belong", 3.34);
        album2.addSong("Easier to Run", 3.24);
        album2.addSong("Breaking the Habit", 3.08);

        LinkedList<Cancion> playlist = new LinkedList<>();

        album1.addToPlayList("Back in time", playlist);
        album1.addToPlayList("Drinks For You", playlist);
        album1.addToPlayList("Have Some Fun", playlist);
        album2.addToPlayList(1, playlist);
        album2.addToPlayList(2, playlist);
        album2.addToPlayList(3, playlist);


        Play(playlist);


    }

    public static void Play(LinkedList<Cancion> playlist) {
        boolean haciaAdelante = true;
        ListIterator<Cancion> it = playlist.listIterator();
        int opcion;
        do {
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Hasta luego");
                    break;
                case 1:
                    if (!haciaAdelante) {
                        if (it.hasNext())
                            it.next();
                        haciaAdelante = true;
                    }
                    if (it.hasNext()) {
                        System.out.println("Escuchando cancion " + it.next().getTitulo());
                    } else {
                        System.out.println("Hemos llegado al final de la playlist");
                    }
                    break;
                case 2:
                    if(haciaAdelante) {
                        if (it.hasPrevious())
                            it.previous();
                        haciaAdelante = false;
                    }
                    if (it.hasPrevious()) {
                        System.out.println("Escuchando canción " + it.previous().getTitulo());
                    } else {
                        System.out.println("Hemos llegado al principio de la playlist");
                    }
                    break;
                case 3:
                    if (haciaAdelante) {
                        if (it.hasPrevious()) {
                            System.out.println("Repetición: " + it.previous().getTitulo());
                            it.next();
                        } else {
                            System.out.println("No hay canción anterior para repetir.");
                        }
                    } else {
                        if (it.hasNext()) {
                            System.out.println("Repetición " + it.next().getTitulo());
                            it.previous();
                        } else {
                            System.out.println("No hay canción siguiente para repetir.");
                        }
                    }
                    break;
                case 4:
                    imprimirPlaylist(playlist);
                    break;
                case 5:
                    imprimirMenu();
                    break;
                case 6:
                    if (playlist.isEmpty()) {
                        System.out.println("La playlist está vacía, no hay canciones para eliminar.");
                    } else {
                        if (haciaAdelante) {
                            if (it.hasPrevious()) {
                                System.out.println("Eliminando la canción actual: " + it.next().getTitulo());
                                it.remove();
                                if (it.hasNext()) {
                                    System.out.println("Reproduciendo la siguiente canción: " + it.next().getTitulo());
                                } else {
                                    it.previous();
                                    System.out.println("No hay siguiente canción. Reproduciendo la canción previa: " + it.previous().getTitulo());
                                }
                            } else {
                                System.out.println("No hay canción actual para eliminar.");
                            }
                        } else {
                            if (it.hasNext()) {
                                System.out.println("Eliminando la canción actual: " + it.previous().getTitulo());
                                it.remove();
                                if (it.hasPrevious()) {
                                    System.out.println("Reproduciendo la canción previa: " + it.previous().getTitulo());
                                } else {
                                    it.next();
                                    System.out.println("No hay canción previa. Reproduciendo la siguiente canción: " + it.next().getTitulo());
                                }
                            } else {
                                System.out.println("No hay canción actual para eliminar.");
                            }
                        }
                    }
                    break;
            }
        } while (opcion != 0);
    }

    private static void imprimirPlaylist(LinkedList<Cancion> playlist) {
        final ListIterator<Cancion> iterator = playlist.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public static int obtenerOpcion() {

        imprimirMenu();
        return 1;

    }


    public static void imprimirMenu() {

        System.out.println("0 - Salir de la lista de reproducción");
        System.out.println("1 - Reproducir siguiente canción de la lista");
        System.out.println("2 - Reproducir la canción previa de la lista");
        System.out.println("3 - Repetir la canción actual");
        System.out.println("4 - Imprimir la lista de canciones en la playlist");
        System.out.println("5 - Volver a imprimir el menú");

    }


}


