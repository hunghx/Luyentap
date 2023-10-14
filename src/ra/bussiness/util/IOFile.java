package ra.bussiness.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static final String DEPARTMENT_PATH = "src\\ra\\bussiness\\data\\department.txt";
    public static final String EMPLOYEE_PATH = "src\\ra\\bussiness\\data\\employee.txt";
    public static <T> List<T> readFromFile(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<T> list = new ArrayList<>();
        try{
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
        }catch (EOFException ex){

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }

    public static <T> void writeToFile(String path, List<T> list){
        FileOutputStream fos = null;
        ObjectOutputStream oos =null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        }catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
