
public class stringchecker {
	public class codewordchecker {
		int s = 6;
		int e = 20;
		String a;

		public codewordchecker(int s, int e, String a) {
			this.s = s;
			this.e = e;
			this.a = a;
		}

		public codewordchecker(String a) {
			this.a = a;
		}

		public boolean isvalid(String a) {
			if(a.length() >= this.s && a.length() <= this.e && !a.contains(this.a)) {
				return true;
			}
			return false;
		}
	}
}
