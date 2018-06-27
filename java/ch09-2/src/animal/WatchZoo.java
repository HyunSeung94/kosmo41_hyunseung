package animal;

public class WatchZoo{
	public void makeTiger2() {
		//Mytiger은 public으로 선언되었으므로 어디서든 인스턴스 생성 가능
		zoo.MyTiger hosun = new zoo.MyTiger();
	}
	public void makeTiger3() {
		//Tiger는 default로 선언되었으므로 이 위치에서 인스턴스 생성 불가
		//zoo.Tiger hosun = new zoo.Tiger();  //컴파일 오류발생문장. 
	}
}