import javax.swing.*;

public class QrCode extends JFrame {

    public QrCode(){
        setTitle("QR Payment");
        setSize(300,300);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("QR PAYMENT SUCCESS",SwingConstants.CENTER);
        add(label);
    }
}