public class ConfigurationFormatException extends Exception{
    public ConfigurationFormatException(){
        super("INVALID !!");
    }
    public ConfigurationFormatException(String message){
        super(message);
    }
}
