# [level 3] 가장 먼 노드 - 49189 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/49189) 

### 성능 요약

메모리: 625 MB, 시간: 7154.06 ms

### 구분

코딩테스트 연습 > 그래프

### 채점결과

<br/>정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p style="user-select: auto;">n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.</p>

<p style="user-select: auto;">노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.</p>

<h5 style="user-select: auto;">제한사항</h5>

<ul style="user-select: auto;">
<li style="user-select: auto;">노드의 개수 n은 2 이상 20,000 이하입니다.</li>
<li style="user-select: auto;">간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.</li>
<li style="user-select: auto;">vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.</li>
</ul>

<h5 style="user-select: auto;">입출력 예</h5>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">n</th>
<th style="user-select: auto;">vertex</th>
<th style="user-select: auto;">return</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">6</td>
<td style="user-select: auto;">[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]</td>
<td style="user-select: auto;">3</td>
</tr>
</tbody>
      </table>
<h5 style="user-select: auto;">입출력 예 설명</h5>

<p style="user-select: auto;">예제의 그래프를 표현하면 아래 그림과 같고, 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.</p>

<p style="user-select: auto;"><img src="https://grepp-programmers.s3.amazonaws.com/files/ybm/fadbae38bb/dec85ab5-0273-47b3-ba73-fc0b5f6be28a.png" title="" alt="image.png" style="user-select: auto;"></p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges