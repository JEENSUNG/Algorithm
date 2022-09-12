import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aIndex = 0;
        int bIndex = 0;
        if(A[A.length - 1] < B[0])
            return B.length;
        while(bIndex < B.length && aIndex < A.length){
            if(A[aIndex] < B[bIndex]) {
                answer++;
                aIndex++;
                bIndex++;
            }
//            이 부분이 추가 내용
//            if(A[aIndex] == B[bIndex]){
//                aIndex++;
//                bIndex++;
//            }
            else if(A[aIndex] >= B[bIndex]){
                while(bIndex < B.length){
                    if(A[aIndex] < B[bIndex])
                        break;
                    bIndex++;
                }
                if(bIndex == B.length)
                    return answer;
                answer++;
                aIndex++;
                bIndex++;
            }
        }
        return answer;
    }
}