import Connectors.AnnualConnector;
import Connectors.AnnualExpenseDTO;
import Connectors.ApiKey;

import javax.swing.*;
import java.awt.*;


public class MainGui {
    JFrame frame;
//    JButton button;
    private static String apiKey;

    public static void main (String[] args) {

        apiKey = ApiKey.getKeys();

        AnnualConnector annuals = new AnnualConnector();
        annuals.getAnnuals(apiKey);

        for (AnnualExpenseDTO annual : annuals.annualExpenses) {
            System.out.println(annual.getName());
        }

        MainGui gui = new MainGui();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        button = new JButton("Click");
        MainPanel mainPanel = new MainPanel();
        frame.getContentPane().add(mainPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
//        try {
//            Thread.sleep(500);
//        } catch(Exception x) {}
    }

    class MainPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.green);
        }
    }

}
