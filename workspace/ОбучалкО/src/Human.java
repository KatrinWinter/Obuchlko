
public class Human {

    private Sex sex;
    private String name;
    private String surname;

    public Human(Sex sex, String name, String surname) {
        this.sex = sex;
        this.name = name;
        this.surname = surname;
    }

    public Human() {
    }

    public Human(Sex sex) {
        this.sex = sex;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getSexAsString() {
        return sex.toString();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }


}
