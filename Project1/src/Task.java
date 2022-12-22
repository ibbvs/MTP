import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private static int counter = 0;
    private int id;
    private String startDate;
    private String endDate;
    private String title;
    private String description;



    public Task( String title, String description, String endDate) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.startDate = new SimpleDateFormat("dd.MM.yyyy  hh:mm").format(new Date());
        this.endDate = endDate;
    }

    public Task() {
    }

    public String getStartDate() {
        return startDate;
    }


    public String getEndDate(){
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = String.valueOf(endDate);
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