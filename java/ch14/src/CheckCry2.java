interface Animal1 {
	void cry();
}

class Cat2 implements Animal1 {
	public void cry() {
		System.out.println("야옹~");
	}
}

class Dog2 implements Animal1 {
	public void cry() {
		System.out.println("멍멍!");
	}
}

class CheckCry2 {

	public static void main(String[] args) {
		Cat2 cat = new Cat2();
		Dog2 dog = new Dog2();
		
		checkAnimal(cat);
		checkAnimal(dog);
	}
	
	public static void checkAnimal(Animal1 animal) {
		
		if(animal instanceof Cat2)
		{
			System.out.println("고양이");
			animal.cry();
		}
		if(animal instanceof Dog2)
		{
			System.out.println("강아지");
			animal.cry();
		}

	}

}