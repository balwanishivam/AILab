from enviroment import next_move
from generate import generate
import random
from agent import solve, path_print
from agent import Agent
import tracemalloc
import time


start = list(range(0, 9))
random.shuffle(start)
print("start+>", start)
current_memory = []
peak_memory = []
costs = []
time_cal = []
for i in range(1, 30):
    start_time = time.time()
    tracemalloc.start()
    instance = generate(start, i)
    print("goal+>", instance, i)

    start_node = Agent(start, 0, None)
    # end_node=Agent(instance,0,None)
    goal = instance
    result, cost, goal_node = solve(start_node, goal)
    if result:
        print("Not Reachable")

    else:
        costs.append(cost)
        # print(goal_node.state)
        # print("Path: ")
        # path_print(goal_node)
        # print(path)

    current, peak = tracemalloc.get_traced_memory()
    current = current / 10 ** 6
    peak = peak / 10 ** 6
    current_memory.append(current)
    peak_memory.append(peak)
    # print("Depth=>", i, "\nMemory=>", peak)
    tracemalloc.stop()
    time_cal.append(time.time() - start_time)

# depth = list(range(0, 31))
# print("Depth=>", depth)
# print("Goal State Cost=>", costs)
# print("Time=>", time_cal)
# print("Current Memory=>", current_memory)
# print("Peak Memory=>", peak_memory)
for i in range(1, 30):
    print("Orginal Depth of Goal State passed by user= ", i)
    print("Depth at which agent finds the Goal State= ", costs[i])
    print("Time Taken= ", time_cal[i])
    print("Memory Usage=>", current_memory[i])
    print("Peak Usage=> ", peak_memory[i])
    print("\n")
