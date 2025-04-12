import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<int[]> cells = new ArrayList<>();

    public void addCell(int x, int y) {
        cells.add(new int[]{x, y});
    }

    public int getSize() {
        return cells.size();
    }

    public List<int[]> getCells() {
        return cells;
    }
}
