import java.util.Scanner;

public class Puzzle15Array {
	
    public static final int SIZE = 4;
    
    public static final int EMPTY = 0;
    
    private byte[] tiles;
    
    private int emptyPos;
    
    private Configuration configuration;


    //we should put the constructor as public we are calling it from the Puzzle15ArrayDemo
    public Puzzle15Array(String input) {
    	
        tiles = new byte[SIZE * SIZE];
        configuration = new Configuration(input);

        configuration.build(tiles, SIZE);
        setUpEmptyPosition();
        
    }
    
    public byte getTile(int pos) {
    
        if(pos >= 0 && pos < SIZE * SIZE ) 
        
            return tiles[pos];
        
        else {
        
            System.out.println("Error: position out of the board");
            
            System.exit(0);
            
            return 0;
        }
    }
    public void setTile(int pos, byte value)
    {
        if(pos > 0 && pos < SIZE * SIZE )
        {
            tiles[pos] = value;
        }
        else
        {
            System.out.println("Error: position out of the board");
            
            System.exit(0);
        }
    }
    //we define this as a private method because called from this class only
    private void move(char direction)
    {
        int x = 0;
        
        int y = 0;
        
        byte tempNumber = 0;
        
        switch (direction)
        {
            case 'U':
                y = -1;
                break;
            case 'R':
                x = -1;
                break;
            case 'D':
                y = 1;
                break;
            case 'L':
                x = 1;
                break;

        }
        if(emptyPos + y * SIZE >= 0 && emptyPos + y  * SIZE < SIZE*SIZE && emptyPos + y >= 0 && emptyPos + y < SIZE*SIZE)
        {
            tempNumber = getTile(emptyPos + y * SIZE + x);
            setTile(emptyPos, tempNumber);
            byte zero = 0;
            setTile(emptyPos + y * SIZE + x, zero);
            emptyPos += x;
            emptyPos += y * SIZE;
        }

    }
    //The rest of the methods are private because they are called only from this class
    private void print()
    {
        for (int y = 0; y < SIZE; y++) {
        	
            System.out.println();
            
            System.out.println("--------------------");
            
            System.out.println();
            
            for (int  x = 0; x < SIZE; x++) {
            	
                if(Byte.toString(getTile(y * SIZE + x)).length() == 1){
                	
                    System.out.print(" ");
                }
                System.out.print(" " + getTile(y * SIZE + x) + " |");
            }

        }
    }
    //we are putting this public because we are calling from demo 

    public void play() {

        Scanner s = new Scanner(System.in);
        
        print();
        
        if(!win()) {
        
            char inj = s.next().charAt(0);
            
            move(inj);
            
            play();
        }
        else
        
            System.out.println(" win ");
        


    }
   
    
    private void setUpEmptyPosition() {

        for (int x = 0; x < SIZE ; x++) {
        	
            for (int y = 0; y < SIZE; y++) {
            	
            	
                if(getTile(y * SIZE + x) == 0) {
                
                    emptyPos = y * SIZE + x;
                }
            }
        }
    }
    private boolean win()
    {
        byte num = 1;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if(getTile(x * SIZE + y) == num)
                {
                    num++;
                    continue;
                }
                else if(num >= 15)
                
                    return true;
                
                else
                {
                    System.out.println(num);
                    return false;
                }

            }
        }
        return true;
    }
}