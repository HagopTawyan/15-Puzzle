import java.util.Scanner;
public class SpiralMatrix{
	public static void main(String[] args) {
		System.out.println("Enter a value please");
		
		Scanner Scanner = new Scanner(System.in);
		
		int num = Scanner.nextInt();
		
		int[][] Spiral = new int[num][num];
		int current = num*num;
		int Column = 0;
		int Row = 0;
		int MaxCol = num - 1;
		int MaxRow = num - 1;
		int i;
		
		while(current>= 1) {
			
			for(i = Column; i<=MaxCol; i++) {
				Spiral[Row][i] = current;
				
				current--;
			}
			
			for (i = Row + 1; i <= MaxRow; i++) { 
             
                Spiral[i][MaxCol] = current; 
                 
                current--; 
            } 
             
            for (i = MaxCol - 1; i >= Column; i--) {
            
                Spiral[MaxRow][i] = current;
                             
                current--;
            }
             
            for (i = MaxRow - 1; i >= Row + 1; i--) { 
            
                Spiral[i][Column] = current;
                 
                current--;
            }
             
            Column++;
            Row++;
            MaxCol--;            
            MaxRow--;
        }
		
		for (i = 0; i < Spiral.length; i++) {
		
            for (int j = 0; j < Spiral.length; j++) {
            
                System.out.print(Spiral[i][j]+ "\t");
            }
             
            System.out.println();
        }
			
	}
}
