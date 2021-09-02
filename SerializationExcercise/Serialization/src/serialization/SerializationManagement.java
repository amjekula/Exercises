package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Administrator
 */
public class SerializationManagement
{
    //Using a relative path 
    private static final String FILEFORMAT = System.getProperty("user.dir") + "\\%1$s.dat";
    
    public void Serialize(String dataIdentifier, Object dataObject)
    {
        try {
            FileOutputStream file = new FileOutputStream(String.format(FILEFORMAT, dataIdentifier));
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(dataObject);
            
        } catch (FileNotFoundException ex) {
            //Showing which class has an thrown an exception and display the defination of the exception
            System.out.println("Serialize: FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            //Showing which class has an thrown an exception and display the defination of the exception
            System.out.println("Serialize: IOException " + ex.getMessage());
        }
        
    }
    
    public Object Deserialize(String dataIdentifier) throws IOException, ClassNotFoundException 
    {
        ObjectInputStream in = null;
        try {
            FileInputStream file = new FileInputStream(String.format(FILEFORMAT, dataIdentifier));
            in = new ObjectInputStream(file);
        
        } catch (FileNotFoundException ex) {
            //Showing which class has an thrown an exception and display the defination of the exception
            System.out.println("Deserialize: FileNotFoundException " + ex.getMessage());
        } catch (IOException ex) {
            //Showing which class has an thrown an exception and display the defination of the exception
            System.out.println("Deserialize: IOException " + ex.getMessage());
        }
        return in.readObject();
    }
}
