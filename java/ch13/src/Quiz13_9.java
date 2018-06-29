//문제 9
//배열에 210, 19, 72, 129, 34  순서대로 데이터를 입력하고 데이터를
//정렬하시오.

public class Quiz13_9 {

	public static void main(String[] args) {
		int arr[] = { 210,19,72,129,34};
		int temp = 0;		//비교값 저장할 temp 생성
		for(int i=0; i<5; i++) {  //데이터 정렬 반복문 
			System.out.println(arr[i] +"arr[i]의값");
			for(int j=0; j<5; j++) {
				System.out.println(arr[i] +"!!arr[i]의값");
				System.out.println(arr[j] +"!!arr[j]의값");
				if(arr[i]<arr[j]) {//i가 j보다 작을경우 
				temp = arr[i];      //temp에 i저장
				arr[i] = arr[j];    //num[i]값에 num[j]값 저장
				arr[j] = temp;      //temp값을 num[j]에 저장
				}
			}

		}
		for (int i =0; i<5; i++) {   //출력반복문  
			System.out.println(arr[i]);
			
		}

	}

}
