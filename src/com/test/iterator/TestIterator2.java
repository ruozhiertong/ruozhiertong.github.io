package com.test.iterator;
/**
* @author 作者 E-mail:
* @version 创建时间：2022年5月24日 上午10:41:01
* 类说明
* 
* 迭代器模式。
* 
*/

class MyIterable2{
	private int dataArr[];// 1.可迭代对象本身拥有数据集合。
//	private MyIterator2 iter; //2.通过可迭代对象可以获得迭代器. 改进1，直接通过方法来获得新的实例，而且不仅仅只维护一个实例
	public MyIterable2(int arr[]) {
		dataArr = arr;
//		iter = new MyIterator2(this);
	}
	public int[] getData() {
		return dataArr;
	}
	
	public MyIterator2 getIterator() {
//		return iter;
		return new MyIterator2(this); //可以每次都获取新的实例的
 	}
	
	

}

class MyIterator2{
	private MyIterable2 myiterable; //相互引用。 其实不是很好的设计。
	int idx = 0; //维护指针。
	public MyIterator2(MyIterable2 iter) {
		myiterable = iter;
		idx = 0;
	}
	public boolean hasNext() {
		if(idx >= myiterable.getData().length)
			return false;
		return true;
	}
	
	public int next() {
		return myiterable.getData()[idx++];
	}
	
}
