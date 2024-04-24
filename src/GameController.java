import javax.swing.Timer;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        new Timer(100, e -> updateView()).start();
    }

    public void cellClicked(int x, int y) {
        model.toggleCell(x, y);
        updateView();
    }

    private void updateView() {
        view.update(model.getGrid());
    }
}
