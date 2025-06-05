T=int(input())
for test_case in range(1,T+1):
    num,div=map(int,input().split())
    print("#"+str(test_case),num//div, num%div)