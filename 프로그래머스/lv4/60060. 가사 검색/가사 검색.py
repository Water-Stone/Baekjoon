from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.count = 0  # 현재 노드까지 오는 경로의 단어 개수

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        node.count += 1  # 루트 노드도 포함하므로 count 1 증가

        for char in word:
            node = node.children[char]
            node.count += 1

    def search(self, query):
        node = self.root

        for char in query:
            if char == '?':
                return node.count  # 와일드카드 문자인 '?'이 나오면 현재 노드까지 오는 경로의 단어 개수 반환
            if char not in node.children:
                return 0  # 검색하려는 문자가 트라이에 없으면 매치되는 단어 없음
            node = node.children[char]

        return node.count  # query가 끝났을 때 현재 노드까지 오는 경로의 단어 개수 반환

def solution(words, queries):
    answer = []
    trie_dict = defaultdict(Trie)  # 길이별로 Trie 객체를 저장할 딕셔너리 생성
    reverse_trie_dict = defaultdict(Trie)  # 길이별로 접미사에 대한 Trie 객체를 저장할 딕셔너리 생성

    for word in words:
        trie_dict[len(word)].insert(word)  # 가사 단어를 길이별로 Trie에 삽입
        reverse_trie_dict[len(word)].insert(word[::-1])  # 가사 단어를 뒤집어서 접미사에 대한 Trie에 삽입

    for query in queries:
        if query[0] == '?':  # 접두사에 와일드카드가 있는 경우
            reversed_query = query[::-1]  # 접두사를 검색하기 위해 문자열을 뒤집음
            answer.append(reverse_trie_dict[len(query)].search(reversed_query))
        else:  # 접미사에 와일드카드가 있는 경우
            answer.append(trie_dict[len(query)].search(query))

    return answer
