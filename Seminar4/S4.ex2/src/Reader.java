// Так как в задании не написано что надо хранить взятые книги, я не создавал массив, куда можно было заносить или удалять взятые книги.
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

    public void takeBook(String... names) {
        System.out.printf("%s взял книги: ", this.name);
        for (int i=0; i < names.length-1; i++) {
            System.out.printf("%s, ", names[i]);
        }
        System.out.println(names[names.length-1] + '.');
    }

    public void takeBook(Book ... books) {
        System.out.printf("%s взял книги: ", this.name);
        for (int i=0; i < books.length-1; i++) {
            System.out.printf("'%s', ", books[i].getBookName());
        }
        System.out.printf("'%s'.\n", books[books.length - 1].getBookName());
    }

    public void returnBook(int count) {
        System.out.println(this.name + " вернул " + count + " книги");
    }

    public void returnBook(String ... names) {
        System.out.printf("%s взял книги: ", this.name);
        for (int i=0; i < names.length-1; i++) {
            System.out.printf("%s, ", names[i]);
        }
        System.out.println(names[names.length-1] + '.');
    }

    public void returnBook(String name, Book ... books) {
        System.out.printf("%s взял книги: ", this.name);
        for (int i=0; i < books.length-1; i++) {
            System.out.printf("'%s', ", books[i].getBookName());
        }
        System.out.printf("'%s'.\n", books[books.length - 1].getBookName());
    }
}