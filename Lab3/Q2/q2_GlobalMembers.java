import java.util.*;

public class q2_GlobalMembers
{
	/*
	Tourist locations in Rajasthan
	*/
	public static ArrayList<String> cities = new ArrayList<String>(Arrays.asList("KishanGarh", "Kota", "Alwar", "Mount Abu", "Bikaner", "Jaipur", "Silwa", "Barmar", "Sikar", "Sawai Madhopur", "Bharatpur", "Alwar", "Pali", "Chittorgarh", "Hanumangarh", "Jaisalmer", "Jhalawar", "Churu", "Bundi", "Jhunjhunu"));


	public static long iter = 100000;


	public static void main(String[] args)
	{

		long n = 20;

		long[][] a = new long[(int)n][(int)n];
		for (long i = 0;i < n;i++)
		{
			a[(int)i] = new long[(int)n];
			for (long j = 0;j < n;j++)
			{
				a[(int) i][(int) j] = -1;
			}
		}

		q2_Graph g = new q2_Graph(n, a);

		System.out.print("Number of Iterations = ");
		System.out.print(iter);
		System.out.print("\nCities taken= 20 \t");
		System.out.println("Max distance taken= 400");
		System.out.println("Cities are:");
		for (String i : cities)
		{
			System.out.print("| ");
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.print("\n");

		g.formGraph();

		System.out.print("Genrated graph =\n");
		g.getGraph();
		System.out.print("\n");

		g.generate_tour();

		System.out.print("Initial tour is=\n");
		g.getTour();

		System.out.print("Initial cost is:"+g.returnCost()+"\n");

		g.anneling();

		System.out.println("Final tour is:");
		g.getTour();

		System.out.print("Final cost is:");
		System.out.print(g.returnCost());
		System.out.print("\n");

	}

}