public class MyLinkedList<E> implements GenericList<E>
{
    private Node<E> head;
    private int size;
    public MyLinkedList(){
        head = new Node<E>(null);
        size= 0;
    }
    public boolean add(E obj)
    {
        Node<E> n = head;
        while(n.getNext() != null)
            n = n.getNext();
        n.setNext(new Node<E>(obj));
        size++;
        return true;
    }
    public void add(int index, E obj)
    {
        Node<E> n = new Node<E>(obj);
        Node<E> before = getNode(index-1);
        if(index <= 0)
           before = head;
        Node<E> after = before.getNext();
        before.setNext(n);
        n.setNext(after);
        size++;
        
    }
    public boolean contains(E obj){
        if(obj == null)
            return false;
        Node<E> n = head.getNext();
        while(n!=null)
        {
          if(n.getValue().equals(obj))
            return true;
          n = n.getNext();
        }
        return false;
    }
    public E get(int index){
        if(index < 0 || index > size)   
            return null;
        Node<E> n = head.getNext(); 
        int i = 0;
        while(n!=null)
        {
          i++;
          if(i == index+1)
            return n.getValue();
          n = n.getNext();
        }
        return null;
    }
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }
    public E remove(int index){
        if(isEmpty() || index >= size || index < 0)
            return null;
        Node<E> n = getNode(index);
        Node<E> before = getNode(index-1);
        if(index == 0)
            before = head;
        Node<E> after = null;
        if(n.getNext() != null)
             after = n.getNext();
        E removed = n.getValue();
        if(after == null)
            before.setNext(null);
        else
            before.setNext(after);
        size--;
        return removed;
    }
    public boolean remove(E obj){
        if(obj == null || !(contains(obj)))
            return false;
        remove(indexOf(obj));
        return true;
    }
    public E set(int index, E obj){
        if(isEmpty() || index >= size || index < 0)
            return null;
        Node<E> n = getNode(index);
        E removed = n.getValue();
        n.setValue(obj);
        return removed;
    }
    public int size(){
       return size;
    }
    private int indexOf(E obj)
    {
        int spot = 0;
        Node<E> n = head.getNext();
        while(n!=null)
        {
            if(n == null)
                return -1;
            if(n.getValue().equals(obj))
                return spot;
            spot++;
            n = n.getNext();
        }
        return -1;
    }
    private Node<E> getNode(int index)
    {
        Node<E> n = head.getNext();
        int i = 0;
        while(n.getNext()!=null&&i<index)
        {
            n = n.getNext();
            i++;
        }
        return n;
    }
    }
    class Node<E>
    {
    private E value;
    private Node<E> next;
    /**
     * Constructor for objects of class Node
     */
    public Node(E data)
    {
        value = data;
        next = null;
    }
    public E getValue()
    {
        return value;
    }
    public E setValue(E data)
    {
        value = data;
        return value;
    }
    public Node<E> getNext()
    {
        return next;
    }
    public Node<E> setNext(Node<E> node)
    {
        Node<E> removed = next;
        next = node;
        return removed;
    }
}
