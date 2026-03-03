import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {

    JTextField email;
    JPasswordField password;

    public Login() {
        setTitle("Login");
        setSize(350,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,2,10,10));

        add(new JLabel("Email:"));
        email = new JTextField();
        add(email);

        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);

        JButton loginBtn = new JButton("Login");
        JButton signBtn = new JButton("Sign Up");

        add(loginBtn);
        add(signBtn);

        loginBtn.addActionListener(e -> login());
        signBtn.addActionListener(e -> {
            new SignUp().setVisible(true);
            dispose();
        });
    }

    void login(){
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );
            ps.setString(1,email.getText());
            ps.setString(2,new String(password.getPassword()));
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                new Store().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Invalid Login");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}