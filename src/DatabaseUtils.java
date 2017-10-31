import java.io.*;
import java.util.List;

public class DatabaseUtils {


    private File file;

    public DatabaseUtils() {
        this.file = new File("C:\\asd\\zwierze.db");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void saveState(List<Barn> barnList) {
        ObjectOutputStream dataOutputStream = null;
        try {
              dataOutputStream = new ObjectOutputStream(new FileOutputStream(file));
              dataOutputStream.writeObject(barnList);
              dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Barn> readState(){
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(file));

            return (List<Barn>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
