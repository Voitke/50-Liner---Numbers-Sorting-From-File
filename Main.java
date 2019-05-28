import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("What is your file's pathname?");
        String filePathname = new Scanner(System.in).nextLine();

        File datafile = new File(filePathname);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        String fileLine;

        try
        {
            BufferedReader fileInput = new BufferedReader(new FileReader(datafile));
            while((fileLine = fileInput.readLine()) != null)
                numbers.add(Integer.parseInt(fileLine));
            fileInput.close();

            sort(numbers);

            BufferedWriter fileOutput = new BufferedWriter(new FileWriter(datafile));
            for (Integer number : numbers)
            {
                fileOutput.write(number.toString());
                fileOutput.newLine();
            }
            fileOutput.close();
        }
        catch(IOException ex) { ex.printStackTrace(); }
    }

    public static void sort(ArrayList<Integer> array)
    {
        int smallestIndex = 0;
        for (int i = 0; i < array.size(); i++)
            for(int j = i + 1; j < array.size(); j++)
                if (array.get(j) < array.get(i)) swap(array, j, i);
    }

    public static void swap(ArrayList<Integer> array, int indexA, int indexB)
    {
        int temp = array.get(indexA);
        array.set(indexA, array.get(indexB));
        array.set(indexB, temp);
    }
}