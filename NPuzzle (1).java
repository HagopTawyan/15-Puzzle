import java.io.IOException;
import java.util.*;
import java.io.*;


public class  NPuzzle {
    public Tiles tiles;
    private ConfigurationStore store;
    private ArrayList<Tiles> cachedTiles = new ArrayList<>();

    public NPuzzle(Tiles tiles,ConfigurationStore theStore){
        this.tiles = tiles;
        this.store = theStore;
    }
    public NPuzzle(ConfigurationStore theStore) {
        store = theStore;
    }
    public NPuzzle(Tiles theTiles){
        tiles = theTiles;
    }
   
    public void play() throws IOException, ConfigurationFormatException, InvalidConfigurationException, CloneNotSupportedException {
        String response = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please select a configuration to play (l to list):");
        while (!response.equalsIgnoreCase("q")) {
            response = in.readLine();
            System.out.println(response);
            if (response.equals("LEFT") || response.equals("RIGHT")
                    || response.equals("UP") || response.equals("DOWN")) {
                if (tiles == null) {
                    System.out.println("Please select a configuration to play (l to list):");
                }
                else {
                    tiles.findZero();
                    copyTiles(false);
                    tiles.moveImpl(Direction.valueOf(response));
                    print();
                    if (!tiles.isSolved()) {
                        System.out.println("Please make a move by inputting UP, DOWN, LEFT, RIGHT;");
                        System.out.println("or stop the game by inputting q: ");
                    }
                    else {
                        System.out.println("You solved the puzzle!");
                        tiles = null;
                        System.out.println("Please select a configuration to play (l to list):");
                    }
                }
            }
            else if (response.equals("l")) {
                ArrayList<Configuration> configs = store.getConfigurationsSizeSorted();
                int i = 0;
                for (Configuration c : configs) {
                    if (i != 23){
                    System.out.println(i + " " + c.getSize() + " (" + c.getData() + ")");
                    i++;}
                }
            }
            else if (response.startsWith("c")) {
                ArrayList<Configuration> configs = store.getConfigurationsSizeSorted();
                int num = Integer.parseInt(response.substring(1,response.length()));
                Configuration conf;
                conf = configs.get(num);
                conf.createArr();
                tiles = new ArrayTiles(conf.toString());
                print();
                if (!tiles.isSolvable(conf)) {
                    System.out.println("The game is not solvable. Quitting.");
                    continue;
                }
                if (!tiles.isSolved()) {
                    System.out.println("Please make a move by inputting UP, DOWN, LEFT, RIGHT;");
                    System.out.println("or stop the game by inputting q: ");
                }
                else {
                    System.out.println("You solved the puzzle!");
                    tiles = null;
                    System.out.println("Please select a configuration to play (l to list):");
                }
            }
            else if (response.equals("b")){

            }
            else if (response.equals("f")){

            }
        }
    }
    
    private void print(){
        for (int i = 0; i < tiles.getConfiguration().getSize(); i++) {
            for (int k = 0; k < tiles.getSize(); k++ )
                System.out.print("-----");
            System.out.println("-");
            for (int j = 0; j <  tiles.getConfiguration().getSize(); j++) {
                if (tiles.getTile(i,j) == tiles.EMPTY) {
                    System.out.print("|");
                    System.out.print("    ");
                } else {
                    System.out.print("|");
                    System.out.printf(" %-3s", tiles.getTile(i,j));
                }
            }
            System.out.println("|");
        }
        for (int k = 0; k < tiles.getSize(); k++ )
            System.out.print("-----");
        System.out.println("-");
    }
    
    public class Tiles2 implements Cloneable{
        private Tiles tiles1;
        @Override
        public Object clone() {
            try {
                Tiles2 copy = (Tiles2)super.clone();
                return super.clone();
            }catch (CloneNotSupportedException e){
                return null;
            }
        }
    }
    
    private Tiles copyTiles(boolean useCloning) throws CloneNotSupportedException, InvalidConfigurationException, ConfigurationFormatException {
        // TODO later
            Tiles tile1 = tiles;
            cachedTiles.add(tile1);
            return null;
        }

    public static void main(String args[]) {

        try {
            ConfigurationStore cs = new ConfigurationStore("text.txt");
            NPuzzle np = new NPuzzle(cs);
            np.play();

        }
        catch (IOException ioe) {
            System.out.println("Failed to load configuration store");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

//https://bit.ly/2Mgr126