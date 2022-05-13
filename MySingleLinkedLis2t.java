package list2;

public class MySingleLinkedList {

	/*
	 * LinekdList를 다른 방식으로  구현
	 * list1 패키지와 list2패키지 각각 비슷하면서도 다르다.
	 * 
	 */
	// 첫번째 노드 = 헤드
	public Node head;
	public int size = 0;


	// 생성자
	public MySingleLinkedList() {
		head = null; // 맨 앞에 노드를 뜻함
		size = 0; // 노드의 사이즈를 뜻함
	}

	// 노드추가 : 맨 앞인 경우
	// 객체와 참조변수를 헷갈리지말자 -> 참조변수는 객체의 주소를 저장하는변수(newNode)
	public void addFirst(String item) {
		Node newNode = new Node(item); // 노드 객체 생성
		newNode.next = head;
		head = newNode;// newNode라는 참조감수의 값이(새로만든 노드의 주소) head를 가르키게됨
		size++;



	}



	// 노드 추가 : 중간에 노드가 들어가는 경우
	public void addAfter(Node before, String item) {
		Node temp = new Node(item); // item을 담고잇는 temp노드 생성
		temp.next = before.next;
		before.next = temp;
		size++; // 노드가 하나 추가될때마다 사이즈를 증가시켜줌


	}



	// 첫번째 노드를 삭제
	public String removeFirst() {
		if (head == null) {
			return null;
		} else {
			String temp = head.data;
			head = head.next;
			size--;
			return temp; // 삭제하고 난 후의 헤드가 가지고 있는 데이터를 반환해줌

		}

	}

	public String removeAfter(Node before) {
		if (before.next == null) {
			// before의 다음 노드가 존재하지 않는다.
			return null;
		} else {
			String temp = before.next.data;
			before.next = before.next.next;
			return temp; // 삭제당한 노드의 데이터를 반환시켜줌 ->별의미없음
		}
	}

	// search
	// 연결 리스트에서 내가 찾는 itme(data)가 있는지 검사 ->위치 리턴
	public int indexOf(String item) {
		Node p = head;
		int index = 0;
		while (p != null) {
			if (p.data.equals(item)) {
				return index;
			}
			p = p.next; // p에다가 다음노드의 주소값을 넣음 -> p를 한칸 전진시킴*앞으로 자주쓰임*
			index++;

		}
		return -1; // item과 같은 데이터가 아무것도 없을때 -1을 반환
	}


	// index번쨰 노드를 리턴해줌
	public Node getNode(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		return p;
	}


	// index번째 노드의 data를 리턴해줌
	public String get(int index) {
		if (index < 0 || index > size) {
			return null;
		}
		// Node p = head;
		// for (int i = 0; i < index; i++) {
		// p = p.next;
		// }
		// return p.data;
		return getNode(index).data;
	}


	// 연결리스트의 index번째의 위치에 새로운 데이터를 삽입한다.
	public void add(int index, String item) {
		if (index < 0 || index > size) {
			return; // 반환값이 void라서 아무것도 반환하지않는다.
		}
		if (index == 0) {// 맨 앞에 노드를 삽입하는 경우
			addFirst(item);
		} else {
			Node q = getNode(index - 1);
			addAfter(q, item);
		}
	}


	// 인덱스번째 노드를 삭제 -> 삭제된 데이터를 return해줌
	public String remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		}

		if (index == 0)
			return removeFirst();

		Node prev = getNode(index - 1); // prev가 가리키는 노드 바로 다음 노드를 삭제해라.
		return removeAfter(prev); // 삭제된 노드의 데이커 값이 반환됨


	}

	// 데이터값을 주고 그데이터를 가지고 있는 노드를 찾아서 삭제
	public String remove(String item) {
		Node p = head;
		Node q = null;
		while (p != null && !p.data.equals(item)) { // p의 data와 item이 같게되면 while문 빠져나감
			q = p;
			p = p.next;
		}

		if (p == null) {// 해당 item을 데이터로 가진 노드가 존재하지 않는다면
			return null;
		}
		if (q == null) {// 첫번째에 바로 item을 가진 노드를 찾은 경우
			return removeFirst();
		} else
			return removeAfter(q); // q이후의 노드를 삭제해주고 삭제된 노드가 가지고있는 데이터를 반환해줌.
	}


	public static void main(String[] args) {
		MySingleLinkedList list = new MySingleLinkedList();

		list.add(0, "Saturday");
		list.add(1, "Friday");
		list.add(0, "Monday");
		list.add(2, "Tuesday");

		System.out.println("정상적으로 데이터를 추가하였습니다.");



		list.remove(2);
		int pos = list.indexOf("Friday");
		System.out.println("정상적으로 데이터를 삭제하였습니다");


	}

}


