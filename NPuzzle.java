package Puzzle15;

import java.util.Scanner;

public class NPuzzle {
    private Tiles tiles;

    public NPuzzle(Tiles tiles){
        this.tiles = tiles;
    }
    public void play() {
        System.out.println();
        print();

        Scanner keyboard = new Scanner(System.in);

        do {
            tiles.findZero();
            System.out.println();
            System.out.println("Enter a letter: \n" +
                    "choose between (W,A,S,D and Q for exit)\n" +
                    "Enter: ");

            char input = Character.toUpperCase(keyboard.next().charAt(0));

            if (input == 'Q') {
                System.out.println("You have entered the letter Q .");
                System.exit(0);
            }
            if (input == 'W')
                tiles.moveImpl(Direction.UP);
            if (input == 'S')
                tiles.moveImpl(Direction.DOWN);
            if (input == 'A')
                tiles.moveImpl(Direction.LEFT);
            if (input == 'D')
                tiles.moveImpl(Direction.RIGHT);
            print();
            System.out.println("Move count is + " + tiles.getMoveCount());

        } while (!(tiles.isSolved()));
        System.out.println("Congrats you have finished the game. ");
    }
  

    public static void main(String[] args){
        NPuzzle game = new NPuzzle(new MatrixTiles("3: 1 2 3 : 4 5 6 : 7 0 8 "));
        game.play();
    }
    
    public void print(){
        for (int i = 0; i < tiles.getConfiguration().getSize(); i++) {
            System.out.println("---------------------");
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
        System.out.println("---------------------");
    }
}
