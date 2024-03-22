package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;
import entity.Libro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Libro objLibro = (Libro) obj;

        try {

            String sql = "INSERT INTO libros(titulo,age,precio,Autores) VALUES (?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objLibro.getTitle());
            objPrepare.setString(2,objLibro.getPublication_date());
            objPrepare.setDouble(3,objLibro.getPrice());
            objPrepare.setInt(4,objLibro.getAutorId());

            objPrepare.execute();

            ResultSet objRest = objPrepare.getGeneratedKeys();

            while (objRest.next()){
                objLibro.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null,"Libro Ingresado Satisfactoriamente");

        }catch (Exception error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        }

        ConfigDB.closeConnection();

        return objLibro;
    }

    @Override
    public List<Object> findAll() {

        List<Object> listLibros = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();

        try {

            String sql = "SELECT * FROM libros;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Libro objLibro = new Libro();
                objLibro.setId(objResult.getInt("id"));
                objLibro.setTitle(objResult.getString("titulo"));
                objLibro.setPublication_date(objResult.getString("age"));
                objLibro.setPrice(objResult.getDouble("precio"));
                objLibro.setAutorId(objResult.getInt("Autores"));

                listLibros.add(objLibro);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        }

        ConfigDB.closeConnection();

        return listLibros;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Libro objLibro = (Libro) obj;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE libros SET titulo = ?, age = ?, precio = ?, Autores = ? WHERE id = ?;";

            PreparedStatement objPrepare =  objConnection.prepareStatement(sql);

            objPrepare.setString(1,objLibro.getTitle());
            objPrepare.setString(2, objLibro.getPublication_date());
            objPrepare.setDouble(3, objLibro.getPrice());
            objPrepare.setInt(4, objLibro.getAutorId());
            objPrepare.setInt(5, objLibro.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if(totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"El Libro se actualizo correctamente");
            }

        } catch (Exception error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    public Libro findById(int id){

        Connection objConnection = ConfigDB.openConnection();


        Libro objLibro = null;

        try {

            String sql = "SELECT * FROM libros WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,id);

            ResultSet objResult = objPrepare.executeQuery();

            if (objResult.next()){
                objLibro = new Libro();
                objLibro.setId(objResult.getInt("id"));
                objLibro.setTitle(objResult.getString("titulo"));
                objLibro.setPublication_date(objResult.getString("age"));
                objLibro.setPrice(objResult.getInt("precio"));
                objLibro.setAutorId(objResult.getInt("Autores"));
            }

        }catch(Exception error){
            JOptionPane.showMessageDialog(null,error.getMessage());
        }

        ConfigDB.closeConnection();

        return objLibro;
    }
}
