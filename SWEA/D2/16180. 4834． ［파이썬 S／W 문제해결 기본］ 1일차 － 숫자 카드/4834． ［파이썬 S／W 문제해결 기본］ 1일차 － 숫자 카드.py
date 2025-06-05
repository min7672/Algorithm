#제출 시간 :   2021. 8. 21. 오전 9:27:51
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N=int(input())
    arr_str=input()
    
    count_arr={'0':0,'1':0,'2':0,'3':0,'4':0,'5':0,'6':0,'7':0,'8':0,'9':0}
    max_key='0'
    
    for i in range(0,len(arr_str)):
        count_arr[arr_str[i]]=count_arr[arr_str[i]]+1
        if(count_arr[max_key]<count_arr[arr_str[i]] or (count_arr[max_key]==count_arr[arr_str[i]] and max_key<arr_str[i] )):
            max_key=arr_str[i]
    print(f"#{test_case} {max_key} {count_arr[max_key]}")
