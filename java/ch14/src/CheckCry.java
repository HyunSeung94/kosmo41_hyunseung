interface Cry {
	void cry();
}

class Cat1 implements Cry {
	public void cry() {
		System.out.println("야옹~");
	}
}

class Dog1 {
	public void cry() {
		System.out.println("멍멍!");
	}
}

class CheckCry {

	public static void main(String[] args) {
		Cat1 cat = new Cat1();
		Dog1 dog = new Dog1();
		
		if(cat instanceof Cry)
		{
			cat.cry();
		}
		if(dog instanceof Cry)
		{
			dog.cry();
		}

	}

}
