import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class q3_GlobalMembers
{
	///#define fast_io ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

	public static long iter = 10000000;


	public static void main(String[] args) throws NumberFormatException, IOException
	{
		
		ArrayList< Pair<Integer, Integer>> coord = new ArrayList< Pair<Integer, Integer>>();
		File file = new File("C:\\Users\\ujjwa\\Documents\\Custom Office Templates\\temp\\src\\one.txt"); 
		//File file = new File("C:\\Users\\ujjwa\\Documents\\Custom Office Templates\\temp\\src\\two.txt"); 
		//File file = new File("C:\\Users\\ujjwa\\Documents\\Custom Office Templates\\temp\\src\\three.txt"); 
		//File file = new File("C:\\Users\\ujjwa\\Documents\\Custom Office Templates\\temp\\src\\four.txt"); 
		//File file = new File("C:\\Users\\ujjwa\\Documents\\Custom Office Templates\\temp\\src\\five.txt"); 

		Scanner sc = new Scanner(file); 
		int index=0;
		while (sc.hasNextLine()) 
		{
			String[] values= sc.nextLine().split(" ");
			coord.add(new Pair<Integer, Integer>(Integer.parseInt(values[1]),Integer.parseInt(values[2])));
			index++;
		}
		
		double[][] a = new double[index][index];
		double[] ex = new double[5];
		for (int i = 0;i < index;i++)
		{
			a[i] = new double[index];
			for (int j = 0;j < index;j++)
			{
				a[i][j] = -1;
			}

		}

	
		q3_Graph g = new q3_Graph(index,a);

		System.out.print("\n");
		System.out.print("Number of Iterations = ");
		System.out.print(iter);
		System.out.print("\n");
		System.out.print("No. of nodes = ");
		System.out.print(index);
		System.out.print("\n");
		g.formGraph();
		g.allocateCost(new ArrayList< Pair<Integer, Integer>>(coord));
		g.generate_tour();
		System.out.print("Initial tour is:\n");
		g.getTour();
		System.out.print("Initial cost is:\n");
		System.out.print(g.returnCost());
		System.out.print("\n");
		g.anneling();
		System.out.print("Final tour is:\n");
		g.getTour();
		System.out.print("Final cost is:\n");
		System.out.print(g.returnCost());
		System.out.print("\n");

	}

}