package Puzzle15;

public abstract class Tiles {

    
    protected  abstract void moveImpl(Direction direction);
    public abstract byte getTile(int row,int col);
    public abstract void setTile(int row,int col, byte value);
    public abstract boolean isSolved();
    public abstract void findZero();

   
    public void move(Direction direction){
        moveImpl(direction);
    }
    public static final byte EMPTY = 0;
    private static int moves = 0;
    private Configuration configuration;
    public Direction direction;

    public boolean isSolvable(Tiles puzzle) {
        configuration.createArr();
        byte parity = 0;
        byte gridWidth = (byte) Math.sqrt(getSize());
        byte row = 0;
        byte blankRow = 0;
        for (int i = 0; i < configuration.getSize() * configuration.getSize(); i++) {
            if (i % gridWidth == 0) {
                row++;
            }
            if (configuration.getArrElement(i) == 0) {
                blankRow = row;
                continue;
            }
            for (int j = i + 1; j < configuration.getSize() * configuration.getSize(); j++) {
                if (configuration.getArrElement(i) > configuration.getArrElement(j) && configuration.getArrElement(j) != 0) {
                    parity++;
                }
            }
        }
        if (gridWidth % 2 == 0) {
            if (blankRow % 2 == 0) {
                return parity % 2 == 0;
            } else {
                return parity % 2 != 0;
            }
        } else {
            return parity % 2 == 0;
        }
    }
    
    public Tiles(String format){
        configuration = new Configuration(format);
    }
    public int getSize(){
        return configuration.getSize();
    }
    public int getMoveCount(){
        return moves;
    }
    protected void incrementMoveCount(){
        moves++;
    }
    protected Configuration getConfiguration(){
        return configuration;
    }
}
