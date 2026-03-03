import java.awt.*;
import javax.swing.*;

public class Payment extends JFrame {

    public Payment(){
        setTitle("Payment");
        setSize(350,300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        StringBuilder sb = new StringBuilder();

        for(String item: Cart.items){
            sb.append(item+"\n");
        }
        sb.append("\nTotal: $"+Cart.total);

        area.setText(sb.toString());

        JButton qrBtn = new JButton("Pay with QR");

        add(new JScrollPane(area),BorderLayout.CENTER);
        add(qrBtn,BorderLayout.SOUTH);

        qrBtn.addActionListener(e -> new QrCode().setVisible(true));
    }
}