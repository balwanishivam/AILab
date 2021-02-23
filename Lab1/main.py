from enviroment import next_move
from generate import generate
import random
from agent import solve,path_print
from agent import Agent

start = list(range(0,9))
random.shuffle(start)
print("start+>",start)
instance=generate(start,30)
print("goal+>",instance)

start_node=Agent(start,0,None)
# end_node=Agent(instance,0,None)
goal=instance
result,cost,goal_node=solve(start_node,goal)
if result:
    print("Not Reachable")
    
else:
    print("Rechable: ",str(cost))
    print(goal_node.state)
    print("Path: ")
    path_print(goal_node)
    # print(path)



