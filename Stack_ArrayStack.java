package Stack;

public class ArrayStack {
	/*
	 * 스택 선입후출 -> 먼저 들어온게 제일 마지막에 나감
	 * 배열을 사용하여 스택을 직접 구현하였다.
	 */

	private int index = -1; // -1일때는 데이터가 아무것도 없을때를 의미한다.
	private final Object[] stack; // object로 구성된 stack배열을 만들었다.


	public ArrayStack(int stackSize) {
		stack = new Object[stackSize];
	}


	// 스택이 비어있을 경우
	public boolean isEmpty() {
		return -1 == index; // 인덱스가 -1일때는 비어있다는 것이므로 true
	}

	// 스택이 가득차 있을 경우
	public boolean isFull() {
		return stack.length - 1 == index; // stack의 길이 -1이 top과 같다는건 데이터가 가득 차있다는것을 의미하므로 true
	}


	// 스택에 데이터를 집어 넣을 경우
	public Object push(Object data) {
		if (isFull()) {
			throw new RuntimeException("stack is full");
		}
		// index++;
		// stack[index] = data;
		stack[++index] = data;// 1증가 시킨 인덱스에 데이터를 넣어줌
		return data; // 추가할 데이터를 반환해줌

	}

	// 스택의 데이터를 꺼낼 경우(맨 위 index의 배열부터 꺼내어 삭제)
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		Object tempData = stack[index];
		stack[index] = null; // index에 있는 데이터에 null넣어줌
		index--; // index사이즈 하나 감소시킴
		return tempData; // 꺼낸 데이터를 반환해줌
	}

	// 스택의 맨 위에 배열을 확인 해 보는 함수
	public Object peek() {
		if (isEmpty()) {
			return null;
		}
		return stack[index];
	}

}
