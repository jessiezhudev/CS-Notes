def findSmallest(arr):
    smallest = arr[0]
    smallest_index = 0
    for i in range(1, len(arr)):
        if(arr[i] < smallest):
            smallest = arr[i];
            smallest_index = i
    return smallest_index

def selectionSort(arr):
    newArr = []
    for i in range(len(arr)):
        smallest = findSmallest(arr);
        newArr.append(arr.pop(smallest))
    return newArr

print selectionSort([5, 3, 6, 2, 10])

# Tips
# 随着排序的进行每次检查的元素都在减少，第一次需要检查n个元素，随后n-1,n-2...
# 2,1 运行时间应该为O(n*1/2*n)但是大O表示忽略1/2这样的常数