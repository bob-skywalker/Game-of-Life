import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private int size;
    private JButton[][] buttons;

    public GameView(int size, GameModel model, GameController controller) {
        this.size = size;
        this.buttons = new JButton[size][size];
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(size, size));

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(30, 30));
                button.addActionListener(e -> controller.cellClicked(x, y));
                add(button);
                buttons[x][y] = button;
            }
        }
        setVisible(true);
    }

    public void update(boolean[][] grid) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                buttons[x][y].setBackground(grid[x][y] ? Color.BLACK : Color.WHITE);
            }
        }
    }
}
