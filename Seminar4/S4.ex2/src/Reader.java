
public class Reader {
    private String name;
    private int number;
    private String faculty;
    private String birthday;
    private String phone;

    public Reader(String name, int number, String faculty, String birthday, String phone) {
        this.name = name;
        this.number = number;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Читатель - " + name + '\n' +
                "Номер читательского билета - " + number + '\n' +
                "Факультет - " + faculty + '\n' +
                "Дата рождения - " + birthday + '\n' +
                "Номер телефона - " + phone + '\n';
    }

    public void takeBook(int count) {
        System.out.println(this.name + " взял " + count + " книги");
    }

    public void takeBook(String ... name) {
        System.out.println(this.name + " взял книги ");
        for (String n : name) {
            System.out.print(name);
        }
    }

    public void takeBook(String name, Book ... books) {
        System.out.println(name + " взял книги ");
        for (Book b : books) {
            System.out.print(b);
        }
    }

    public void returnBook(int count) {
        System.out.println(this.name + " вернул " + count + " книги");
    }

    public void returnBook(String ... name) {
        System.out.println(this.name + " вернул книги ");
        for (String n : name) {
            System.out.print(name);
        }
    }

    public void returnBook(String name, Book ... books) {
        System.out.println(name + " вернул книги ");
        for (Book b : books) {
            System.out.print(b);
        }
    }


}