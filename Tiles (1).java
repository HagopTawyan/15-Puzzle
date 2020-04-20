public abstract class Tiles {
    public static final byte EMPTY = 0;
    private static int moves = 0;
    protected  abstract void moveImpl(Direction direction);
    public abstract byte getTile(int row,int col);
    public abstract void setTile(int row,int col, byte value);
    public abstract boolean isSolved();
    public abstract void findZero();
    private Configuration configuration;

    public Direction direction;
    
    public static boolean isSolvable(Configuration configuration) {
        configuration.createArr();
        byte parity = 0;
        byte gridWidth = (byte) Math.sqrt(configuration.getSize());
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

    public Tiles(String format)throws ConfigurationFormatException{
        configuration = new Configuration(format);
    }
    public Tiles(Configuration object) throws ConfigurationFormatException {
        configuration = new Configuration(object);
    }

    public void ensureValidity() throws InvalidConfigurationException {
        int size = configuration.getSize();
        byte[] array = new byte[size*size];
        int counter = 0;
        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++) {
                array[counter] = getTile(i, j);
                counter++;
            }
        }}
    public int getSize(){
        return configuration.getSize();
    }
    public int getMoveCount(){
        return moves;
    }
    protected void incrementMoveCount(){
        moves++;
    }
    protected void decrementMoveCount(){moves--;}
    protected Configuration getConfiguration(){
        return configuration;
    }
    public void move(Direction direction){
        moveImpl(direction);
    }
    
   

}
