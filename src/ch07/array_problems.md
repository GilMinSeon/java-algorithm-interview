## 07 ) 두 수의 합

---
### 문제 : 리트코드 1.Two Sum
덧셈하여 타깃을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.   

```
입력 예시
nums = [2, 6, 11, 15], target = 8

출력 예시
[0, 1]
```

#### 풀이과정
##### 1) 브루트 포스 방법
+ 모든 조합을 일일이 확인 → 무차별 대입 방식이라서 브루트 포스
+ how? 문제가 두 숫자의 합이 target인 것을 찾는 것이므로 배열에서 나올 수 있는 두개의 숫자 조합을 전부 나열하면서 찾으면 됨. <b>즉, for문 두 개</b>
+ 찾다가 정답 발견하면 return

*  java code
    ```java
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    // 배열 리턴하는 방식 기억하기!!!
                    return new int[]{i, j};
                }
            }
        }
    }
    ```
    * 시간복잡도 : O(n²), 정확히는 1/2n² (why? j=i+1로 셋팅하므로)
    * 운 나쁘면 모든 조합 전부 탐색해야 하므로 지나치게 비효율적 → 다른 방식 필요

##### 2, 3) 주어진 target에서 첫 번째 수를 뺀 값을 찾아보기!→ 비교나 탐색 없이 한 번의 조회(O(1))로 가능
+ 원리 : 별도의 맵에 input배열을 (인덱스, 값)으로 저장해두기
+ 주어진 target에서 첫 번쨰 값을 뺸 다음 별도의 맵에 그 값이 있으면 return! 획기적!
+ → 고급스러운 언어로 정리 : target 변수에서 첫 번째 수를 빼면 두 번째 수를 알 수 있다. 두 번째 수를 키로 하고 기존의 인덱스를 값으로 바꿔서 맵에 저장해두면 두 번쨰 수를 키로 조회하면 정답!
+ HashMap 사용 : 자바에서 HashMap은 내부적으로 해시테이블로 구현되어 있다. 조회=>평균적으로 O(1)!!
+ 분할 상환 분석(?)에 따른 시간복잡도는 O(1)이며, 전체는 O(n)이다.
+ 풀이 1번인 O(n²)에 비하면 매우 빠름

*  java code
    ```java
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        /*
        for (int i=0; i<nums.length; i++) {
            // put을 먼저 하면?? 오류 [3,2,3], 6 이런 케이스일때 [0,0]되버리므로
            //numsMap.put(nums[i], i);

            // i보다 하나 앞선 인덱스를 nums에 넣어두면?? -> 이렇게 하면 정답이 첫번쨰와 마지막에 있는 케이스 통과가 안됨
            // [3,2,3], 6
            //if (i+1 != nums.length) numsMap.put(nums[i+1], i+1);

            if (i != 0 && numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            
            // 이렇게 해야 모든 인덱스 비교 가능
            numsMap.put(nums[i], i);
            
        }
        */

        // 아니면 0번 인덱스 값 미리 넣어두고 시작 -> for문 1번부터 돌리기
        numsMap.put(nums[0], 0);
        for (int i=1; i<nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }
    ```
      * numsMap이라는 배열 만든 이유: 자바 containsKey함수를 쓰기 위해서!
      * containsKey함수 : 해시맵에 특정 키 존재 여부 확인하기
      * 고민. numsMap.put(nums[0], 0); 이런식으로 0번인덱스 넣어놓는 소스랑 책소스 중 뭐가 더 선호??

##### 4) 투 포인터 이용
+ 원리 : left, right 두 개의 포인터를 두어 nums 배열 탐험-> 합이 target보다 작으면 left를 한 칸 이동 이런식
+ 결론 : 투 포인터로는 이 문제 풀 수 없다.
+ why? 인풋 배열이 정렬된 상태가 아니기 때문에
+ 그럼 정렬하면? 그래도 불가. 인덱스가 모두 엉망이 된다.
+ 해당 문제처럼 인덱스를 찾아내서 리턴해야 하는 문제는 정렬을 통해 인덱스 섞어 버리면 곤란하다