package com.test.iterator;

import java.util.Iterator;

/**
* @author 作者 E-mail:
* @version 创建时间：2022年5月24日 上午10:41:01
* 类说明
* 
* 迭代器模式。
* 
*/

class MyIterable3{
	private int dataArr[];// 1.可迭代对象本身拥有数据集合。
	
	//2.通过可迭代对象可以获得迭代器.
	//a.可以作为内部类
	class MyIterator3{
		int idx = 0;
		public boolean hasNext() {
			if(idx >= dataArr.length)
				return false;
			return true;
		}
		public int next() {
			return dataArr[idx++];
		}
	}
	public MyIterator3 getIterator() {
		return new MyIterator3(); //可以每次都获取新的实例的
 	}
	
	public MyIterable3(int arr[]) {
		dataArr = arr;
	}
	public int[] getData() {
		return dataArr;
	}
}



//使用java语法层面的迭代器 可迭代对象。 更方便，简洁。
//MyIterable33 才能称为java中的可迭代对象。
class MyIterable33 implements Iterable<Integer>{
	private int dataArr[];// 1.可迭代对象本身拥有数据集合。
		
	public MyIterable33(int arr[]) {
		dataArr = arr;
	}
	public int[] getData() {
		return dataArr;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {
			int idx = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if(idx >= MyIterable33.this.dataArr.length)
					return false;
				return true;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return dataArr[idx++];
			}
		};
	}
}
