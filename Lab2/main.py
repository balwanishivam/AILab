from enviroment import next_move
import random
from PriorityQueue import PriorityQueue

if __name__ == '__main__': 
    myQueue = PriorityQueue() 
    start = list(range(0,9))
    random.shuffle(start)
    start2 = list(range(0,9))
    random.shuffle(start2)
    print("start+>",start)
    myQueue.insert(start,12) 
    myQueue.insert(start,1) 
    myQueue.insert(start,14) 
    myQueue.insert(start2,7) 
    print(myQueue) 
    myQueue.update(start2,10) 
    print(myQueue.isPresent(start2))
    print(myQueue)             
    while not myQueue.isEmpty(): 
        print(myQueue.pop()) 