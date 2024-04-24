public class LifeSimulator {
    private final int _sizeX, _sizeY;
    private boolean[][] _cellValues;
    public LifeSimulator (int sizeX, int sizeY) {
        _sizeX = sizeX;
        _sizeY = sizeY;
        _cellValues = new boolean[sizeX][sizeY];
    }
    public int getSizeX() { return _sizeX; }
    public int getSizeY() { return _sizeY; }
    public boolean getCell(int x, int y) {
        if (x < 0 || x >= _sizeX) { return false; }
        if (y < 0 || y >= _sizeY) { return false; }
        return _cellValues[x][y];
    }
    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int x = 0; x < pattern.getSizeX(); x++) {
            for (int y = 0; y < pattern.getSizeY(); y++) {
                if (startX + x < 0 || startY + y< 0) { continue; } // Below grid.
                if (startX + x > _sizeX || startY + y > _sizeY) { continue; } // Above grid.
                _cellValues[startX + x][startY + y] = pattern.getCell(x, y);
            }
        }
    }
    private boolean calculateCellSurvival(int cellX, int cellY) {
        int neighbors = 0;
        // Loop through and check for neighbors.
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) { continue; } // Current cell.
                neighbors += getCell(cellX + x, cellY + y) ? 1 : 0;
            }
        }

        // Return survival based off rules.
        if (getCell(cellX, cellY)) {
            if (neighbors < 2) { return false; }
            else if (neighbors < 4) { return true; }
        } else {
            if (neighbors == 3) { return true; }
        }
        return false;


    }
    public void update() {
        // Create an array to store our updated cell values.
        boolean[][] updateCellPattern = new boolean[_sizeX][_sizeY];

        // Loop through original cell array and calculate cell survival.
        for (int x = 0; x < _sizeX; x++) {
            for (int y = 0; y < _sizeY; y++) {
                updateCellPattern[x][y] = calculateCellSurvival(x, y);
            }
        }

        // Apply our cell changes.
        _cellValues = updateCellPattern;
    }
}