package exercises.data;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
//Implemented serializable interface to convert DataObject2 into byte stream 
public class DataObject2 implements Serializable
{
    //Made sourceIdentifier transient to not be serialized when it is persisted to stream of bytes
    private transient String sourceIdentifier;
    private String property1;
    private int property2;

    /**
     * @return the sourceIdentifier
     */
    public String getSourceIdentifier()
    {
        return sourceIdentifier;
    }

    /**
     * @param sourceIdentifier the sourceIdentifier to set
     */
    public void setSourceIdentifier(String sourceIdentifier)
    {
        this.sourceIdentifier = sourceIdentifier;
    }

    /**
     * @return the property1
     */
    public String getProperty1()
    {
        return property1;
    }

    /**
     * @param property1 the property1 to set
     */
    public void setProperty1(String property1)
    {
        this.property1 = property1;
    }

    /**
     * @return the property2
     */
    public int getProperty2()
    {
        return property2;
    }

    /**
     * @param property2 the property2 to set
     */
    public void setProperty2(int property2)
    {
        this.property2 = property2;
    }
}
