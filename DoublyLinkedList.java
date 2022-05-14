package list3;

public class DoublyLinkedList {

	Node head = null;
	Node tail = null;
	int size = 0;


	// index에 맞는 노드를 반환해줌
	private Node findNode(int searchIndex) {
		if (0 > searchIndex || size <= searchIndex) {
			// 노드의 개수보다 많거나 같으면 예외를 발생시킨다.
			throw new ArrayIndexOutOfBoundsException();
		}
		int nodeIndex;
		Node pointer;
		/**
		 * 찾는 인덱스가 중간 인덱스보다 크면 뒤에서 찾는것이 더 빠르다
		 */
		if (size / 2 > searchIndex) {
			// TODO : 앞에서 부터 찾는다.
			nodeIndex = 0;
			pointer = head;
			while (nodeIndex != searchIndex) {
				++nodeIndex;
				pointer = pointer.right;
			} // nodeIndex와 searchIndex가같아지면 while문 빠져나감

		} else {
			// TODO : 뒤에서 부터 찾는다.
			nodeIndex = size - 1;
			pointer = tail;
			while (nodeIndex != searchIndex) {
				--nodeIndex;
				pointer = pointer.left;
			}
		} // nodeIndex와 searchIndex가같아지면 while문 빠져나감

		return pointer; // 반환값 : 찾은 노드
	}



	public Object getData(int searchIndex) {
		return findNode(searchIndex).data;
	}

	public boolean isEmpty() {
		// TODO : 노드가 비어있는지 확인하는 메서드
		return 0 == size;
	}

	public int size() {
		// TODO : 노드의 개수를 반환하는 메서드
		return size;
	}

	public String addLast(String data) {
		// TODO : 마지막 노드로 추가하는 메서드
		return add(size, data);
	}

	public String addFirst(String data) {

		return add(0, data);
	}

	public void removeLast() {
		// TODO : 마지막 노드를 삭제하는 메서드
		remove(size - 1);
	}

	public void removeFirst() {
		// TODO : 첫 번째 노드 삭제하는 메서드
		remove(0);
	}


	public String add(int index, String data) {
		// TODO : 노드의 순서를 기준으로 해당 index에 삽입한다.
		Node node = new Node();
		node.data = data;

		// TODO : 최초 노드 삽입 하는 경우!!!
		if (0 == index || size == index) {
			if (null == this.head && null == this.tail) {
				// TODO : 최초 노드 삽입
				this.head = node;
				this.tail = node;
				size++;
				return node.data;

			} else if (0 == index) {
				// TODO : 맨 앞에 노드를 삽입
				node.right = this.head;
				this.head.left = node;
				this.head = node;
				size++;
				return node.data;
			} else {
				// TODO : 맨 뒤에 노드를 삽입
				node.left = this.tail;
				this.tail.right = node;
				this.tail = node;
				size++;
				return node.data;
			}
		} else {
			// 중간엔 노드를 삽입하는 경우!!!
			// TODO : 해당 index에 삽입하려면 해당 노드를 찾아야 한다.
			Node foundNode = findNode(index);
			Node leftNode = foundNode.left;
			// TODO : 새로운 노드와 찾은 노드의 연결
			node.right = foundNode;
			foundNode.left = node;
			// TODO : 새로운 노드와 이전 노드의 연결
			node.left = leftNode;
			leftNode.right = node;
			size++;
			return node.data;
		}

	}

	// 해당 index에 해당하는 Node를 삭제한다.
	public void remove(int index) {
		// TODO : 삭제하려는 Node를 찾는다.
		Node removeNode = findNode(index);
		Node leftNode = removeNode.left;
		Node rightNode = removeNode.right;
		if (null != leftNode) {
			// TODO : 좌측 노드가 존재하는 경우
			leftNode.right = rightNode;
		}
		if (null != rightNode) {
			// TODO : 우측 노드가 존재하는 경우
			rightNode.left = leftNode;
		}
		if (0 == index) {
			// TODO : 맨 앞에 있는 노드 삭제시
			this.head = rightNode;
		}
		if (size - 1 == index) {
			// TODO : 맨 뒤에 있는 노드 삭제시
			this.tail = leftNode;
		}
		// TODO : 삭제할 노드의 링크를 모두 끊는다. (선택 사항)
		removeNode.left = null;
		removeNode.right = null;
		removeNode.data = null;

		--size;
	}


}
