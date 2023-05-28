import heapq

class DoublePQ:
    def __init__(self):
        self._set = set()
    
    def put(self, item):
        self._set.add(item)
    
    def peekMax(self):
        if self.isEmpty():
            return 0
        return max(self._set)
    
    def peekMin(self):
        if self.isEmpty():
            return 0
        return min(self._set)
    
    def deleteMax(self):
        self._set.remove(self.peekMax())
    
    def deleteMin(self):
        self._set.remove(self.peekMin())
    
    def isEmpty(self):
        return len(self._set) == 0

def solution(operations):
    dpq = DoublePQ()
    
    for op in operations:
        cmds = op.split(' ')
        if cmds[0] == 'I':
            insert_num = cmds[1]
            if insert_num[:1] == '-':
                insert_num = int(insert_num[1:]) * (-1)
            else:
                insert_num = int(insert_num)
            dpq.put(insert_num)
        else:
            if not dpq.isEmpty():
                if cmds[1] == '-1':
                    dpq.deleteMin()
                else:
                    dpq.deleteMax()
    
    return [dpq.peekMax(), dpq.peekMin()]