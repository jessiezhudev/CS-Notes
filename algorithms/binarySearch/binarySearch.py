def binarySearch(list, item):
    low = 0;
    high = len(list)-1;
    while low<=high:
        mid = (low+high)/2;
        guess = list[mid];
        if guess == item: 
            return guess
        if guess > item:
            high = mid -1
        else:
            low = mid +1
    return None;
print binarySearch([1,2,3,4,5,6], 5)

# 如果不是偶数，python自动向下圆整
# 运行时间为logN，每次都能排除一般的数字，前提是数组是有序的。