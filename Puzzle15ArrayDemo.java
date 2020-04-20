public class Puzzle15ArrayDemo {
    public static void main(String[] args)
    {
        
        Puzzle15Array player = new Puzzle15Array(args[0]);

        player.play();
    }
}// if we dont put the "" when we are going to give arguments, we could have a lot of strings and cant gice the args[0]