import com.bipin.filehandling.Helper;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void  main(String[] args)
    {
        System.out.println("File Handling Utility started!");
        if(args.length!=3)
        {
            System.out.println("Please specify three file names in args. Example: main.txt even.txt odd.txt");
            return;
        }
        // I would like to first create new file
        for(String file : args)
        {
            System.out.println("Creating new file: "+file);
            Helper.createNewFile(file);
        }

        List<Integer> numbers=new ArrayList<>();
        for(int i=0;i<100;i++)
        {
            numbers.add(i);
        }

        System.out.println("Writting numbers to first file: "+args[0]);
        Helper.writeToFile(numbers, args[0]);

        List<Integer> numbersFromFile=Helper.readFromFile(args[0]);

        List<Integer> evenNumbers=new ArrayList<>();
        List<Integer> oddNumbers=new ArrayList<>();
        System.out.println("Finding Even & Odd numbers");
        for(int number: numbersFromFile)
        {
            if(number%2==0)
            {
                evenNumbers.add(number);
            }
            else {
                oddNumbers.add(number);
            }
        }

        System.out.println("Writting EVEN Numbers to file: "+ args[1]);
        Helper.writeToFile(evenNumbers, args[1]);
        System.out.println("Writting ODD Numbers to file: "+ args[2]);
        Helper.writeToFile(oddNumbers,args[2]);
        System.out.println("Finish processing File Handling Utility!");
    }
}
