public class PatternBlinker extends Pattern {
    private int _sizeX, _sizeY;
    private boolean[][] _cellPattern;
    public PatternBlinker() {
        _sizeX = 5;
        _sizeY = 5;
        _cellPattern = new boolean[][] {
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}
        };
    }
    public int getSizeX () { return _sizeX; }
    public int getSizeY() { return _sizeY; }
    public boolean getCell(int x, int y) { return _cellPattern[x][y]; }
}