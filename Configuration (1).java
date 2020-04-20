package Puzzle15;

public class Configuration {
    private static int size;
    private String Data;
    private byte[] arr;

  
   
    public void initialize(Tiles tile){
        String[] format3 = Data.split("\\s");
        int k = 0;
        for (int i = 0;i < size;i++){
            for(int j = 0;j<size;){
                if(format3[k].equals("")) {
                    k++;
                    continue;
                }else {
                    int num = Integer.parseInt(format3[k]);
                    tile.setTile(i,j,(byte)num);
                    j++;
                    k++;
                }
            }
        }
    }

    public Configuration(String format){
        String[] format1 = format.split( "[:]");
        Data = "";
        size =Integer.parseInt(format1[0]);
        for (int i = 1; i< format1.length;i++){
            if (format1[i].equals(" "))
                i++;
            else
                Data += format1[i];
        }

    }
    
    public int getSize(){
        return size;
    }
    public String getData(){
        return Data;
    }
    public void createArr(){
        String[] format3 = Data.split("\\s");
        arr = new byte[format3.length];
        for (int i = 0;i < format3.length;i++ ){
            int num = Integer.parseInt(format3[i]);
            arr[i] = (byte)num;
        }
    }
    public byte[] getArr(){

        return arr;
    }
    public byte getArrElement(int i){
        return arr[i];
    }

}

