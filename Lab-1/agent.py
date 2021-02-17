from queue import PriorityQueue
import numpy as np
from enviroment import next_move
from queue import Queue
class Agent:
    def __init__(self, state,cost,parent):
        self.state = state
        self.cost = cost
        self.parent=parent

    def check_empty(frontier):
        if frontier.empty():
            #raise Exception("Popping from an empty stack")
            return True
        else:
            return False
  
    def check_goal(current,goal):
        if(current.state==goal):
            return True
        else: 
            return False

    def update_visited(current,frontier):
        frontier.push(current)

    def get_child(self,current):
        pass

    # def cost(self,current,goal):
    #     current_mat=np.array(current).reshape(3,3)
    #     goal_mat=np.array(goal).reshape(3,3)

def path_print(goal):
    path=[]
    if goal.parent==None:
        return 
    print(goal.parent.state)
    path_print(goal.parent)

def solve(start,goal):
    frontier=Queue()
    rootnode=Agent(start.state,start.cost,None)
    explored={}
    frontier.put(rootnode)
    costs=0
    branch=0
    goal_node=None
    depth=0
    result=False
    while not (Agent.check_empty(frontier)):
        # print(rootnode.state)
        current=frontier.get()
        # print(current.state)
        goal_reached=Agent.check_goal(current,goal)
        if goal_reached:
            # print("Goal State Reached")
            goal_node=current
            result=False
            costs=current.cost+1
            # print(current.cost)
            break
        else:
            cost=current.cost+1
            explored[current]=cost
            child=next_move(current.state)
            for child_state in child:
                parent=current.state
                node=Agent(child_state,cost,current)
                # print(node)
                if  node not in explored:
                    # print(node.state,node.cost)
                    frontier.put(node)
    return result,costs,goal_node

    

    

    