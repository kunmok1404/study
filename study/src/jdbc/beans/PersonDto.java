package jdbc.beans;

public class PersonDto {
		private int no;
		private String name;
		private String id;
		private String pw;
		private int point;
		private String when;
		
		public PersonDto() {
			super();
		}

		@Override
		public String toString() {
			return "PersonDto [no=" + no + ", name=" + name + ", id=" + id + ", pw=" + pw + ", point=" + point + ", when="
					+ when + "]";
		}
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public int getPoint() {
			return point;
		}
		public void setPoint(int point) {
			this.point = point;
		}
		public String getWhen() {
			return when;
		}
		public void setWhen(String when) {
			this.when = when;
		}
	}
