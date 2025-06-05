T = int(input())
#             1    2  3  4  5  6  7   8  9  10 11 12
mPerDay=[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
#1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31

for test_case in range(1, T + 1):
    m1,d1,m2,d2=map(int,input().split())
    result=0
    if m1==m2:
        result= d2-d1
    elif m2-m1==1:
        result=mPerDay[m1-1]-d1+ d2
    else:
        result=mPerDay[m1-1]-d1+d2 
        for i in range(m1,m2-1):
            result=result+mPerDay[i]
        
    print(f'#{test_case} {result+1}')