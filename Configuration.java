public class Configuration {
    private String data;

    public String toString() {
        return data;
    }

    public void build(int[][] tiles) {
    	
    	
        char[] chars = data.toCharArray();
        int x = 0;
        
        int y = 0;
        
        String initialNum = "";
        
        for (int i = 0; i < chars.length; i++) {
        	
            if (Character.isDigit(chars[i])) {

                initialNum = initialNum + Character.toString(chars[i]);
            }
            if (chars[i] == ':') {
                x = 0;
                y++;
            }
            
            if (chars[i] == ' ' && initialNum != "" || i == chars.length - 1) {
                int inputNum = Integer.parseInt(initialNum);
                tiles[x][y] = inputNum;
                if (inputNum == 0) {

                }
                initialNum = "";
                if (x < tiles.length - 1) {
                    x++;
                }
            }
        }

    }
    public Configuration(String input) {
        data = input;
    }

    public String getData() {
        return data;
    }

    public void build(byte[] tiles, int _SIZE) {
    	
        char[] chars = data.toCharArray();
        
        int x = 0;
        
        int y = 0;
        
        String initialNum = "";
        
        for (int i = 0; i < chars.length; i++) {
        	
            if (Character.isDigit(chars[i])) {

                initialNum = initialNum + Character.toString(chars[i]);
            }
            if (chars[i] == ':') {
                x = 0;
                y++;
            }
            if (chars[i] == ' ' && initialNum != "" || i == chars.length - 1) {

                int inputNum = Integer.parseInt(initialNum);
                
                int pos = y * 4 + x;
                
                tiles[y * _SIZE + x] = (byte) inputNum;
                
                initialNum = "";
                if (x < (tiles.length - 1)) {
                    x++;
                }
            }

        }
    }
    

}