public class object1{
	String data;
	int size;

	public object1(){
		size = 0;
	}

	public object1(String input){
		data = input;
		size = 1;
	}

	public int boost(){
		return ++size;
	}

	public int getSize(){
		return size;
	}

}
