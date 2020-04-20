public class Configuration implements Comparable<Configuration>{
    private int size;
    private String Data;
    public byte[] arr;

   

    public Configuration(Configuration object) {
        this.size = object.getSize();
        this.Data = object.getData();
    }
    protected int getSize(){
        return size;
    }
    protected String getData(){
        return Data;
    }

    public byte getArrElement(int i){
        return arr[i];
    }
    
    protected Configuration(String format) throws ConfigurationFormatException{
        if (format.length()== 0)
            throw new ConfigurationFormatException("Specify a configuration please.");
        if(format.indexOf(":") < 0)
            throw new ConfigurationFormatException("Invalid configuration format : " +
                    " number of fields is not correct in configuration found 1.");
        String[] format1 = format.split("[:]");
        if(Character.isDigit(format.charAt(0)))
            size = Integer.parseInt(format1[0]);
        else
            throw new ConfigurationFormatException("Invalid configuration format: " +
                    " the size field as a number cannot interpret ('" + format1[0] + "') given.");
        Data = "";
            size = Integer.parseInt(format1[0]);
            for (int i = 1; i < format1.length; i++) {
                if (format1[i].equals(""))
                    i++;
                else
                    Data += format1[i];
            }
    }
    
    public void createArr(){
        String[] format3 = Data.split("\\s");
        arr = new byte[size * size];
        int i = 0;
        for (int k = 0;k < format3.length;){
            if (format3[k].equals("")){
                k++;
                continue;
            }
            int num = Integer.parseInt(format3[k]);
            arr[i] = (byte)num;
            i++;
            k++;
        }
    }
    public void initialize(Tiles tile)throws InvalidConfigurationException {
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
    
    @Override
    public int compareTo(Configuration o) {
        if (size > o.size)
            return 1;
        else if (size < o.size)
            return -1;
        else
            return 0;
    }
    public String toString(){
        return (size + " : " + Data);
    }
}

