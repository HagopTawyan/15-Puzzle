public class MatrixTiles extends Tiles{
    private byte[][] tile;
    private int emptyCol;
    private int emptyRow;
    
    public boolean isSolved(){
        int counter = 1;
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++, counter++) {
                if (tile[i][j] != counter) {
                    return false;
                }
                if (tile[i][j] == (getConfiguration().getSize() * getConfiguration().getSize() -1)
                        && counter == (getConfiguration().getSize() * getConfiguration().getSize() -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected void moveImpl(Direction direction){
        switch (direction) {
            case UP:
                //down to up
                if (emptyRow == getSize() -1) {
                    System.out.println("There is no such way!!!");
                    break;
                }else{
                    tile[emptyRow][emptyCol] = tile[emptyRow + 1][emptyCol];
                    tile[emptyRow + 1][emptyCol] = EMPTY;
                    incrementMoveCount();
                    break;
                }
            case DOWN:
                if ( emptyRow == 0 ) {
                    System.out.println("There is no such way!!!");
                    break;
                }else {
                    tile[emptyRow][emptyCol] = tile[emptyRow - 1][emptyCol];
                    tile[emptyRow - 1][emptyCol] = EMPTY;
                    incrementMoveCount();
                    break;
                }
            case LEFT:
                if (emptyCol == 3) {
                    System.out.println("There is no such way!!!");
                    break;
                }else {
                    tile[emptyRow][emptyCol] = tile[emptyRow][emptyCol + 1];
                    tile[emptyRow][emptyCol + 1] = EMPTY;
                    incrementMoveCount();
                    break;
                }
            case RIGHT:
                if (emptyCol == 0){
                    System.out.println("There is no such way!!!");
                    break;
                } else {
                    tile[emptyRow][emptyCol] = tile[emptyRow][emptyCol - 1];
                    tile[emptyRow][emptyCol - 1] = EMPTY;
                    incrementMoveCount();
                    break;
                }
        }

    }

    public MatrixTiles(String format) throws ConfigurationFormatException, InvalidConfigurationException{
        super(format);
        tile = new byte[getConfiguration().getSize()][getConfiguration().getSize()];
        getConfiguration().initialize(this);
        findZero();
    }
    public byte getTile(int row,int col){
        if (row < 0 || row >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        if (col < 0 || col >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        return tile[row][col];
    }
    public void setTile(int row,int col, byte value){
        if (row < 0 || row >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        if (col < 0 || col >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        tile[row][col] = value;
    }
    
    
    public void findZero(){
        int counter = 0;
        for (int i = 0; i < getConfiguration().getSize(); i++) {
            for (int j = 0; j < getConfiguration().getSize(); j++, counter++) {
                if (tile[i][j]==0){
                    emptyCol=j;
                    emptyRow=i;
                }
            }
        }
    }
}



