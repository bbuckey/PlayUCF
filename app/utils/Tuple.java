package utils;

public class Tuple<A,B>{
	A a;
	B b;
	
	public Tuple(){
	}
	
	public Tuple(A _a , B _b){
		a = _a;
		b = _b;
	}
	
	public A getFirstObject(){
		return a;
	}
	
	public B getSecondObject(){
		return b;
	}
	
	public void setFirstObject(A _a){
		a = _a;
	}
	
	public void setSecondObject(B _b){
		b = _b;
	}
	
	
}
