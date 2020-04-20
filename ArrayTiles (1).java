public class ArrayTiles extends Tiles{
    private byte[] tiles;
    private int emptyPos;



    protected void moveImpl(Direction direction){

        switch (direction) {
            case UP:
                if ((emptyPos + getSize()) >= getSize() * getSize()) {
                    System.out.println("There is no such way!!!");
                    break;
                } else {
                    tiles[emptyPos] = tiles[emptyPos + getConfiguration().getSize()];
                    tiles[emptyPos + getConfiguration().getSize()] = EMPTY;
                    incrementMoveCount();
                    break;
                }
            case DOWN:
                if ((emptyPos - getSize()) < 0) {
                    System.out.println("There is no such way!!!");
                    break;
                }else {
                    tiles[emptyPos] = tiles[emptyPos - getConfiguration().getSize()];
                    tiles[emptyPos - getConfiguration().getSize()] = EMPTY;
                    incrementMoveCount();
                    break;
                }
            case LEFT:
                if (((emptyPos + 1) > getSize() * getSize()) || (emptyPos + 1) % getSize() == 0) {
                    System.out.println("There is no such way!!!");
                    break;
                }else {
                    tiles[emptyPos] = tiles[emptyPos + 1];
                    tiles[emptyPos + 1] = EMPTY;
                    incrementMoveCount();
                    break;
                }
            case RIGHT:
                if (emptyPos - 1 < 0  || emptyPos % getSize() == 0) {
                    System.out.println("There is no such way!!!");
                    break;
                }else {
                    tiles[emptyPos] = tiles[emptyPos - 1];
                    tiles[emptyPos - 1] = EMPTY;
                    incrementMoveCount();
                    break;
                }
        }
    }
    
    public void setTile(int row, int col, byte value) {
        if (row < 0 || row >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        if (col < 0 || col >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        tiles[row * getConfiguration().getSize() + col] = value;
    }
    public byte[] getTiles(){
        return tiles;
    }
    
    public byte getTile(int row, int col) {
        if (row < 0 || row >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        if (col < 0 || col >= getSize()) {
            System.out.println("Error: position out of the board");
            System.exit(0);
        }
        return tiles[row *getConfiguration().getSize() + col];
    }
    public boolean isSolved() {
        byte counter = 0;
        for (byte i = 0; i < getConfiguration().getSize() * getConfiguration().getSize(); i++) {
            if (tiles[i] == i+1) {
                counter++;
            }
            if (counter == getConfiguration().getSize() * getConfiguration().getSize() -1){
                return true;
            }
        }
        return false;
    }
    
    public ArrayTiles(String format)throws ConfigurationFormatException,InvalidConfigurationException{
        super(format);
        tiles = new byte[getConfiguration().getSize() * getConfiguration().getSize()];
        getConfiguration().initialize(this);
    }
    public void findZero(){
        for(int i =0;i < tiles.length;i++){
            if (tiles[i] == 0){
                emptyPos = i;
            }
        }
    }
}
