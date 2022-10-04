public class Main {
    public static void main(String[] args) {
        Person innerPersonBuilder = new Person.Builder()
                .setName("jon")
                .setSurname("Malkovich")
                .setAddress("Moscow")
                .build();

        var innerPersonChildBuilder = innerPersonBuilder.newInnerChildBuilder();
        var innerChild = innerPersonChildBuilder.setName("Patrik").build();

        try {
            var personWithMistake = new Person.Builder()
                    .setName("name")
                    .setSurname("surname")
                    .setAge(-5)
                    .build();
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }

        var outerPersonBuilder = new PersonBuilder()
                .setName("Donald")
                .setSurname("Trump")
                .setAge(136)
                .setAddress("NewYork")
                .build();

        var outerPersonChildBuilder = outerPersonBuilder.newOuterChildBuilder();
        var outerChild = outerPersonChildBuilder.setName("Kate").build();

        System.out.println(innerPersonBuilder);
        System.out.println(outerPersonBuilder);
        System.out.println(outerChild);
        System.out.println(innerChild);


    }
}
