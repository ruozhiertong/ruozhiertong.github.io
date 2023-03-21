package com.test.iterator;

import com.test.iterator.MyIterable4.MyIterator4;

/**
* @author 作者 E-mail:
* @version 创建时间：2022年5月24日 上午10:41:01
* 类说明
* 
* 迭代器模式。
* 
*/
public class TestIterator {
	
	public static void main(String[] args) {
		
		
		//对外接口使用。
		
		MyIterable iterObj = new MyIterable(new int[] {1,2,3,4});
		MyIterator iterator =  iterObj.getIterator();
		
		//step 3.通过迭代器对象，迭代访问可迭对象(或者说可迭代对象中的数据集合).
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		
		MyIterable4<Integer> iterObj4 = new MyIterable4<Integer>(new Integer[] {1,2,3,4});
		
		MyIterator4 iterator4 = iterObj4.getIterator();
		
		
		//3.通过迭代器对象，迭代访问可迭对象(或者说可迭代对象中的数据集合).
		while(iterator4.hasNext()) {
			System.out.println(iterator4.next());
		}
		
		
		
	}
}


//设计。
//不用java语法层面做的迭代器模式。 可迭代对象， 迭代器。 （类同于C的设计。）
//MyIterable MyIterator 最一般 最朴素的设计。（类同于C的设计。）
//MyIterable MyIterator 在java中并不能具体称之为可迭代对象，迭代器，仅仅是用迭代器模式。 C中因为没有语法支持，广义上可以称为迭代器 可迭代对象。
//Java中可迭代对象 具体是指实现Iterable接口。 迭代器 具体是指 实现Iterator接口。
class MyIterable{
	private int dataArr[];// step 1.可迭代对象本身拥有数据集合。
	
	private MyIterator iter; // step 2.通过可迭代对象可以获得迭代器. 持有迭代器对象引用，或者本身拥有迭代器对象。
	//迭代器的设计可以有多重方式，
	//a.可以作为内部类，因为迭代器本身要能访问到可迭代对象(或者说可迭代对象中的数据集合)
	//b.可以直接一般类，这时候要持有可迭代对象的引用。（因为要能访问到可迭代对象）
	public MyIterable(int arr[]) {
		dataArr = arr;
		iter = new MyIterator(this);
	}
	public int[] getData() {
		return dataArr;
	}
	
	public MyIterator getIterator() {
		return iter;
	}
}

class MyIterator{
	private MyIterable myiterable; //相互引用。 其实不是很好的设计。尽量少用。
								//我们目的是为了能获取或能访问可迭代对象(或可迭代对象中的数据集合)， 可以通过内部类的改进 取消相互引用。
	int idx = 0; //维护指针。
	public MyIterator(MyIterable iter) {
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


//还有另外的设计，将可迭代对象和迭代器糅合在一起。
//比如下面这种。 MyArrayList实际上承担可迭代对象和迭代器的功能。
class MyArrayList {
    private String[] elem = {"a","b","c","d","e","f","g"};
    private int size = elem.length;
    private int curror = -1;
    
    /**
     * 判断是否存在下一个元素
     * @return
     */
    public boolean hasNext() {
        return curror+1 < size; //指向下一个元素 
    }
    
    /**
     * 获取下一个元素
     */
    public String next() {
        curror++;         //移动一次
        return elem[curror];
    }
    
    
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        while(list.hasNext()) {
            System.out.println(list.next());
        }
    }
    
}
