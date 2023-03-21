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

//演进过程 TestIterator1 -> TestIterator2 -> TestIterator3 -> TestIterator4
class MyIterable4<T> {
	private T dataArr[];// 1.可迭代对象本身拥有数据集合。
	class MyIterator4{
		int idx = 0;
		public boolean hasNext() {
			if(idx >= dataArr.length)
				return false;
			return true;
		}
		public T next() {
			return dataArr[idx++];
		}
	}
	public MyIterator4 getIterator() {
		return new MyIterator4(); //可以每次都获取新的实例的
 	}
	
	public MyIterable4(T arr[]) {
		dataArr = arr;
	}
	public T[] getData() {
		return dataArr;
	}
}



//使用java语法层面的迭代器 可迭代对象.
// implements 后的T 实际上前面的T的应用。 内部类中的T也类似。
class MyIterable44 <T> implements Iterable<T>{
	private T dataArr[];// 1.可迭代对象本身拥有数据集合。
		
	public MyIterable44(T arr[]) {
		dataArr = arr;
	}
	public T[] getData() {
		return dataArr;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		//内部类中的T是外部类T的应用，不是新的类型T。
		return new Iterator<T>() {
			int idx = 0;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				if(idx >= MyIterable44.this.dataArr.length)
					return false;
				return true;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return dataArr[idx++];
			}
		};
	}
}
