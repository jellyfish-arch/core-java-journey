class MyStack {
    int[] arr;
    int top = -1;

    MyStack(int size){
        arr = new int[size];
    }

    void push(int x){
        if(top == arr.length-1) return;
        arr[++top] = x;
    }

    int pop(){
        if(top==-1) return -1;
        return arr[top--];
    }

    public static void main(String[] args){
        MyStack s = new MyStack(5);
        s.push(10); s.push(20);
        System.out.println(s.pop());
    }
}