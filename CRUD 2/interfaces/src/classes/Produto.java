package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.crud;

public class Produto implements crud{
  int id;
  int group_Id;
  String name;
  double value;
  int quantity;
  
  public Produto (int id) {
    if(id > 0){
      String sql = "SELECT * FROM produtos WHERE id = ?";

      try{
        Connection con = DB.conexao();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet registro = stmt.executeQuery();

        while(registro.next()){
          this.setId(registro.getInt("id"));
          this.setName(registro.getString("nome"));
          this.setValue(registro.getDouble("preco"));
          this.setQuantity(registro.getInt("quantidade"));
        }

      }catch(SQLException e){
        System.out.println("Error na consulta de Produtos: " + e.toString());

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
  public double getValue() {
    return value;
  }
  public void setValue(double value) {
    this.value = value;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getGroup_Id() {
    return group_Id;
  }
  public void setGroup_Id(int group_Id) {
    this.group_Id = group_Id;
  }


  @Override
  public void add() {
    
  }
  @Override
  public void delete() {
    
  }
  @Override
  public void list() {
    
  }
  @Override
  public void update() {
    
  }
}
