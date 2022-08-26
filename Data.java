package com.finzly.demo1st;



public class Data {
	
		int id;
		String dept,div,name,year;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public String getDiv() {
			return div;
		}
		public void setDiv(String div) {
			this.div = div;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		
		
		
		public Data(int id, String dept, String div, String name, String year) {
			super();
			this.id = id;
			this.dept = dept;
			this.div = div;
			this.name = name;
			this.year = year;
		}
		@Override
		public String toString() {
			return "Data [id=" + id + ", dept=" + dept + ", div=" + div + ", name=" + name + ", year=" + year + "]";
		}
		
		
}
