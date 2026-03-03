import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Products extends JFrame {

    JList<String> list;
    DefaultListModel<String> model;

    public Products(){
        setTitle("Products");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        model = new DefaultListModel<>();
        list = new JList<>(model);

        loadProducts();

        JButton addBtn = new JButton("Add To Cart");

        add(new JScrollPane(list),BorderLayout.CENTER);
        add(addBtn,BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addToCart());
    }

    void loadProducts(){
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while(rs.next()){
                model.addElement(rs.getString("name")+" - $"+rs.getDouble("price"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void addToCart(){
        String selected = list.getSelectedValue();
        if(selected!=null){
            String[] parts = selected.split(" - \\$");
            Cart.addItem(parts[0],Double.parseDouble(parts[1]));
            JOptionPane.showMessageDialog(this,"Added to Cart");
        }
    }
}