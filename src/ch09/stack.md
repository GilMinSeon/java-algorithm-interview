## 9장. 스택, 큐

### 스택
* 가장 나중에 삽입된 엘리먼트가 가장 먼저 처리되는 후입선출(LIFO)로 처리되는 추상 자료형
  * 연결 리스트를 이용해 스택을 구현하는 예시
    1) 연결 리스트를 담을 MyNode 클래스 정의
      ```java
      class MyNode {
          int item;
          MyNode next; // 노드의 다음 노드
        
          public MyNode(int item, Node next) {
              this.item = item;
              this.next = next;
        }
      }
      ```
    * MyNode 클래스는 노드의 값과 다음 노드를 가리키는 포인터를 가지고 있으며, 전체 연결 리스트의 한 노드가 된다.
    * 노드의 값은 item에 저장, 다음 노드의 정보는 next에 저장
<br>
    2) 스택의 연산인 push()와 pop()을 담은 MyStack 클래스 정의
      ```java
      class MyStack {
        MyNode last;
    
        // !생성자! 스택 최초 생성 시 마지막 노드는 없음
        public MyStack() {
            this.last = null;
        }   
        
        // push 연산 : 연결 리스트에 노드를 추가하면서 현재의 마지막 노드는 next로 이동하고, 현재 추가된 노드를 last로 만든다
        public void push(int item) {
            // 입력값으로 신규 노드 생성, 기존의 마지막 노드는 다음 노드가 된다.
            // 대입연산자 기준 오른쪽 수행하면서 새로운 MyNode라는 객체가 생성되고, 그 객체가 MyStack클래스의 last로 저장
            this.last = new MyNode(item, this.last);
        }   
        
        // pop 연산
        public int pop(){
            int item = this.last.item;  // 마지막 노드의 값을 끄집어낸다.
            this.last = this.last.next; // 마지막 노드를 한 칸 앞으로 이동한다.
            return item;
        }
      }
      ```
    3) 구현한 스택 클래스에 push, pop 수행
    ```java
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
      ```

### 큐
    - 가장 먼저 삽입된 엘리먼트가 가장 먼저 처리되는 선입선출(FIFO) 순으로 처리되는 추상 자료형
    - 스택과는 완전히 반대 개념으로, 스택과 비교하였을 때 상대적으로 쓰임새가 적다.
    - 그러나, 데크(Deque)나 우선순위 큐(Priority Queue) 같은 큐의 변경들은 여러 분야에서 매우 유용하게 쓰인다.
      너비우선탐색(BFS)이나 캐시등을 구현할때도 사용됨!

### 자바에서 스택과 큐 활용하기
#### 자바의 큐 선언
    - 자바에서 실제로 큐가 구현되어 있는 방식
    - Queue는 자바의 인터페이스
    - 이를 실제로 구현하는 자료형으로는 LinkedList 또는 ArrayDeque가 있다.
    - Queue 인터페이스에는 큐에 필요한 삽입 연산 offer(), 추출 연산 poll() 등이 정의 되어 있으며, 이를 LinkedList등이 구현하고 있다

```java
    Queue<Integer> queue = new LinkedList;
    queue.offer(1);
    queue.offer(2);
    queue.poll();   // 1!!!
```
    
#### 자바의 스택 선언
* 큐와 같이 자바는 스택 자료형도 지원한다.

```java
Stack<Integer> stack = new Stack;
```
* 하지만 위 자료형은 사용하면 안된다. 
* Stack클래스는 너무 오래됨. Stack클래스는 Vector라는 자료형을 기반으로 하는데 동시에 한 작업만 할 수 있는 자료형으로 성능 문제가 심각함.
* 따라서 실서비스에서는 Stack클래스 대신에 새로운 자료형인 Deque를 사용하면 된다.

        - Deque 자료형
        : Queue와 마찬가지로 인터페이스로 실제 구현체는 LinkedList 또는 ArrayDeque로 가능하다.
        : 스택이 필요할 때는 ArrayDeque를 구현체로 한 Deque 인터페이스를 사용!

    ```java
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(1);
    stack.push(2);
    stack.pop(); // 2
    ```
