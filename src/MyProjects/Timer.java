package MyProjects;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Timer extends JFrame {

    Timer() throws InterruptedException {
        JFrame frame = new JFrame("Timer");
        JPanel background = new JPanel();
        JLabel clock = new JLabel();
        JLabel Date = new JLabel();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        int day_number;
        String day = " ";
        Calendar calendar;

        while (true) {

            background.setLayout(new GridLayout(2, 1,-50,-30));
            background.setBackground(Color.BLACK);

            clock.setForeground(Color.WHITE);
            clock.setVerticalTextPosition(JLabel.CENTER);
            clock.setHorizontalAlignment(JLabel.CENTER);
            clock.setFont(new Font("Hiragino Kaku Gothic Pro", Font.PLAIN, 150));

            Date.setForeground(Color.WHITE);
            Date.setVerticalTextPosition(JLabel.CENTER);
            Date.setHorizontalAlignment(JLabel.CENTER);
            Date.setFont(new Font("Hiragino Kaku Gothic Pro", Font.PLAIN, 30));

            LocalDateTime now = LocalDateTime.now();
            calendar = Calendar.getInstance();
            day_number = calendar.get(Calendar.DAY_OF_WEEK);
            switch (day_number){
                case 2:
                    day="Monday";
                    break;
                case 3:
                    day="Tuesday";
                    break;
                case 4:
                    day="Wednesday";
                    break;
                case 5:
                    day="Thursday";
                    break;
                case 6:
                    day="Friday";
                    break;
                case 7:
                    day="Saturday";
                    break;
                case 1:
                    day="Sunday";
                    break;
                default:
                    break;
            }

            clock.setText(time.format(now));
            Date.setText(date.format(now)+"     "+day);
            background.add(clock);
            background.add(Date);
            TimeUnit.SECONDS.sleep(1);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.add(background, BorderLayout.CENTER);

            frame.setVisible(true);
            device.setFullScreenWindow(frame);
        }
    }
}

