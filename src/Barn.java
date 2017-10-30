import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Barn implements Serializable {

    private int id;
    private String name;
    private List<Animal> animalList;

    public Barn(int id, String name){
        this.id = id;
        this.name = name;
        animalList = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void removeAnimal(Animal animal){
        animalList.remove(animal);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barn barn = (Barn) o;

        if (id != barn.id) return false;
        if (name != null ? !name.equals(barn.name) : barn.name != null) return false;
        return animalList != null ? animalList.equals(barn.animalList) : barn.animalList == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (animalList != null ? animalList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Barn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animalList=" + animalList +
                '}';
    }
}
