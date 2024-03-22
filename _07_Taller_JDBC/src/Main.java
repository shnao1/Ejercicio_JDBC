import controller.AutorController;
import controller.LibroController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String option = "";
        String option2 = "";
        String option3 = "";


        do {

            option = JOptionPane.showInputDialog("""
                    1. Autores
                    2. Libros
                    3. Salir
                                  
                    Elige una opción:
                    """);

            switch (option) {

                case "1":

                    do {
                        option2 = JOptionPane.showInputDialog("""
                                1. Lista de autores
                                2. Agregar autor
                                3. Actualizar informacion de autores
                                4. Eliminar un auto
                                5. Exit
                                                    
                                Choose an option:
                                """);

                        switch (option2) {

                            case "1":
                                AutorController.getAll();
                                break;
                            case "2":
                                AutorController.create();
                                break;
                            case "3":
                                AutorController.update();
                                break;
                            case "4":
                                AutorController.delete();
                                break;

                        }

                    } while (!option2.equals("5"));

                    break;
                case "2":

                    do {
                        option2 = JOptionPane.showInputDialog("""
                                1. Lista de libros
                                2. Consultar un libro
                                3. Actualizar libro
                                4. Eliminar un libro
                                5. Buscar un Libro
                                6. Exit
                                                    
                                Elige una opción:
                                """);

                        switch (option2) {

                            case "1":
                                LibroController.getAll();
                                break;
                            case "2":
                                LibroController.create();
                                break;
                            case "3":
                                LibroController.update();
                                break;
                            case "4":

                                break;
                            case "5":

                                do {
                                    option3 = JOptionPane.showInputDialog("""
                                            1. Buscar un libro por nombre
                                            2. Buscar un libro por Autor
                                            3. Exit
                                                                
                                            Elige una opción:
                                            """);

                                    switch (option3) {

                                        case "1":

                                            break;
                                        case "2":

                                            break;
                                    }


                                } while (!option3.equals("3"));

                                break;
                        }
                    } while (!option2.equals("6"));


            }
        }while (!option.equals("3"));
    }
}
