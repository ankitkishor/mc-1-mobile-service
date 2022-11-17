package com.jap.collectiondemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MobileStore {


    private List<Mobile> allMobiles;
    private String record = "";
    private String splitBy = ",";
    int count=0;
    public MobileStore()
    {
        allMobiles = new ArrayList<>();
readMobileData("mobile.csv");
    }

    //Write logic to read the fileName that is "mobile.csv"
    //read all the lines one by one
    //Create Mobile class object and store data from file in the respective attributes of Mobile class
    // ex - Store brandName - Samsung in  mobile.setBrandName(brandName);
    //add mobile object in the List object and return the List
    //handle all the exceptions
    public List<Mobile> readMobileData(String fileName) {

        try (FileReader fileReader=new FileReader(fileName);
            BufferedReader buffer=new BufferedReader(fileReader)){
            String line= buffer.readLine();
            while((line= buffer.readLine())!=null){
                String[] value=line.split(",");
                Mobile mobile=new Mobile();
                mobile.setBrandName(value[0]);
                mobile.setModelName(value[1]);
                mobile.setCost(Double.parseDouble(value[2]));
                mobile.setScreenSize(value[3]);
                mobile.setBatteryLife(value[4]);
                mobile.setStorageSpace(value[5]);
                mobile.setCameraPixels(Integer.parseInt(value[6]));
                allMobiles.add(mobile);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allMobiles;
    }
        //Iterate the List created in the above method and retrieve the bandName
    //Return the List with specific Mobile having brandName coming from method parameter
    public List<Mobile> findPhoneByBrand(String brandName)
    {
        List<Mobile> mobilesByBrand = new ArrayList<>();

        Iterator<Mobile> iterator=allMobiles.iterator();
        Mobile mobile;
        while(iterator.hasNext())
        {
            if((mobile=iterator.next()).getBrandName().equals(brandName))
            {
                mobilesByBrand.add(mobile);
            }
        }

          return mobilesByBrand;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose cost is more than $500
    public List<Mobile> findPhoneCostMoreThan$500() {
        List<Mobile> mobilesMoreThan500 = new ArrayList<>();
        Iterator<Mobile> iterator=allMobiles.iterator();
        Mobile mobile;
        while(iterator.hasNext())
        {
            if((mobile=iterator.next()).getCost()>500)
            {
                mobilesMoreThan500.add(mobile);
            }
        }



        return mobilesMoreThan500;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose Pixel is more than 12MP
    public List<Mobile> findPhonePixelMoreThan12MP()
    {
        List<Mobile> mobilesMoreThan12MP = new ArrayList<>();
        Iterator<Mobile> iterator=allMobiles.iterator();
        Mobile mobile;
        while(iterator.hasNext())
        {
            if((mobile=iterator.next()).getCameraPixels()>12)
            {
                mobilesMoreThan12MP.add(mobile);
            }
        }


        return mobilesMoreThan12MP;
    }

    public static void main(String[] args) {
        MobileStore store=new MobileStore();
//        System.out.println(store.readMobileData("mobile.csv"));
        System.out.println(store.findPhoneByBrand("Samsung"));
//        System.out.println(store.findPhoneCostMoreThan$500());
//        System.out.println(store.findPhonePixelMoreThan12MP());
    }

}

