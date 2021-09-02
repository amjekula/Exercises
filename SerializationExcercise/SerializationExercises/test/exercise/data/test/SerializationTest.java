/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise.data.test;

import exercises.data.DataObject1;
import exercises.data.DataObject2;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import serialization.SerializationManagement;

/**
 *
 * @author A. Mjeks
 */
public class SerializationTest {

    private final SerializationManagement sm = new SerializationManagement();
    private ArrayList<DataObject1> dataObjects = new ArrayList<>();

    @Before
    public void setUp() {
        for (int x = 0; x < 100; x++) {
            DataObject1 do1 = new DataObject1();
            dataObjects.add(do1);
            do1.setProperty1(String.valueOf(x));
            do1.setProperty2(x);
            do1.setComplexTypeProperty(new DataObject2());
            do1.getComplexTypeProperty().setSourceIdentifier("Serialized");
            do1.getComplexTypeProperty().setProperty1(String.valueOf(x));
            do1.getComplexTypeProperty().setProperty2(x);
        }
        sm.Serialize("TestData", dataObjects);
    }

    public ArrayList deserializeData() {
        dataObjects = null;
        try {
            dataObjects = (ArrayList) sm.Deserialize("TestData");

        } catch (IOException ex) {
            //Showing which class has an thrown an exception and display the defination of the exception
            System.out.println("deserializeData: IOException " + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            //Showing which class has an thrown an exception and display the defination of the exception
            System.out.println("deserializeData: ClassNotFoundException " + ex.getMessage());
        }
        return dataObjects;
    }

    @Test
    public void simpleSerializationTest() {
        //Making loop length less than the size of the arraylist
        for (int x = 0; x < deserializeData().size(); x++) {
            DataObject1 do1 = dataObjects.get(x);

            //Display data
            System.out.println("property1 = " + do1.getProperty1() + " property2 = " + do1.getProperty2() + " sourceIdentifier = "
                    + do1.getComplexTypeProperty().getSourceIdentifier() + " ComplexTypeProperty1 = "
                    + do1.getComplexTypeProperty().getProperty1() + " ComplexTypeProperty2 =  "
                    + do1.getComplexTypeProperty().getProperty2());
            
            //Asserts
            assertNotNull(do1.getProperty1());
            assertEquals(do1.getProperty1(), String.valueOf(x));

            assertNotNull(do1.getProperty2());
            assertEquals(do1.getProperty2(), x);

            assertNotEquals(do1.getComplexTypeProperty().getSourceIdentifier(), "Serialized");
            assertNull(do1.getComplexTypeProperty().getSourceIdentifier());

            assertNotNull(do1.getComplexTypeProperty().getProperty1());
            assertEquals(do1.getComplexTypeProperty().getProperty1(), String.valueOf(x));

            assertNotNull(do1.getComplexTypeProperty().getProperty2());
            assertEquals(do1.getComplexTypeProperty().getProperty2(), x);
        }
    }
}
