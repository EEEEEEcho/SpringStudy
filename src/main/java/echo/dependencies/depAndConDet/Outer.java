package echo.dependencies.depAndConDet;

import echo.dependencies.depAndConDet.Person;

public class Outer {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Outer{" +
                "person=" + person +
                '}';
    }
}
