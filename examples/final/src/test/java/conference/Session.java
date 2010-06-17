package Conference;

 public class Session {
    public String Name;
    public String Presenter;
    public String Day;
    public String Time;
    public String Room;
    
    public Session(String name, String presenter, String day, String time, String room) {
        this.Name = name;
        this.Presenter = presenter;
        this.Day = day;
        this.Time = time;
        this.Room = room;
    }    
}