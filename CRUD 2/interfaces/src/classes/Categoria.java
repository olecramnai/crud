package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.crud;

public class Categoria implements crud{
    int id;
    String name;
    
    public Categoria (int id){
      if(id > 0){
          String sql = "SELECT * FROM categoria Where id = ?";
        try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet registro = stmt.executeQuery();

        while(registro.next()){
          this.setId(registro.getInt("id"));
          this.setName(registro.getString("nome"));
        }

        }catch(SQLException e){
          System.out.println("Error na consulta de Categorias: " + e.toString());

        }
      }
    }
  
    public int getId() {
      return id;
    }
    public void setId(int id) {
      this.id = id;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
  

    @Override
    public void add() {
    }
    @Override
    public void list() {
    }
    @Override
    public void update() {
    }
    @Override
    public void delete() {
    }
  }