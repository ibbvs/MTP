import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private static int counter = 0;
    private int id;
    private String startDate;
    private String endDate;
    private String title;
    private String description;

    private boolean flag;


    public Task( String title, String description, String endDate, boolean flag) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.startDate = new SimpleDateFormat("dd.MM.yyyy  hh:mm").format(new Date());
        this.endDate = endDate;
        this.flag = flag;
    }

    public Task() {
    }

    public String getStartDate() {
        return startDate;
    }


    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag() {
        return flag;
    }



    @Override
    public String toString() {
        return "Задание\n" +
                "id - " + id +
                "\nЦель - " + title +
                "\nОписание - " + description +
                "\nДата создания - " + startDate +
                "\nДата выполнения - " + endDate + ";\n\n\n";
    }
}