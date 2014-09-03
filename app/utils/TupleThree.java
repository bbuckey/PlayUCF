package utils;

import utils.Tuple;

public class TupleThree<A,B,C> extends Tuple<A,B> {

	C thirdObj;
	
	public TupleThree(A a, B b, C c){
		super(a,b);
		thirdObj = c;
	}
	
	public C getThridObject(){
		return thirdObj;
	}
	
	public void setThridObject(C c){
		thirdObj = c;
	}
	
	
}
