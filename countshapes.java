import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class countshapes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int q = 0; q < 5; q++) {
			int c = Integer.parseInt(br.readLine());
			int r = Integer.parseInt(br.readLine());
			int[][] map = new int[r][c];
			for (int i = 0; i < r; i++) {
				String s = br.readLine();
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == 'X') {
						map[i][j] = -1;
					} else {
						map[i][j] = 0;
					}
				}
			}
			int shapecount = 1;
			LinkedList<Integer> rqueue = new LinkedList<Integer>();
			LinkedList<Integer> cqueue = new LinkedList<Integer>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] == -1) {
						rqueue.add(i);
						cqueue.add(j);
						while (!rqueue.isEmpty()) {
							int curr = rqueue.poll();
							int curc = cqueue.poll();
							map[curr][curc] = shapecount;
							try {
								if (map[curr - 1][curc] == -1) {
									rqueue.add(curr - 1);
									cqueue.add(curc);
								}
							} catch (Exception e) {
							}
							try {
								if (map[curr + 1][curc] == -1) {
									rqueue.add(curr + 1);
									cqueue.add(curc);
								}
							} catch (Exception e) {
							}
							try {
								if (map[curr][curc - 1] == -1) {
									rqueue.add(curr);
									cqueue.add(curc - 1);
								}
							} catch (Exception e) {
							}
							try {
								if (map[curr][curc + 1] == -1) {
									rqueue.add(curr);
									cqueue.add(curc + 1);
								}
							} catch (Exception e) {
							}
						}
						shapecount++;
					}
				}
			}
			System.out.println("In rectangle #" + q + " are " + (shapecount - 1) + " shapes");
		}
	}
}
