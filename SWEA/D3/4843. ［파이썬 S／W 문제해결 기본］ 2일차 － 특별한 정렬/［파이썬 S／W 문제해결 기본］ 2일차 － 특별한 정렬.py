# 제출시간 : 2021. 8. 24. 오후 5:15:25

T= int(input())

for test_case in range(1,T+1):
    N= int(input())
    arr= list(map(int, input().split()))
    for i in range(len(arr)):
        
        if(i%2):
            min=i
            for j in range(i+1, len(arr)):
                if(arr[j]<arr[min]):
                    min=j
            tmp=arr[min]
            arr[min]=arr[i]
            arr[i]=tmp
        else:
            max=i
            for j in range(i+1, len(arr)):
                if(arr[j]>arr[max]):
                    max=j
            tmp=arr[max]
            arr[max]=arr[i]
            arr[i]=tmp
    print(f"#{test_case}",end=" ")
    for i in range(10):
        
        print(f"{arr[i]}", end=" ")
    print()