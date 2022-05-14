package list3;

public class Main {

	public static void main(String[] args) {


		DoublyLinkedList list = new DoublyLinkedList();

		System.out.println(list.add(0, "B"));


		System.out.println(list.add(1, "A"));


		System.out.println(list.add(0, "E"));


		System.out.println(list.addLast("D"));

		list.remove(0);
		System.out.println(list);

		list.remove(2);
		System.out.println(list);

		list.removeFirst();
		System.out.println(list);

		list.removeLast();
		System.out.println(list);

		System.out.printf("노드의 개수:%d\n", list.size());

		// System.out.printf("1번 인덱스의 값:%s", list.getData(1));
	}
}
