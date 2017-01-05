package Builder;

/**
 * Created by Andrey on 14.12.2016.
 */
public class App {
    public static void main(String[] args) {
        PersonCreator pc = new PersonCreator();
        Person p1 = pc.createPerson("Вася", 10);
        Person p2 = pc.createPerson("Петя", 12);
        System.out.printf("%s= %s %s \n", p1, p1.name, p1.age);
        System.out.printf("%s= %s %s \n", p2, p2.name, p2.age);
    }
}

class Person {
    public String name = "";
    public int age = 0;
}
// промежуточный класс для использования билдера (нужен, например, для создания нескольких перегруженных методов (например, новорожденным не нужно указывать возраст))

class PersonCreator {
    Builder builder = new Builder();

    public Person createPerson(String name, int age) {
        builder.create();
        builder.setName(name);
        builder.setAge(age);
        return builder.getPerson();
    }
}

class Builder {

    private Person person;

    public void create() {
        person = new Person();
    }

    public void setName(String name) {
        this.person.name = name;
    }

    public void setAge(int age) {
        this.person.age = age;
        // если, например, возраст меньше 0, то нужно выбросить исключение!
    }

    public Person getPerson() {
        return this.person;
    }
}
