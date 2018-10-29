function bubbleSort(arr) {
    for (let i=0; i<arr.length;i++) {
        for (let j=0; j<arr.length-i-1;j++) {
            if(arr[j]>arr[j+1]) {
                var greater = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = greater;
            }
        }
    }
    return arr;
}
bubbleSort([1,3,2,6])

//any time you see nested loops iterating over the same collection of data
//we may have n*2 runtime complexity