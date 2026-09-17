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

    public void setSeverity(){
        this.severity = Arr[1];
    }

    public void setSource(){
        this.source = Arr[2];
    }

    public void setMessage(){
        this.message = Arr[3];
    }

    //Getters
    public Date getDate(){
        return date;
    }

    public String getSeverity() {
        return severity;
    }

    public String getSource(){
        return source;
    }

    public String getMessage() {
        return message;
    }
}
