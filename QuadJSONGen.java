import java.util.*;
import java.io.*;
import java.awt.*;

public class QuadJSONGen
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(new File("quadlims.csv"));

		String firstLine = in.nextLine();
		firstLine = firstLine.substring(1,firstLine.length());
		String[] names = firstLine.split(",");

		PrintWriter out = new PrintWriter(new FileWriter(new File("quadlims.json")));

		out.println("{");
  		out.println("\t\"nodes\": [");
  		out.println("\t\t{\"id\": \"Abdulghani\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Abeer\", \"group\": 3},");
  		out.println("\t\t{\"id\": \"Anne\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Anna\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Anwar\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Danny\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Farhan\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Fatima\", \"group\": 3},");
  		out.println("\t\t{\"id\": \"Halah\", \"group\": 3},");
  		out.println("\t\t{\"id\": \"Humza\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Marwa\", \"group\": 3},");
  		out.println("\t\t{\"id\": \"Milton\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Omar\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Sarah\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Shaiba\", \"group\": 3},");
  		out.println("\t\t{\"id\": \"Waleed\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Saim\", \"group\": 2},");
  		out.println("\t\t{\"id\": \"Ameerah\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Aafreen\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Maha\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Lydia\", \"group\": 1},");
  		out.println("\t\t{\"id\": \"Raahil\", \"group\": 2}");
  		out.println("\t],");
		out.println("\t\"links\": [");

		int limit = Integer.parseInt(args[0]);

		while (in.hasNextLine()) {
			String line = in.nextLine();
			String[] corres = line.split(",");
			String sourceName = corres[0];

			for (int i = 1; i < corres.length; i++)
			{
				if (corres[i].equals("x") || corres[i].equals(""))
				{

				}
				else
				{
					if (Integer.parseInt(corres[i]) <= limit && !sourceName.equals("Shaiba"))
						out.println("\t\t{\"source\": \"" + sourceName + "\", \"target\": \"" + names[i - 1] + "\", \"value\": " + corres[i] + "},");
					else if (Integer.parseInt(corres[i]) <= limit)
						out.println("\t\t{\"source\": \"" + sourceName + "\", \"target\": \"" + names[i - 1] + "\", \"value\": " + corres[i] + "}");
				}
			}

		}

		out.println("\t]");
		out.println("}");
		out.flush();
		out.close();
	}
}