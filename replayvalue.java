import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class replayvalue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int towncount = Integer.parseInt(br.readLine());
		int[] difficulty = new int[towncount + 1];
		ArrayList<Integer>[] map = new ArrayList[towncount + 1];
		for (int i = 1; i <= towncount; i++) {
			map[i] = new ArrayList<Integer>();
			difficulty[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < towncount - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (difficulty[a] > difficulty[b]) {
				map[a].add(b);
			} else if (difficulty[a] < difficulty[b]) {
				map[b].add(a);
			} else {
				map[a].add(b);
				map[b].add(a);
			}
		}
		int paths = 0;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= towncount; i++) {
			for (int j = 1; j <= towncount; j++) {
				if (j != i) {
					System.out.println(paths);
					queue.add(j);
					while (!queue.isEmpty()) {
						int curtown = queue.poll();
						if (curtown == i) {
							paths++;
						} else {
							for (int k = 0; k < map[curtown].size(); k++) {
								queue.add(map[curtown].get(k));
							}
						}
					}
				}
			}
		}
		System.out.println(paths);
	}
}
