import java.util.*;

public class q2_Graph
{
		private long nodes;
		private long[][] a=new long[20][20];
		private ArrayList<Long> tour = new ArrayList<Long>();
		private long cost;
		private double T = 1000;

		public q2_Graph(long n, long[][] arr)
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
						if (i == j)
						{
							a[i][j] = 0;
						}
						else
						{
							a[i][j] = (long) new Random().nextInt(400) + 1;
						}
							a[j][i] = a[i][j];
					}
				}
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
					System.out.print("\t|");
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
			tour.add((long) 0);
			long[] f = new long[(int) nodes];
			f[0] = 1;
			for (long i = 1;i < nodes;i++)
			{
				long temp;
				do
				{
					temp =(int) new Random().nextInt((int)nodes);
				} while (f[(int) temp] != 0);
				f[(int) temp] = 1;
				cost += a[tour.size() - 1][(int) temp];
				tour.add(temp);
			}
		}

		public final void getTour()
		{
			for (int i = 0;i < tour.size();i++)
			{
				System.out.print(q2_GlobalMembers.cities.get(tour.get(i).intValue()));
				System.out.print(" --> ");
			}
			System.out.print(q2_GlobalMembers.cities.get(0));
			System.out.print("\n");
		}

		public final double returnCost()
		{

			return cost;
		}


		public final long getCost(ArrayList<Long> t)
		{
			long c = 0;
			for (int i = 0;i < t.size() - 1;i++)
			{
				c += a[t.get(i).intValue()][t.get(i + 1).intValue()];
			}
			return c;
		}

		public final ArrayList<Long> generateChild(ArrayList<Long> t)
		{
			ArrayList<Long> temp = new ArrayList<Long>();
				long one;
				long two;
				//calculate two random nodes:
				do
				{
					one = (int) new Random().nextInt(20);
					two = (int) new Random().nextInt(20);
				} while (one == two || one == 0 || two == 0);

				temp = new ArrayList<Long>(t);

				long ex;
				ex = temp.get((int) one);
				temp.set((int) one, temp.get((int) two));
				temp.set((int) two, ex);

				return new ArrayList<Long>(temp);
		}



		public final void anneling()
		{

			while (q2_GlobalMembers.iter > 0)
			{
				//generate child:
				ArrayList<Long> temp = generateChild(new ArrayList<Long>(tour));

				//calculate probability:

				long newCost = getCost(new ArrayList<Long>(temp));
				long diff = newCost - cost;
				double r = diff / T;
				double p = 1 / (1 + Math.exp(-r));
				if (diff < 0)
				{
					//select
					tour = new ArrayList<Long>(temp);
					cost = newCost;
					T *= 0.2;

				}
				else
				{
					double prob = 1 / (int) new Random().nextInt(Integer.MAX_VALUE);
					if (prob > p)
					{
						//select
						tour = new ArrayList<Long>(temp);
						cost = newCost;
						T *= 0.2;

					}
				}

				q2_GlobalMembers.iter--;
			}
		}
}