T= int(input())

for test_case in range(1, T+1):
    K,N,M=map(int, input().split())
    station_list= list(map(int, input().split()))
    station_list.append(N)
    bus_life=K
    result=0
    for i in range(len(station_list)):
        pre_station = station_list[i-1] if(i!=0) else 0
        if(K<station_list[i]-pre_station):
            result=0
            break
        elif(bus_life<station_list[i]-pre_station):
            #bus charging
            bus_life=K
            
            result = result+1
        bus_life= bus_life-(station_list[i]-pre_station)
    if bus_life<N-station_list[-1] and result != 0:
        result= result+1
    print(f"#{test_case} {result}")
    
     