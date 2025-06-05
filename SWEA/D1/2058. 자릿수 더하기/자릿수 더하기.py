num=int(input())
result=0
for i in range(3,0,-1):
    #print(i, num, result, num//(10**i),num-(num//(10**i))*(10**i))
    result+=num//(10**i)
    num=num-(num//(10**i))*(10**i)
print(f'{result+num}')