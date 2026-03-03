import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class SignUp extends JFrame {

    JTextField email;
    JPasswordField password;

    public SignUp(){
        setTitle("Sign Up");
        setSize(300,200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,10,10));

        add(new JLabel("Email:"));
        email = new JTextField();
        add(email);

        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);

        JButton createBtn = new JButton("Create");
        add(createBtn);

        createBtn.addActionListener(e -> register());
    }

    void register(){
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(email,password) VALUES(?,?)"
            );
            ps.setString(1,email.getText());
            ps.setString(2,new String(password.getPassword()));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,"Account Created!");
            new Login().setVisible(true);
            dispose();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}