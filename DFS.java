package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DFS {

	ArrayList<Integer>[] arrayList; // 정점과의 관계를 담는 객체
	ArrayList<Integer> dfsList = new ArrayList<>(); // 방문한 순서대로 저장하기 위한 리스트
	boolean[] visited; // 정점 방문했는짗 ㅔ크하기 위한 객체

	public static void main(String[] args) {
		/*
		 * 깊이 우선 탐색 =DFS
		 * 리스트로 구현해보기
		 * 루프노드나 임의의 노드에서 시작하여 최대로 진입 할 수 있는 깊이까지 탐색한 후 돌아와 다른 노드로 탐색하는 방식
		 * 
		 */
		new DFS();
	}

	// 객체생성



	public DFS() {
		Scanner sc = new Scanner(System.in);

		System.out.println("vertex를 입력하세요");
		System.out.println("line을 입력하세요");
		System.out.println("start vertex를 입력하세요");


		int vertex = sc.nextInt();
		int line = sc.nextInt();
		int startVertex = sc.nextInt();

		arrayList = new ArrayList[vertex + 1]; // 노드가 1부터 시작하기떄문에 1 더해줌(헷갈리지 않기 위해..!!)

		for (int i = 0; i < arrayList.length; i++) {
			arrayList[i] = new ArrayList<>();
		}

		visited = new boolean[vertex + 1];

		for (int i = 0; i < line; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			arrayList[x].add(y);
			arrayList[y].add(x);
		}

		for (int i = 1; i < vertex + 1; i++) {
			Collections.sort(arrayList[i]);
		}

		dfs(startVertex); // dfs 함수 호출

		for (Integer integer : dfsList) {
			System.out.println(integer + " ");
		}
		System.out.println();
	}



	public void dfs(int x) {
		if (visited[x]) {
			return;
		}

		visited[x] = true;
		dfsList.add(x);
		for (int y : arrayList[x]) {
			if (!visited[y]) {
				dfs(y);
			}
		}
	}

}
