package partII;
import java.util.Date;

public class LogEntry {

    private Date date;
    private String severity;
    private String source;
    private String message;
    private String[] Arr;

    public LogEntry(String log) {
        this.Arr = log.split("|");
    }

    //Setters
    private void setDate(){
        this.date = new Date(Long.parseLong(Arr[0]));
    }

    private void setSeverity(String severity){
        this.severity = severity;
    }

    private void setSource(String source){
        this.source = source;
    }

    private void setMessage(String message){
        this.message = message;
    }

    //Getters


}
