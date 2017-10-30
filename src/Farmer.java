import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Farmer {

    private List<Barn> barnList;

    public Farmer(){

    }

    public boolean addAnimalToBarn(Animal animal, int barnId){
        for (Barn barn : barnList) {
            if(barn.getId() == barnId){
                barn.addAnimal(animal);
                return true;
            }
        }
        return false;
    }

    public boolean removeAnimalFromBarn(Animal animalArg){
        for (Barn barn : barnList) {
            for (Animal animal : barn.getAnimalList()) {
                if(animal.equals(animalArg)){
                    barn.getAnimalList().remove(animalArg);
                    return true;
                }
            }
        }
        return false;
    }


    public void addBarn(String name) {
        Random random = new Random();
        //todo logika sprawdzania powtorzonego id
        barnList.add(new Barn(Math.abs(random.nextInt()), name));
    }

    public void removeBarn(int barnId){
        for (Barn barn : barnList) {
            if(barn.getId() == barnId){
                barnList.remove(barn);
            }
        }
    }

    public List<Animal> get5OldestAnimals() {
        List<Animal> fullAnimalList = new ArrayList<>();

        for (Barn barn : barnList) {
            fullAnimalList.addAll(barn.getAnimalList());
        }

        Collections.sort(fullAnimalList, new Animal.AgeComparator());
        //todo masz za malo zwierzat, obsluga
        return fullAnimalList.subList(0, 5);
    }

    




}
