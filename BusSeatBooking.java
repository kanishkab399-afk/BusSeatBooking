import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BusSeatBooking extends JFrame {

    JToggleButton[] seats = new JToggleButton[20];
    JLabel bookedLabel;
    int bookedCount = 0;

    BusSeatBooking() {

        // Window title
        setTitle("Bus Seat Booking");

        // Window size
        setSize(500, 500);

        // Close program when window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main layout
        setLayout(new BorderLayout(10, 10));

        // Heading
        JLabel title = new JLabel("BUS SEAT BOOKING", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        add(title, BorderLayout.NORTH);

        // Panel for 20 seats
        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(4, 5, 10, 10));

        // Create 20 seats
        for (int i = 0; i < 20; i++) {

            seats[i] = new JToggleButton("Seat " + (i + 1));

            final int seatNumber = i + 1;

            seats[i].addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {

                    if (seats[seatNumber - 1].isSelected()) {

                        // Seat booked
                        bookedCount++;

                        seats[seatNumber - 1].setText(
                                "Seat " + seatNumber + "\nBooked"
                        );

                    } else {

                        // Seat available
                        bookedCount--;

                        seats[seatNumber - 1].setText(
                                "Seat " + seatNumber
                        );
                    }

                    // Update booked count
                    bookedLabel.setText(
                            "Booked Seats: " + bookedCount
                    );
                }
            });

            seatPanel.add(seats[i]);
        }

        add(seatPanel, BorderLayout.CENTER);

        // Label showing booked count
        bookedLabel = new JLabel(
                "Booked Seats: 0",
                SwingConstants.CENTER
        );

        bookedLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        add(bookedLabel, BorderLayout.SOUTH);

        // Make window visible
        setVisible(true);
    }

    public static void main(String[] args) {

        new BusSeatBooking();
    }
}