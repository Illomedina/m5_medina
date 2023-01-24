import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        /* Variable que controla quina opció hemtriat */
        int opcio;
        /* Variable per controlar llargaria de l'array */
        int N = 6;
        /* Declaració de l'array */
        String[] nombres = new String[N];
        /* Variable per saber el nombre de variables disponibles */
        int disponibles = 0;
        /* Declaració de l'escanner */
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Tria una de les x opcions:");
            System.out.println("1.-Inserir");
            System.out.println("2.-Localizar");
            System.out.println("3.-Recuperar");
            System.out.println("4.-Suprimir");
            System.out.println("5.-Suprimir Dada");
            System.out.println("6.-Anul·lar");
            System.out.println("7.-PrimerDarrer");
            System.out.println("8.-Imprimir");
            System.out.println("9.-Sortir del programa");
            opcio = scanner.nextInt();
            switch (opcio) {
                case 1:
                    String valorInserir;
                    int posicioInserir;
                    if (disponibles == N) {
                        /*
                         * Si no hi ha espais disponibles al Array avisa de que s'eliminarà
                         * el contingut de la ultima posició
                         */
                        System.out.println("Si introdueixes un nou Cognom eliminaràs l'ultim de la llista!!");
                        System.out.println("Introdueix la posició a la qual vols inserir un Cognom");
                        posicioInserir = scanner.nextInt();
                        /* Demana el nou valor en la posició x */
                        System.out.println("Introdueix el cognom que vols inserir");
                        valorInserir = scanner.next();
                        /* Desplaçar cap a la dreta */
                        for (int i = (N - 1); i > posicioInserir; i--) {
                            nombres[i] = nombres[i - 1];
                        }
                        /* Introdueix el nou valor en la posició */
                        nombres[posicioInserir] = valorInserir;
                        disponibles++;
                    } else if (disponibles == 0) {
                        System.out.println("El valor que vas a introduir es posarà en la posioció 0");
                        System.out.println("Introdueix el cognom que vols inserir");
                        valorInserir = scanner.next();
                        nombres[0] = valorInserir;
                        disponibles++;

                    } else {
                        // Indica quines posicions son disponibles
                        System.out.println("Les posicions disponibles que tens per inserir son desde la 0 fins la "
                                + (disponibles));
                        // Demana la posició en la que volem introduir el nom
                        System.out.println("Introdueix la posició a la qual vols inserir un Cognom");
                        posicioInserir = scanner.nextInt();
                        // Comprova que la posició que hem indicat es vàlida
                        while (posicioInserir > disponibles) {
                            // Avisa que la posició que hem posat no es valida
                            System.out.println("Aquesta posició no està disponible. Intenta una posició valida");
                            // Demana la posició una altra vegada
                            posicioInserir = scanner.nextInt();
                        }
                        // Demana el cogonom a inserir
                        System.out.println("Indica el cognom que vols inserir");
                        valorInserir = scanner.next();
                        if (nombres[posicioInserir] == null) {
                            nombres[posicioInserir] = valorInserir;
                        } else {
                            for (int i = disponibles - 1; posicioInserir < i; i--) {
                                nombres[i] = nombres[i - 1];
                            }
                        }
                        disponibles++;
                    }
                    break;

                case 2:
                    if (disponibles == 0) {
                        System.out.println("No hay valores en la array");
                    } else {
                        System.out.print("Introduce el nombre que quieres buscar: ");
                        String x = scanner.nextLine();
                        System.out.println();
                        int i = 0; // Contador

                        do { // Bucle para comparar todas las Arrays en busca del nombre introducido.
                            if (x.equals(nombres[i])) { // En caso de que la array coincida con el valor introducido
                                                        // hará un break.
                                break;
                            }
                            i++; // Contador para cambiar la posición de la array
                            /*
                             * Condición para que el bucle no termine hasta que se ejecute 6 veces ya quehay
                             * 6 valores.
                             */
                        } while (i < disponibles);
                        /*
                         * En caso de i ser menor que 6 significaría que ha encontrado el nombre por lo
                         * que digo en que posición ha sido encontrado.
                         */
                        if (i < disponibles) {
                            System.out.print("El nombre introducido se encuentra en la posición " + (i));
                        } else { // En caso contrario especificará que el nombre no ha sido encontrado.
                            System.out.println("No se ha encontrado el nombre introducido.");
                        }
                    }
                    break;

                case 3:
                    /* Demana la posició */
                    System.out.println("Introdueix quina posició vols consultar");
                    int x = scanner.nextInt();

                    if (disponibles == 0) {
                        System.out.println("Aquest Array està buit");
                    } else {
                        /* Imprimeix per pantalla el cognom de la posició demanada */
                        System.out.println("A la posició " + x + " està el valor: ");
                        System.out.println(nombres[x]);
                    }
                    break;

                case 4:
                    if (disponibles == 0) {
                        System.out.println("Aquest array està completament buit");
                    }

                    else {
                        // Demanem la posició en la que se troba el valor que volem eliminar
                        System.out.println("Quina posició te el element que vols eliminar?");
                        int posicioSuprimir = scanner.nextInt();

                        if (nombres[posicioSuprimir] != null) {

                            for (int i = posicioSuprimir; i < disponibles - 1; i++) {
                                nombres[i] = nombres[i + 1];
                            }
                            nombres[disponibles - 1] = null;
                            disponibles--;
                        } else {
                            System.out.println("La posició que has indicat ja està buida");

                        }
                    }
                    break;

                case 5:
                    if (disponibles == 0) {
                        System.out.println("Esta array está completamente vacía");
                    }
                    System.out.print("Introduce el nombre que quieres buscar: ");
                    String o = scanner.nextLine();
                    System.out.println();
                    int y = 0; // Contador
                    for (y = 0; y < disponibles; y++) {
                        if (o.equals(nombres[y])) {
                            do { // Bucle para comparar todas las Arrays en busca del nombre introducido.
                                if (o.equals(nombres[y])) { // En caso de que la array coincida con el valor introducido
                                                            // hará un break.
                                    for (int h = y; h < disponibles - 1; h++) { // h es un contador para este bucle.
                                        nombres[h] = nombres[h + 1];
                                    }
                                    nombres[disponibles - 1] = null;
                                    disponibles--;
                                }
                                y++; // Contador para cambiar la posición de la array
                            } while (y < disponibles);
                            if (disponibles != 0) {
                                for (int z = 0; z < 6; z++) {
                                    System.out.println(nombres[z]);
                                }
                            }
                        } else {
                            System.out.println("El valor introducido no se encuentra en al Array.");
                            break;
                        }
                    }
                    break;

                case 6:
                    /* Aqui comprovaremos que se han guardado los valores */
                    for (int i = 0; i < disponibles; i++) {
                        System.out.println(nombres[i]);
                    }

                    /* Elimina todos los valores de la array y los convierte en null */
                    for (int i = 0; i < disponibles; i++) {
                        nombres[i] = null;

                        /* Si algun elemento de la array ya es nulo que lo ignore */
                        if (nombres[i] != null) {
                            disponibles--;
                        }
                    }
                    break;

                case 7:
                    int numero;
                    if (disponibles == 0) {
                        System.out.println("No hay nada dentro de la array");
                    }

                    else {
                        do { // bucle en el que hago elegir entre 1 2 y 5 para ver el primer o último
                             // elemento y finalizar el programa.
                            System.out.println(
                                    "Pulsa 1 para proporcionar el primer nombre o 2 para propocionar el último, en caso de querer salir pulsa 5.");
                            numero = scanner.nextInt();
                            switch (numero) { // Switch para ejecutar el código según la elección.
                                case 1: // Primer nombre
                                    System.out.println(nombres[0]);
                                    System.out.println();
                                    break;
                                case 2: // Último nombre
                                    System.out.println(nombres[disponibles]);
                                    System.out.println();
                                    break;
                                case 5: // En caso de querer finalizar el programa.
                                    System.out.println("Finalizando Ejecución....");
                                    break;
                                default: // En caso de no ser ninguna opción.
                                    System.out.println("Esa no es ninguna opción, vuelve a intentarlo.");
                                    System.out.println();
                            }
                        } while (numero != 5); // Condición con la que el programa se ejecutará hasta que se seleccione
                                               // 5
                    }
                    break;

                case 8:
                    if (disponibles == 0) {
                        System.out.println("No hay valores en la array");
                    } else {
                        for (int i = 0; i < disponibles; i++) { // Creo un bucle inicializando un contador a 0 y
                                                                // haciendo que se ejecute
                                                                // el
                            System.out.println("En la posición " + i + " tenemos el apellido " + nombres[i]); // Imprimo
                                                                                                              // la
                                                                                                              // posición
                                                                                                              // y el
                                                                                                              // valor
                                                                                                              // de la
                                                                                                              // array
                                                                                                              // en la
                                                                                                              // posicion
                                                                                                              // i
                        }
                    }
                    break;
                case 9:
                    /* Opció per sortir del programa */
                    System.out.println("Estas sortint del programa. Adeu!");
                    break;
                case 10:
                    /* Test per saber la correcta gestió de nombres disponibles */
                    System.out.println(disponibles);
                    break;
                default:
                    /* Opció per defecte si posem un nombre que no està en la llista */
                    System.out.println("Esta opció no es vàlida!!");
                    break;

            }
            /* Condició per sortir del menú */
        } while (opcio != 9);

        // Hem de solucionar un problema amb les variables usades per guardar valors en
        // cada un dels métodes. Tenim que establir una nomenclatura o compartir una
        // variable.

    }

}