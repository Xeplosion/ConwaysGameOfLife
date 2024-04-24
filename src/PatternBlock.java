public class PatternBlock extends Pattern {
    private int _sizeX, _sizeY;
    private boolean[][] _cellPattern;
    public PatternBlock() {
        _sizeX = 4;
        _sizeY = 4;
        _cellPattern = new boolean[][] {
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };
    }
    public int getSizeX () { return _sizeX; }
    public int getSizeY() { return _sizeY; }
    public boolean getCell(int x, int y) { return _cellPattern[x][y]; }
}