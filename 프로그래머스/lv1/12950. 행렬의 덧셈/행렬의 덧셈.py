def solution(arr1, arr2):
    return [[arr1[j][i] + arr2[j][i] for i in range(len(arr1[j]))] for j in range(len(arr1))]