import java.util.Objects;
import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public Person build() {
        if(Objects.isNull(name)) throw new IllegalStateException("Обязательно должно быть указано имя");
        if(Objects.isNull(surname)) throw new IllegalStateException("Обязательно должна быть указана фамилия");
        if (!Objects.isNull(age))
            if (age <= 0) throw new IllegalArgumentException("Возраст должен быть больше нуля");
        return new Person(this);
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }
}