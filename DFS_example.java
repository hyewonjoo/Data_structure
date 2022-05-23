/*
 * 전위순외,중위순회,후외순회 연습하기
 */


class Node {
	int data;
	Node lt, rt;

	public Node(int val) {// 생성자,초기화
		data = val;// 1,2,3,4,5,6,7
		lt = rt = null;
	}
}// Node


public class Q50 {
	Node root;

	public void DFS(Node root) {
		if (root == null)
			return; // 말단값=종료
		else {
			System.out.print(root.data + " ");// 전위순회
			DFS(root.lt);
			// System.out.print(root.data + " "); 중위순회
			DFS(root.rt);
			// System.out.print(root.data + " "); 후위순회
		}

	}// DFS

	public static void main(String[] args) {
		Q50 tree = new Q50();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);// 7번 정점까지 그래프 완성됨

		tree.DFS(tree.root);// tree.DFS(100번지); == tree.DFS(1번노드) 호출
	}// main

}// Q50
