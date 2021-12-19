//by Iker
//Libreria importada para poder capturar la entrada de datos del usuario
import java.util.Scanner;

public class Hundir_la_flota {
  public static void main (String[] args) {
    //Scanner
    Scanner keyboard = new Scanner(System.in);
    //Usuario
    int user_rows=0;
    int user_columns=0;
    //Acabar juego
    boolean game = true;
    //Ubicacion del barco 1
    int ship1_row = (int)(Math. random()*5);
    int ship1_column = (int)(Math. random()*5);
    boolean ship1 = true;
    //Ubicacion del barco 2
    int ship2_row = (int)(Math. random()*5);
    int ship2_column = (int)(Math. random()*5);
    boolean ship2 = true;

    int ships = 2;
    do {
      ship2_row = (int)(Math. random()*5);
      ship2_column = (int)(Math. random()*5);
    } while (ship2_row == ship1_row || ship2_column==ship1_column);

    //Matriz
    String [][] array = new String[5][5];

    System.out.println();
    System.out.println("    0  1  2  3  4");
    System.out.println("  +---------------+");
    for ( int i = 0 ; i < 5 ; i++ ) {
      System.out.print(" "+i+"|");
      for ( int j = 0 ; j < 5 ; j++ ) {
        array[i][j] = "*"; //Generar valor
        System.out.print(" "+array[i][j]+" "); //Mostrar valor
      }//For
      System.out.println("|");
    }//For
    System.out.println("  +---------------+");

    do {
      //Verificar dades correctes
      do {
          System.out.println();
          System.out.print("Introduzca la fila: ");
          user_rows = keyboard.nextInt();


          if (user_rows < 0 || user_rows > 4 ) {
              System.out.println("La fila introducida no es correcta. ");
          }else{
              System.out.print("Introduzca la columna: ");
              user_columns = keyboard.nextInt();
              if (user_columns < 0 || user_columns > 4 ) {
                  System.out.println("La columna introducida no es correcta. ");
              }
          }
      } while (user_rows < 0 || user_rows > 4 || user_columns > 4 || user_columns < 0);


      //Comprobar
      if ( user_rows == ship1_row && user_columns == ship1_column) {
        if (ship1 == true) {
          array[ship1_row][ship1_column] = "X"; //Dar al barco 1
          ship1 = false;
          ships = ships -1;
          System.out.println("Enhorabuena ha hundido el barco número 1! Queda " + ships + " barco. ");
        }else{
         System.out.println("Ese barco ya ha sido hundido! Aún queda " + ships + " barco. ");
         System.out.println();
        }
      }else if( user_rows == ship2_row && user_columns == ship2_column){
        if (ship2 ==true) {
          array[ship2_row][ship2_column] = "X"; //Dar al barco 2
          ship2 = false;
          ships = ships -1;
          System.out.println("Enhorabuena ha hundido el barco número 2! Queda " + ships + " barco. ");
        }else{
         System.out.println("Ese barco ya ha sido hundido! Aún queda " + ships + " barco. ");
         System.out.println();
        }
      }else{
        array[user_rows][user_columns] = "A"; //Agua
      }

      //Mostrar Juego
      System.out.println();
      System.out.println("    0  1  2  3  4");
      System.out.println("  +---------------+");
      for ( int i = 0 ; i < 5 ; i++ ) {
        System.out.print(" "+i+"|");
        for ( int j = 0 ; j < 5 ; j++ ) {
          System.out.print(" "+array[i][j]+" ");
        }//For
        System.out.println("|");
      }//For
      System.out.println("  +---------------+");

      if ( ships == 0 ) {
        game = false;
    }else if (ships == 1) {
        System.out.println("\nAun queda " + ships + " barco enemigo en pie");
    }else{ //Añadir barcos en el futuro
        System.out.println("\nAun quedan " + ships + " barcos enemigos en pie");
      }
    }while (game != false);
    System.out.println();
    System.out.println("+-------------------------------+");
    System.out.println("|           VICTORIA            |");
    System.out.println("+-------------------------------+\n");
  }//Public
}//Class
