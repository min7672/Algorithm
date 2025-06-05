#오답 이유 list 자료형으로 형변환 안해서 슬라이싱 안됨 

arr_size = int(input())
num_list=list(map(int,input().split()))
#오답 타입 map
num_list.sort()
print(f'{num_list[arr_size//2]}')
