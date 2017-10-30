import java.io.Serializable;
import java.util.Comparator;

public class Animal implements Comparable<Animal>, Serializable{

    public enum Type{
        COW, DUCK, HORSE;
    }

    private Type type;
    private int age;
    private boolean isVaccinated;

    public Animal(Type type, int age, boolean isVaccinated) {
        this.type = type;
        this.age = age;
        this.isVaccinated = isVaccinated;
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (isVaccinated != animal.isVaccinated) return false;
        return type == animal.type;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (isVaccinated ? 1 : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "type=" + type +
                ", age=" + age +
                ", isVaccinated=" + isVaccinated +
                '}';
    }


    public static class AgeComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal o1, Animal o2) {
            return Integer.compare(o1.getAge(), o2.getAge()) * -1;
        }
    }
}



