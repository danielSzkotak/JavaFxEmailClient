package com.example.javafxemailclient.controller.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceAccess {

    private String VALID_ACCOUNTS_LOCATION = System.getProperty("user.home") + File.separator + "validAccounts.ser";
    private Encoder encoder = new Encoder();

    public List<VaildAccount> loadFromPersistence(){
        List<VaildAccount> resultList = new ArrayList<VaildAccount>();
        try {
            FileInputStream fileInputStream = new FileInputStream(VALID_ACCOUNTS_LOCATION);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<VaildAccount> persistedList = (List<VaildAccount>) objectInputStream.readObject();
            decodePassword(persistedList);
            resultList.addAll(persistedList);
        } catch (Exception e){
            e.printStackTrace();
        }
        return resultList;
    }

    private void decodePassword(List<VaildAccount> persistedList) {

        for (VaildAccount vaildAccount: persistedList){
            String originalPassword = vaildAccount.getPassword();
            vaildAccount.setPassword(encoder.decode(originalPassword));
        }
    }

    private void encodePassword(List<VaildAccount> persistedList) {

        for (VaildAccount vaildAccount: persistedList){
            String originalPassword = vaildAccount.getPassword();
            vaildAccount.setPassword(encoder.encode(originalPassword));
        }
    }

    public void saveToPersistence(List<VaildAccount> validAccounts){
        try {
            File file = new File(VALID_ACCOUNTS_LOCATION);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            encodePassword(validAccounts);
            objectOutputStream.writeObject(validAccounts);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
