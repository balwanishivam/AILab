class PriorityQueue(object): 
    def __init__(self): 
        self.queue = [] 
        self.costs=[]
  
    def __str__(self): 
        lists=[]
        for i in range(len(self.queue)):
            val=str(self.queue[i])+" "+str(self.costs[i])
            lists.append(val)

        return str(lists) 
  
    # for checking if the queue is empty 
    def isEmpty(self): 
        return len(self.queue) == 0 and len(self.costs) == 0
  
    # for inserting an element in the queue 
    def insert(self, arr,cost): 
        self.queue.append(arr) 
        self.costs.append(cost)
  
    # for popping an element based on Priority 
    def pop(self): 
        try: 
            min = 0
            for i in range(len(self.costs)): 
                if self.costs[i] < self.costs[min]: 
                    min = i 
            move = self.queue[min] 
            cost=self.costs[min]
            del self.queue[min] 
            del self.costs[min] 
            return move,cost 
        except IndexError: 
            print() 
            exit() 

    def isPresent(self,arr):
        exist=False
        for val in self.queue: 
            if (val==arr): 
                exist=True
        return exist

    def update(self,arr,cost): 
        for i in self.queue:
            if (i==arr): 
                ind=self.queue.index(i)
                self.costs[ind]=cost
  
