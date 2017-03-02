package main;

import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            String[] buff = input.readLine().split("");
            input.close();
            if (buff.length < 5)
            {
                BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
                output.write("ERROR");
                output.close();
                return;
            }
            int cell1Number, cell2Number, cell1LetterPos, cell2LetterPos;
            cell1LetterPos = getLetterPos(buff[0]) - 64;
            cell1Number = Integer.parseInt(buff[1]) - 48;
            cell2LetterPos = getLetterPos(buff[3]) - 64;
            cell2Number = Integer.parseInt(buff[4]) - 48;
            String answer;
            int result1 = Math.abs(cell1LetterPos - cell2LetterPos);
            int result2 = Math.abs(cell1Number - cell2Number);
            if (result1 == 1 && result2 == 2)
            {
                answer = "YES";
            }
            else if (result1 == 2 && result2 == 1)
            {
                answer = "YES";
            }
            else
            {
                answer = "NO";
            }
            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
            output.write(answer);
            output.close();
        }catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static int getLetterPos(String letter)
    {
        String[] alph = {"A","B","C","D","E","F","G","H"};
        for (int i = 0;i < alph.length;i++)
        {
            if (alph[i].equals(letter))
            {
                return i + 1;
            }
        }
        return -1;
    }
}
