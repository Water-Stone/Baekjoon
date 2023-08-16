# import sys
# sys.setrecursionlimit(1000000)


class Node(object):
    def __init__(self, _value, _data=None):
        self.value = _value
        self.end_data = _data
        self.children = {}
        # self.parent = None
        self.includes = []

class Trie:
    def __init__(self):
        self.head = Node(None)
    
    def insert(self, string):
        curr_node = self.head
        
        for char in string:
            parent = curr_node
            if char not in curr_node.children:
                curr_node.children[char] = Node(char)
            curr_node = curr_node.children[char]
            # curr_node.parent = parent
            curr_node.includes.append(string)
        
        curr_node.end_data = string
    
#     def search(self, string):
#         curr_node = self.head
        
#         for char in string:
#             if char in curr_node.children:
#                 curr_node = curr_node.children[char]
#             else:
#                 return False
        
#         if curr_node.end_data:
#             return True
#         else:
#             return False
    
#     def starts_with(self, prefix):
#         curr_node = self.head
#         words = []
        
#         for p in prefix:
#             if p in curr_node.children:
#                 curr_node = curr_node.children[p]
#             else:
#                 return None
        
#         curr_node = [curr_node]
#         next_node = []
#         while True:
#             for node in curr_node:
#                 if node.end_data:
#                     words.append(node.end_data)
#                 next_node.extend(list(node.children.values()))
            
#             if next_node:
#                 curr_node = next_node
#                 next_node = []
#             else:
#                 break
        
#         return words
    
    def cnt_least_input(self, word):
        # if len(self.starts_with(word[0])) == 1:
        #     return 1
        
        curr_node = self.head
        cnt = 0
        
        for char in word:
            curr_node = curr_node.children[char]
            cnt += 1
            if len(curr_node.includes) == 1:
                return cnt
        return cnt
        
        # L = len(word)
        
#         for char in word:
#             curr_node = curr_node.children[char]
        
#         if curr_node.children:
#             return L
        
#         while True:
#             curr_node = curr_node.parent
#             if not curr_node.value:
#                 cnt -= 1
#                 break
            
#             if not curr_node.end_data and len(curr_node.children) == 1:
#                 cnt += 1
#             else:
#                 break
        
#         return L - cnt
                


def solution(words):
    result = 0
    trie = Trie()
    
    for word in words:
        trie.insert(word)
    
    for word in words:
        # for i in range(1, len(word) + 1):
        #     result += 1
        #     if len(trie.starts_with(word[0:i])) > 1:
        #         continue
        #     else:
        #         break
        result += trie.cnt_least_input(word)
    
    return result