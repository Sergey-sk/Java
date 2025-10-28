package PR_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageMover extends JFrame {
    private JLabel imageLabel;
    private Point originalPosition;

    public ImageMover() {
        setTitle("Перемещение изображения");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.LIGHT_GRAY);

        imageLabel = new JLabel("Изображение");
        imageLabel.setBounds(250, 150, 120, 40);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.YELLOW);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        originalPosition = new Point(250, 150);

        contentPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageLabel.setLocation(e.getX() - 60, e.getY() - 20);
            }
        });

        JButton centerButton = new JButton("В центр");
        centerButton.setBounds(250, 300, 100, 30);
        centerButton.addActionListener(e -> imageLabel.setLocation(originalPosition));

        contentPanel.add(imageLabel);
        contentPanel.add(centerButton);
        add(contentPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageMover::new);
    }
}