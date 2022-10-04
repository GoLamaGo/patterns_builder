import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.address = builder.address;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean hasAge() {
        return !Objects.isNull(age);
    }

    public boolean hasAddress() {
        return !Objects.isNull(address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newOuterChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(1)
                .setAddress(this.address);
    }

    public Builder newInnerChildBuilder() {
        return new Builder()
                .setSurname(this.surname)
                .setAge(1)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return String.format("""
                        Name: %s
                        Surname: %s
                        Age: %d
                        Address: %s
                        """,
                name,
                surname,
                age,
                address);
    }

    @Override
    public int hashCode() {
        return 31 * age + name.hashCode() + surname.hashCode() + address.hashCode();
    }

    public static class Builder {
        private String name;
        private String surname;
        private Integer age;
        private String address;

        public Builder() {
        }

        public Person build() {
            if (Objects.isNull(name)) throw new IllegalStateException("Обязательно должно быть указано имя");
            if (Objects.isNull(surname)) throw new IllegalStateException("Обязательно должна быть указана фамилия");
            if (!Objects.isNull(age))
                if (age <= 0) throw new IllegalArgumentException("Возраст должен быть больше нуля");
            return new Person(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
    }
}
