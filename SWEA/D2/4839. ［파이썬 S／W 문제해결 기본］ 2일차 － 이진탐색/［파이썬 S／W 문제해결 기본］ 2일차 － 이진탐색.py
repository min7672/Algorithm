# 제출시간 : 2021. 8. 24. 오후 4:58:45

def binarySearchCount(total, target):
    left=1
    right=total
    center=(left+right)//2
    count=1
    while(True):
        if(center==target):
            return count
        elif(target<center):
            right=center
        elif(target>center):
            left=center
            
        center= (left+right)//2
        count=count+1

T=int(input())

for test_case in range(1, T+1):
    P,A,B=map(int, input().split())
    a_count=binarySearchCount(P,A)
    b_count= binarySearchCount(P,B)
    result='0'
    if(a_count>b_count):
        result='B'
    elif(a_count<b_count):
        result='A'
    print(f"#{test_case} {result}")