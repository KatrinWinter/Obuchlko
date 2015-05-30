/**
 * Created by e.makarycheva on 18.05.2015.
 */
public enum Sex {
    MAN("Мужик"), WOMAN("Бабища"), UNKNOWN("Пидор/Лесба");

    private String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return sex;
    }
}
