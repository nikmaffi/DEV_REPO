public class DateTime {
	private static final int MAX_MONTH = 12;
	private static final int[][] DAY_MONTH_TABLE = {
			{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
			{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
	};
	
	private int day;
	private int month;
	private int year;
	
	public DateTime(int day, int month, int year) throws Exception {
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	
	public int getDay() {
		return this.day;
	}

	public void setDay(int day) throws Exception {
		int max = 0;
		int leap = this.isLeap() ? 1 : 0;
		
		max = DateTime.DAY_MONTH_TABLE[leap][this.month];
		
		if(day <= 0 || day > max) {
			throw new Exception("Error: Day must be between 1 and " + max + "!");
		}
		
		this.day = day;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) throws Exception {
		if(month <= 0 || month > DateTime.MAX_MONTH) {
			throw new Exception("Error: Month must be between 1 and " + DateTime.MAX_MONTH + "!");
		}
		
		this.month = month;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) throws Exception {
		if(year < 0) {
			throw new Exception("Error: Year must be positive!");
		}
		
		this.year = year;
	}

	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	public boolean isLeap() {
		return this.year % 400 == 0 || (this.year % 4 == 0 && this.year % 100 != 0);
	}
	
	public boolean greaterThan(DateTime dt) {		
		if(this.year > dt.year) {
			return true;
		} else if(this.year < dt.year) {
			return false;
		} else {
			if(this.month > dt.month) {
				return true;
			} else if(this.month < dt.month) {
				return false;
			} else {
				if(this.day > dt.day) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	public DateTime add(int numOfDays) throws Exception {
		int day = this.day;
		int month = this.month;
		int year = this.year;
		int leap = this.isLeap() ? 1 : 0; 
		
		if(numOfDays < 0) {
			throw new Exception("Error: Number of days must be positive!");
		}
		
		day += numOfDays;
		while(day > DateTime.DAY_MONTH_TABLE[leap][month]) {
			if(day > DateTime.DAY_MONTH_TABLE[leap][month]) {
				day -= DateTime.DAY_MONTH_TABLE[leap][month];
				month++;
			}
			
			if(month > DateTime.MAX_MONTH) {
				month -= DateTime.MAX_MONTH;
				year++;
				leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 1 : 0;
			}
		}
		
		return new DateTime(day, month, year);
	}
	
	public int sub(DateTime dt) throws Exception {
		int days = 0;
		int month = 0;
		int year = 0;
		int leap = 0;
		
		if(dt.greaterThan(this)) {
			throw new Exception("Errore: Date " + dt.toString() + " must be less than " + this.toString() + "!");
		}
		
		days = this.day;
		month = this.month - 1;
		year = this.year;
		leap = this.isLeap() ? 1 : 0;
		while(year != dt.year || month != dt.month) {
			days += DateTime.DAY_MONTH_TABLE[leap][month--];
			
			if(month < 1) {
				month += DateTime.MAX_MONTH;
				year--;
				leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 1 : 0;
			}
		}
		
		days += DateTime.DAY_MONTH_TABLE[leap][month] - dt.day;
		
		return days;
	}
}