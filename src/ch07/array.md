## 1. 개요

---
자료구조는 크게 <b>메모리 공간 기반의 연속(Contiguous) 방식</b>과 <b>포인터 기반의 연결(Link) 방식</b>으로 나뉜다.
+ 연속 방식의 기본적인 자료형 → 배열
+ 연결 방식의 기본적이 자료형 → 연결리스트

## 2. 배열

---
* C언어를 기준으로 배열에 대한 설명   
  배열은 크기를 지정하고 해당 크기만큼의 연속된 메모리 공간을 할당받는 작업을 수행하는 자료형을 말한다.   
  크기가 고정되어 있으며, 한번 생성한 배열은 크기를 변경하는 것이 불가능하다.  
<br>
* 배열의 장점   
  O(1)의 속도로 조회가 가능하다.   
  => 이유는 ??? ** 파이썬 교수님 설명 덧붙이기!!! **

## 3. 동적 배열

---
위에서 배열은 고정된 크기만큼의 연속되 메모리 할당이라고 설명하였다.   
그러나 실제에서는 전체 크기를 가늠하기 힘들 때가 많다.   
이런 문제를 해결하고자 크기를 지정하지 않고 자동으로 __리사이징__ 하는 배열인 동적 배열이 등장했다.   
#### 각 프로그래밍 언어에서 지원하는 동적 배열 자료형
+ 자바 : ArrayList
+ C++ : std::vector
+ 파이썬 : 정적 배열이 없이 동적 배열만 제공

#### 동적 배열의 원리
+ 미리 초깃값을 잡아 배열을 생성하고, 데이터가 추가되면서 꽉 채워지면, 늘려주고 모두 복사하는 식.
+ 대개는 더블링이라 하여 2배씩 늘려주는데, 그 비율은 각 언어마다 상이하다.

#### 자바의 ArrayList의 더블링 구조
+ ArrayList는 초깃값으로 크기가 10인 배열을 설정하고, 값으로 공간이 가득 차면 더블링으로 늘려준다.
+ 명칭은 더블링이지만 정확히 2배는 아니며, 이 재할당 비율을 <b>그로스 팩터(growth factor, 성장인자)</b>라고 한다.
+ ArrayList는 비트 연산으로 계산하도록 구현되어 있으며, 이 비율은 정확히 1.5배이다.   
→ 즉, 배열이 가득차면 1.5배 더 큰 메모리 영역을 할당하고 다시 데이터를 모두 복사하는 식으로 늘려나간다.   

#### 동적 배열 정리
+ 정적 배열과 다르게 크기를 지정할 필요가 없어 매우 편리하게 사용 가능
+ 조회는 기존의 정적 배열과 동일하게 O(1)에 가능하다.
+ 그러나 더블링이 필요한 만큼 공간이 차면, 새로운 배열로 복사하여 이사하는 비용으로 O(n)이 발생한다.
+ 하지만 자주 일어하는 일은 아니므로, 분할 상환 분석(?)에 따른 입력 시간은 여전히 O(1)이다.
+ 동적 배열은 분할 상환 분석에 따른 시간 복잡도를 설명하는 대표적인 자료형이기도 하다.