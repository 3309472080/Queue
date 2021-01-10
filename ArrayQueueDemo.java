package duilie;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //实例化队列类
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("请输入");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输出一个数字");
                    int value = scanner.nextInt();
                    try{
                        arrayQueue.addQueue(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    System.out.println(arrayQueue.headQueue());
                    break;
                case 'e':
                    loop = false;
            }
        }

    }
}
//使用数组模拟队列-编写一个ArrayQueue类
class  ArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int arr[];//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue (int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部，分析出front是指向的列头的前一个位置
        rear = -1;//指向队列列尾，指向队列尾的数据（即就是队列最后一个数）
    }

    //判断队列是否满
    public boolean isFull(){
        /*例:若数组长度为7，数组下标则为6，rear = -1，加一个数则为0，加7个数就为6，
        当rear=6时，数组就满了，而maxSize=7，所以需要-1
        */
        return rear == maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不加入数据");
        }
        rear++;
        arr[rear] = n;
    }
    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空，无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);//第一个i = [%d],第二个arr[i] = %d
        }
    }
    //显示队列的头数据，不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return arr[front+1];
    }
}