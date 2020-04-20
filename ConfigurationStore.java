import java.io.*;
import java.net.*;
import java.util.*;
public class ConfigurationStore {
	
	 private void loadFromURL(String url) throws IOException ,ConfigurationFormatException{
	        URL destination = new URL(url);
	        URLConnection conn = destination.openConnection();
	        Reader r = new InputStreamReader(conn.getInputStream());
	        load(r);
	    }
	    private void loadFromDisk(String filename) throws IOException,ConfigurationFormatException {
	        Reader r = new FileReader(filename);
	        load(r);
	    }
	    public void printConf(){
	        for (int i = 0;i < configs.size(); i++){
	            if (configs.get(i) == null)
	                break;
	            System.out.println(configs.get(i));
	        }
	    }

   
    public ConfigurationStore(Reader source) throws IOException,ConfigurationFormatException {
        load(source);
    }
    private void load(Reader r) throws IOException, ConfigurationFormatException {
        BufferedReader b = new BufferedReader(r);
        String line = b.readLine();
        int counter = 0;
        configs.add(counter,new Configuration(line));
        counter++;
        while (line != null) {
            line = b.readLine();
            if (line != null){
                configs.add(counter,new Configuration(line));
                counter++;
            }
        }
        b.close();

    }
   
    public ArrayList<Configuration> getConfigurations() {
        int i = 0;
        for (;i<configs.size();i++){
            if (configs.get(i) == null) {
                break;
            }
        }
        return configs;
    }
    public ArrayList<Configuration> getConfigurationsSizeSorted(){
        for (int i = 1;i < configs.size();i++){
            int comp = configs.get(i).compareTo(configs.get(i - 1));
            if (comp < 0){
                Configuration tmp = configs.get(i);
                configs.set(i,configs.get(i-1));
                configs.set(i-1,tmp);
            }
        }
        return configs;
    }
    
    private ArrayList<Configuration> configs = new ArrayList<>();
    public ConfigurationStore(String source) throws IOException, ConfigurationFormatException {
        if (source.startsWith("http://") || source.startsWith("https://")) {
            loadFromURL(source);
        }
        else {
            loadFromDisk(source);
        }
    }
    public static void main(String[] args) throws IOException, ConfigurationFormatException {
        ConfigurationStore p = new ConfigurationStore("https://bit.ly/32OCUC6");
        p.getConfigurationsSizeSorted();
        p.printConf();
    }
}
// text.txt   "https://bit.ly/32OCUC6"