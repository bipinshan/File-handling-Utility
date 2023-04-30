package com.bipin.filehandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public static void createNewFile(String filePath)
    {
        if(filePath==null) {
            System.out.println("File Path is null.");
            return;
        }
        try {
            File file=new File(filePath);
            file.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println("Error occurred while creating new file: "+ filePath);
            e.printStackTrace();
        }
    }

    public static void writeToFile(List<Integer> numbers, String filePath)
    {
        if(numbers ==null)
        {
            System.out.println("Numbers List is null.");
            return;
        }
        if(filePath==null) {
            System.out.println("File Path is null.");
            return;
        }
        try
        {
            FileWriter fileWriter=new FileWriter(filePath);
            for(int number : numbers) {
                fileWriter.write(String.valueOf(number));
                fileWriter.write("\n");
            }
            fileWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Error while writting numbers to file: "+filePath);
            e.printStackTrace();
        }
    }

    public static List<Integer> readFromFile(String filePath)
    {
        List<Integer> numbers=new ArrayList<>();
        if(filePath==null) {
            System.out.println("File Path is null.");
            return null;
        }
        try
        {
            FileReader fileReader=new FileReader(filePath);
            Scanner sc=new Scanner(fileReader);
            while(sc.hasNextLine())
            {
                numbers.add(Integer.parseInt(sc.nextLine()));
            }
        }
        catch (IOException e)
        {
            System.out.println("Error while reading numbers from file: "+filePath);
            e.printStackTrace();
        }
        return numbers;
    }
}
