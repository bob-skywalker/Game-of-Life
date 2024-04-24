import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        int size = 20; // Define the size of the grid. Adjust as needed.

        // Create the model and controller
        GameModel model = new GameModel(size);

        // The view is also the main frame in this application
        GameView view = new GameView(size, model, new GameController(model, view));

        // Set up the JFrame (view already initializes these in its constructor)
        view.setTitle("Game of Life");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 650);  // Optionally adjust size if necessary
        view.setLocationRelativeTo(null);
        view.setVisible(true);

        // Add control buttons
        JPanel panel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        GameController controller = new GameController(model, view);

//        startButton.addActionListener(e -> controller.startGame());
//        stopButton.addActionListener(e -> controller.stopGame());

        panel.add(startButton);
        panel.add(stopButton);

        // Add the panel to the bottom of the frame
        view.getContentPane().add(panel, BorderLayout.SOUTH);
    }
}
