import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;
    private Timer timer;

    public DigitalClock() {
        // Create the time label
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));

        // Create the date label
        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Create a panel to hold the labels
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);

        // Add the panel to the frame
        add(panel);

        // Create a timer to update the time every second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();

        // Set up the frame
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateTime() {
        // Get the current time
        Date date = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

        // Update the time label
        timeLabel.setText(timeFormat.format(date));

        // Update the date label
        dateLabel.setText(dateFormat.format(date));
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}