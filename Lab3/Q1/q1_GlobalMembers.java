import java.util.ArrayList;
import java.util.Arrays;

public class q1_GlobalMembers
{
	/*
	Tourist locations in Rajasthan
	*/

	public static long iter = 100000;


	public static void main(String[] args)
	{

		long n = 16;

		long[][] a = new long[(int)n][(int)n];
		for (long i = 0;i < n;i++)
		{
			a[(int)i] = new long[(int)n];
			for (long j = 0;j < n;j++)
			{
				a[(int) i][(int) j] = -1;
			}
		}

		q1_Graph g = new q1_Graph(n, a);

		System.out.print("Number of Iterations = ");
		System.out.print(iter);
		System.out.print("\nCities taken= 16 \t");
		System.out.println("Max distance taken= 60");

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