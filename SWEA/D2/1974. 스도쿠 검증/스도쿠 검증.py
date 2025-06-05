
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    arr = [list(map(int, input().split()))for _ in range(9)]
    result=1
    for i in range(9):
        memo_board_row=[0]*9
        memo_board_col=[0]*9
        for j in range(9):
            memo_board_row[arr[i][j]-1]=1
            memo_board_col[arr[j][i]-1]=1
        if  (0 in memo_board_row) or (0 in memo_board_col) :
            result=0
            break
    for k in range(9):
        memo_board=[0]*9
        for l in range(3):
            for m in range(3):
                memo_board[arr[l][m]-1]=1
        if  (0 in memo_board) :
            result=0
            break
    print(f'#{test_case} {result}')