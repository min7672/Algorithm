T=int(input())
for test_case in range(1,T+1):
    N=int(input())
    print(f'#{test_case}')
    base_arr=[1,1]
    if N>0:
        print(1)
    if N>1:
        for k in base_arr:
            print(k, end=" ")
        print("")
    if N>2:
        for i in range( N-2):
            tmp=[1]
            print(1, end=" ")
            for j in range(len(base_arr)-1):
                print(base_arr[j]+base_arr[j+1],end=" ")
                tmp.append(base_arr[j]+base_arr[j+1])
            print(1)
            tmp.append(1)
            base_arr=tmp.copy()
            
        