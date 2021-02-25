import java.util.*;

public class q3_Graph
{
		private int nodes;
//ORIGINAL LINE: double** a;
		private double[][] a;
		private ArrayList<Integer> tour = new ArrayList<Integer>();
		private double cost;
		private double T = 1000;

//ORIGINAL LINE: Graph(int n,double** arr): nodes(n),a(arr)
		public q3_Graph(int n, double[][] arr)
		{
			this.nodes = n;
			this.a = arr;
		}

		public final void formGraph()
		{
			for (int i = 0;i < nodes;i++)
			{
				for (int j = 0;j < nodes;j++)
				{
					if (a[i][j] == -1)
					{
						a[i][j] = 0;
					}
				}
			}
		}

		public final void allocateCost(ArrayList< Pair<Integer, Integer>> coord)
		{
			int x = 0;
			for (Pair<Integer, Integer> i : coord)
			{
				int y = 0;
				for (Pair<Integer, Integer> j : coord)
				{
					double d = Math.sqrt(Math.pow(i.first - j.first, 2) + Math.pow(i.second - j.second, 2));
					a[x][y] = d;
					y++;
				}
				x++;
			}
		}

		public final void getGraph()
		{
			for (int i = 0;i < nodes;i++)
			{
				for (int j = 0;j < nodes;j++)
				{
					System.out.print("| ");
					System.out.print(a[i][j]);
					System.out.print(" |");
				}
				System.out.print("\n");
			}
		}

		public final double getTemp()
		{
			return T;
		}

		//random starting tour:
		public final void generate_tour()
		{
			cost = 0;
			tour.add(0);
			double[] f = new double[nodes];
			f[0] = 1;
			for (int i = 1;i < nodes;i++)
			{
				int temp;
				do
				{
					temp =(int) new Random().nextInt(nodes);
				} while (f[temp] != 0);
				f[temp] = 1;
				cost += a[tour.size() - 1][(int) temp];
				tour.add(temp);
			}
		}

		public final void getTour()
		{
			for (int i = 0;i < tour.size();i++)
			{
				if(i%18 ==0)
					System.out.println();
				System.out.print(tour.get(i));
				System.out.print(" --> ");
			}
			System.out.print(0);
			System.out.print("\n");
		}

		public final double returnCost()
		{
			return cost;
		}

		public final double getCost(ArrayList<Integer> t)
		{
			double c = 0;
			for (int i = 0;i < t.size() - 1;i++)
			{
				c += a[t.get(i)][t.get(i + 1)];
			}
			return c;
		}

		public final ArrayList<Integer> generateChild(ArrayList<Integer> t)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
				int one;
				int two;
				//calculate two random nodes:
				do
				{
					one = (int) new Random().nextInt(nodes);
					two = (int) new Random().nextInt(nodes);
				} while (one == two || one == 0 || two == 0);

				temp = new ArrayList<Integer>(t);

				int ex;
				ex = temp.get(one);
				temp.set(one, temp.get(two));
				temp.set(two, ex);

				return new ArrayList<Integer>(temp);
		}

		public final void anneling()
		{
			while (q2_GlobalMembers.iter > 0)
			{
				//generate child:
				ArrayList<Integer> temp = generateChild(new ArrayList<Integer>(tour));

				//calculate probability:
				double newCost = getCost(new ArrayList<Integer>(temp));
				double diff = Math.abs(newCost - cost);
				double r = diff / T;
				double p = Math.exp(-r);

				if (newCost < cost)
				{
					//select
					tour = new ArrayList<Integer>(temp);
					cost = newCost;
				}
				else
				{
					double prob = 1 / (int) new Random().nextInt(Integer.MAX_VALUE);
					if (p > prob)
					{
						//select
						tour = new ArrayList<Integer>(temp);
						cost = newCost;
					}
				}
				T *= 0.75;
				q2_GlobalMembers.iter--;
			}
		}
}