from collections import deque

n, m, k = map(int, input().split())
board = list(list(map(int, input().split())) for _ in range(n))

# cnt : 딸기와 토마토가 같이 자랄 칸의 수
cnt = k*2 - sum([1 if board[i][j] == 1 else 0 for i in range(n) for j in range(m)]) 
print(cnt)          # 칸 수 출력
if cnt == 0: exit() # 겹치지 않으면 종료
    
dxy = [[0, -1], [0, 1], [-1, 0], [1, 0]]

def find1():
    for x in range(n):
        for y in range(m):
            if board[x][y] == 0: continue

            queue = deque([(x, y)])
            board[x][y] = 2
            dir = -1	# 수평일 경우를 위해 방향 저장
            while queue:	# bfs 탐색
                cx, cy = queue.popleft()
                for d in range(4):
                    nx, ny = cx + dxy[d][0], cy + dxy[d][1]
                    if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
                    if board[nx][ny] == 0: continue
                    
                    if board[nx][ny] == 1:
                        queue.append((nx, ny))
                        board[nx][ny] = 2	# 방문 체크
                        
                    if dir == -1: dir = d
                    elif ((dir == 0 or dir == 1) and (d == 2 or d == 3)) or ((dir == 2 or dir == 3) and (d == 0 or d == 1)):	# 방향이 바뀌는 위치
                        print(cx+1, cy+1)
                        return()

            # bfs가 종료되면 수평으로 놓였다는 의미이므로 중간값 출력
            print(x+dxy[dir][0]*(k-1)+1, y+dxy[dir][1]*(k-1)+1)
            return()
            

def find2():
    for x in range(n):
        for y in range(m):
            if board[x][y] == 0: continue
            
			# 방향 찾기
            dir = -1
            for d in range(4):
                nx, ny = x + dxy[d][0], y + dxy[d][1]
                if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
                if board[nx][ny] == 0: continue
                dir = d
                break
            
			# 시작 위치에서 k-cnt만큼 떨어진 위치에서부터 좌표 출력
            sx, sy = x + dxy[dir][0]*(k-cnt)+1, y + dxy[dir][1]*(k-cnt)+1
            for _ in range(cnt):	# cnt개의 좌표
                print(sx, sy)
                sx, sy = sx + dxy[dir][0], sy + dxy[dir][1]
            return()
                
if cnt == 1: find1()	# 1개의 좌표 찾기
else: find2()			# 2개 이상의 좌표 찾기