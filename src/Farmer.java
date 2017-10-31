import java.util.*;

public class Farmer {

    public List<Barn> barnList;
    private DatabaseUtils databaseUtils;


    public Farmer(){
        databaseUtils = new DatabaseUtils();
        barnList = databaseUtils.readState();
        if(barnList == null){
            barnList = new ArrayList<>();
        }
    }

    public void save() {
        databaseUtils.saveState(barnList);
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

    public boolean removeAnimalFromBarn(Animal.Type type){
        for (Barn barn : barnList) {
            for (Animal animal : barn.getAnimalList()) {
                if(animal.getType().equals(type)){
                    barn.getAnimalList().remove(animal);
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


    public List<Animal> get5YoungestAnimals() {
        List<Animal> fullAnimalList = new ArrayList<>();

        for (Barn barn : barnList) {
            fullAnimalList.addAll(barn.getAnimalList());
        }

        Collections.sort(fullAnimalList, new Animal.AgeComparator());
        //todo masz za malo zwierzat, obsluga
        return fullAnimalList.subList(fullAnimalList.size()-5, fullAnimalList.size());
    }

    public Barn getBarnWithMaxCountOfAnimals(){
        int maxCount = 0;
        Barn maxBarn = null;
        for (Barn barn : barnList) {
            if(barn.getAnimalList().size() > maxCount){
                maxCount = barn.getAnimalList().size();
                maxBarn = barn;
            }
        }
        return maxBarn;
    }

    public Animal.Type getMaxTypeOfAnimal(){
        Map<Animal.Type, Integer> map = new HashMap<>();

        for (Barn barn : barnList) {
            for (Animal animal : barn.getAnimalList()) {
                if(map.containsKey(animal.getType())){
                    map.put(animal.getType(), map.get(animal.getType()) + 1);
                }else{
                    map.put(animal.getType(), 1);
                }
            }
        }

        int max = 0;
        Animal.Type type = null;
        for (Map.Entry<Animal.Type, Integer> typeIntegerEntry : map.entrySet()) {
            if(max < typeIntegerEntry.getValue()){
                max = typeIntegerEntry.getValue();
                type = typeIntegerEntry.getKey();
            }
        }
        return type;
    }

    public List<Animal> getVaccinatedAnimals() {
        List<Animal> animalsVac = new ArrayList<>();
        for (Barn barn : barnList) {
            for (Animal animal : barn.getAnimalList()) {
                if(animal.isVaccinated()){
                    animalsVac.add(animal);
                }
            }
        }
        return animalsVac;
    }


    







}
