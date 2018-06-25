//필드접근
//class는 이예문만 이해할수있으면 된다. 
class Wdata
{
	int month;
	int day;
	String sky;
}
class Weather
{
	public static void main(String[] args)
	{
		Wdata today = new Wdata();
		today.month = 10;
		today.day = 5;
		today.sky = "맑음";
		
		System.out.println(today.month + "월" +
		                   today.day + "일 " + 
				           today.sky);
	}
}
