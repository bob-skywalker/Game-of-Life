public class GameModel {
    private int size;
    private boolean[][] grid;
    private boolean[][] nextGrid;

    public GameModel(int size) {
        this.size = size;
        this.grid = new boolean[size][size];
        this.nextGrid = new boolean[size][size];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void updateGrid() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int liveNeighbors = countLiveNeighbors(x, y);
                if (grid[x][y]) {
                    nextGrid[x][y] = liveNeighbors == 2 || liveNeighbors == 3;
                } else {
                    nextGrid[x][y] = liveNeighbors == 3;
                }
            }
        }
        boolean[][] temp = grid;
        grid = nextGrid;
        nextGrid = temp;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int dx = (x + i + size) % size;
                int dy = (y + j + size) % size;
                if (grid[dx][dy]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void toggleCell(int x, int y) {
        grid[x][y] = !grid[x][y];
    }

}
