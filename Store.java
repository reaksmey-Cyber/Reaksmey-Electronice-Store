import java.awt.*;
import javax.swing.*;

public class Store extends JFrame {

    public Store(){
        setTitle("Electronic Store");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,1,10,10));

        JButton productBtn = new JButton("View Products");
        JButton paymentBtn = new JButton("Payment");

        add(productBtn);
        add(paymentBtn);

        productBtn.addActionListener(e -> new Products().setVisible(true));
        paymentBtn.addActionListener(e -> new Payment().setVisible(true));
    }
}