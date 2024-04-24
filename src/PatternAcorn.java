public class PatternAcorn extends Pattern {
    private int _sizeX, _sizeY;
    private boolean[][] _cellPattern;
    public PatternAcorn() {
        _sizeX = 5;
        _sizeY = 9;
        _cellPattern = new boolean[][] {
                {false, false, false, false, false, false, false, false, false},
                {false, false, true, false, false, false, false, false, false},
                {false, false, false, false, true, false, false, false, false},
                {false, true, true, false, false, true, true, true, false},
                {false, false, false, false, false, false, false, false, false},
        };
    }
    public int getSizeX () { return _sizeX; }
    public int getSizeY() { return _sizeY; }
    public boolean getCell(int x, int y) { return _cellPattern[x][y]; }
}