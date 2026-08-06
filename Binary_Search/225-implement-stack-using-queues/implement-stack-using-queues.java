class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = q.size();
        q.add(x);
        // Rotate the line!
        for (int i = 0; i < size; i++) {
            int personAtFront = q.remove();
            q.add(personAtFront);        
        }
    }
    
    public int pop() {
        return q.poll(); // or q.remove()
    }
    
    public int top() {
        return q.peek(); 
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}