package homework12.task2;

import java.io.*;

public class Cloner {

    /**
     * @throws CloningException
     */

    public static  <T extends Serializable> T clone(T value) {
        T clonedValue;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try(ObjectOutputStream obj_out = new ObjectOutputStream(output)){
            obj_out.writeObject(value);
            byte[] object_bytes = output.toByteArray();

            ByteArrayInputStream input = new ByteArrayInputStream(object_bytes);
            ObjectInputStream obj_in = new ObjectInputStream(input);
            clonedValue = (T) obj_in.readObject();
        } catch (IOException | ClassNotFoundException e) { throw new CloningException(e.getMessage(), e); }

        return clonedValue;
    }
}

