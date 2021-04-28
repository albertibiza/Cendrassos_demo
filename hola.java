import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hola{

    //EL METODE
    public static void main(String[] args) throws IOException {

        //STRING PER GUARDAR RUTA FITXER
        String ruta_string = "\n";

        //SCANNER
        Scanner scanner = new Scanner(System.in);

        //MENTRES QUE LA RUTA EN STRING NO SIGUI EXIT FARÀ SEMPRE EL BUCLE
        while (!ruta_string.equals("EXIT")){

            //INTENTA
            try{

                //VARIABLES
                int fila_contador = 0, fila_contadorr = 0,fila_contadorrr = 0,index = 0,indexx ,indexxx;

                //MAPA PER REGISTRAR LES FILES I COLUMNES DE CADA PARAULA A BUSCAR
                Map<String, String> mapa_posicio = new HashMap<String, String>();

                //PREGUNTEM RUTA AL USUARI I L'ASSIGNEM A LA VARIABLE O EXIT
                System.out.print("INTRODUEIX RUTA PER BUSCAR WALLY, PER ABANDONAR --> EXIT: ");
                ruta_string = scanner.nextLine();
                System.out.println();

                //CONTADOR PER CONTAR
                int contador = 0;

                //ASSIGNEM RUTA STRING A LA VARIABLE FILE, PER OBTENIR EL FITXER SELECCIONAT
                File ruta = new File(ruta_string);

                //SI NO EXISTEIX EL FITXER:
                if (!ruta.exists()){
                    System.out.println("Fitxer: "+ruta.getName()+" --> No existeix el fitxer");
                    System.out.println();}

                //SCANNER PER LLEGIR LINIA PER LINIA EL FITXER
                Scanner linies = new Scanner(ruta);

                //MENTRES EXISTEIXI LINIA EN EL FITXER:
                while (linies.hasNextLine()){

                    //ASSIGNAR LINIA A LA VARIABLE LINIA
                    String linia = linies.nextLine();

                    //SI LINIA CONTÉ:
                    if (linia.contains(" Wally ")) {

                        //SUMA CONTADOR
                        contador++;

                        //BUSCA EN LA LINIA SI ESTÀ LA PARAULA I L'ASSIGNA A LA VARIABLE INDEX
                        indexxx = linia.indexOf("Wally");

                        //SI LA PARAULA A LA VARIABLE EXISTEIX
                        if (index != -1){

                            //REGISTRA LA FILA I LA COLUMNA DE LA PARAULA EN UN MAPA DE POSICIONS
                            mapa_posicio.put("En Wally és a la fila: "+fila_contador," columna: "+ index); }}

                    //X2
                    if (linia.contains(" Wally.")) {
                        contador++;
                        indexx = linia.indexOf("Wally.");
                        if (indexx != -1){
                            mapa_posicio.put("En Wally és a la fila: "+fila_contadorr," columna: "+indexx); }}

                    //X3
                    if (linia.contains("Wally,")) {
                        contador++;
                        indexxx = linia.indexOf("Wally,");
                        if (indexxx != -1){
                            mapa_posicio.put("En Wally és a la fila: "+fila_contadorrr," columna: "+ indexxx); }}

                    //AUMENTAR CONTADORS DE FILES
                    fila_contador++;
                    fila_contadorr++;
                    fila_contadorrr++; }

                //EN WALLY NO HI ÉS
                switch (contador){
                    case 0:
                        System.out.println("Fitxer: "+ruta.getName()+"--> En Wally no hi és");
                        System.out.println();
                        break; }

                //SI TÉ MES DE 1 WALLY --> FITXER INCORRECTE
                if (contador>1){
                    System.out.println("Fitxer: "+ruta.getName()+" --> FITXER INCORRECTE");
                    System.out.println();}

                //SI NOMÉS HI HA UN WALLY
                if (contador==1){

                    //IMPRIMIRÀ EL MAPA AMB LES DADES DE FILA I COLUMNA REGISTRADA PER LA PARAULA ESPECIFICA.
                    for (Map.Entry<String,String> entry : mapa_posicio.entrySet()){System.out.println(entry.getKey()+" "+entry.getValue());System.out.println();} } }

            // SI EXISTEIX UNA EXCEPCIÓ:
            catch (Exception Excpt){

                //GOOD BYE SI ÉS EXIT
                if (ruta_string.equals("EXIT")){ System.out.println("GOOD BYE");}

                //SINÒ: ERROR DEL PROGRAMA I TORNÀ A FER EL BUCLE
                else {

                    //ERROR
                    System.out.println("ERROR PROGRAMA ");
                    System.out.println();
                }}}}}
