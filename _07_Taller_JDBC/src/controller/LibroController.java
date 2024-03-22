package controller;

import entity.Autor;
import entity.Libro;
import model.AutorModel;
import model.LibroModel;

import javax.swing.*;

public class LibroController {

    public static  void create(){
        LibroModel objLibroModel = new LibroModel();

        String libroTitle = JOptionPane.showInputDialog("Ingresa el nombre del libro");
        String libroYear = JOptionPane.showInputDialog("Ingrese el año de la publicacion del libro");
        double libroPrice = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del libro"));

        AutorController.getAll();
        int libroAutorId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del autor que escribió el libro"));


        Libro objLibro = new Libro();
        objLibro.setTitle(libroTitle);
        objLibro.setPublication_date(libroYear);
        objLibro.setPrice(libroPrice);
        objLibro.setAutorId(libroAutorId);

        objLibro = (Libro) objLibroModel.insert(objLibro);

        JOptionPane.showMessageDialog(null,objLibro.toString());
    }

    public static void getAll(){
        LibroModel objModel = new LibroModel();

        String listLibros = "LISTA DE LIBROS \n";

        for (Object libro : objModel.findAll()){

            Libro objLibro = (Libro) libro;
            listLibros += objLibro.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null,listLibros);
    }

    public static String getAllString(){
        LibroModel objModel = new LibroModel();

        String listLibros = "LISTA DE LIBROS \n";

        for (Object libro : objModel.findAll()){

            Libro objLibro = (Libro) libro;
            listLibros += objLibro.toString() + "\n";
        }
        return listLibros;
    }

    public static void update() {
        LibroModel objLibroModel = new LibroModel();

        String listLibros = getAllString();

        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listLibros + "\nIngresa el Id del libro que desea editar"));

        Libro objLibro = objLibroModel.findById(idUpdate);

        if (objLibro == null) {
            JOptionPane.showMessageDialog(null, "No se encontro el libro");
        } else {

            String libroTitle = JOptionPane.showInputDialog("Ingresa el nombre del libro");
            String libroYear = JOptionPane.showInputDialog("Ingrese el año de la publicacion del libro");
            double libroPrice = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio del libro"));

            AutorController.getAll();
            int libroAutorId = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del autor que escribió el libro"));

            objLibro.setTitle(libroTitle);
            objLibro.setPublication_date(libroYear);
            objLibro.setPrice(libroPrice);
            objLibro.setAutorId(libroAutorId);

            objLibroModel.update(objLibro);
        }

    }


}
