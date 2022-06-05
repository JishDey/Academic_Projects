// Implements a singly-linked list.

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Object>
{
  private ListNode head;
  private int nodeCount;

  // Constructor: creates an empty list
  public SinglyLinkedList()
  {
    head = null;
    nodeCount = 0;
  }

  // Constructor: creates a list that contains
  // all elements from the array values, in the same order
  public SinglyLinkedList(Object[] values)
  {
    ListNode tail = null;
    for (Object value : values) // for each value to insert
    {
      ListNode node = new ListNode(value, null);
      if (head == null)//if no elements have been added yet
        head = node;//set this element as the head
      else//if the list is not empty
        tail.setNext(node);//append from the tail
      tail = node;    // update tail
    }

    nodeCount = values.length;//set nodeCount once all elements have been added
  }

  // Returns true if this list is empty; otherwise returns false.
  public boolean isEmpty()
  {
      return nodeCount == 0;//if no nodes, list is empty
  }

  // Returns the number of elements in this list.
  public int size()
  {
      return nodeCount;//nodeCount is the size of the list
  }

  // Returns true if this list contains an element equal to obj;
  // otherwise returns false.
  public boolean contains(Object obj)
  {
      return indexOf(obj) != -1;//return true if obj is found in indexOf method
  }

  // Returns the index of the first element in equal to obj;
  // if not found, retunrs -1.
  public int indexOf(Object obj)
  {
      int index = 0;//begin searching at index 0
      for(ListNode ln = head; ln != null; ln = ln.getNext())//iterate through each node
      {
         if(ln.getValue().equals(obj))//if current position holds obj
            return index;//return this position
         index++;//increment current index
      }
      return -1;//if obj is not found, return -1
  }

  // Adds obj to this collection.  Returns true if successful;
  // otherwise returns false.
  public boolean add(Object obj)
  {
      ListNode ln = new ListNode(obj);//ListNode to traverse nodes to find tail
      if(head != null)//if the list is not empty
      {
         for(ln = head; ln.getNext() != null; ln = ln.getNext());//traverse nodes to find tail
         ln.setNext(new ListNode(obj));//point the tail to new ListNode
      }
      else
         head = new ListNode(obj);
      
      nodeCount++;
      return true;
  }

  // Removes the first element that is equal to obj, if any.
  // Returns true if successful; otherwise returns false.
  public boolean remove(Object obj)
  {
      if (obj.equals(head.getValue()))
      {
         ListNode temp = head.getNext();
         head.setNext(null);
         head = temp;
         nodeCount--;
         return true;
      }
      
      for(ListNode ln = head; ln != null; ln = ln.getNext())
      {
         if(obj.equals(ln.getNext().getValue()))
         {
            ListNode temp = ln.getNext().getNext();
            ln.getNext().setNext(null);
            ln.setNext(temp);
            nodeCount--;
            return true;
         }
      }
      return false;
  }

  // Returns the i-th element.
  public Object get(int i)
  {   
      if (i > nodeCount-1)
         return null;
      
      ListNode ln = head;
      
      for(int j = 0; j < i; j++)
         ln = ln.getNext();
      
      return ln.getValue();
  }

  // Replaces the i-th element with obj and returns the old value.
  public Object set(int i, Object obj)
  {
      if (i > nodeCount-1)
         return null;
      
      ListNode ln = head;
      
      for(int j = 0; j < i; j++)
         ln = ln.getNext();
      
      Object oldValue = ln.getValue();
      ln.setValue(obj);
      return oldValue;
  }

  // Inserts obj to become the i-th element. Increments the size
  // of the list by one.
  public void add(int i, Object obj)
  {   
      if (i > nodeCount+1)
         return;
      
      ListNode ln = new ListNode(obj);
      
      if (i == 0)
      {
         ln.setNext(head);
         head = ln;
      }
      
      ListNode prev = head;
      
      for(int j = 0; j < i-1; j++)
         prev = prev.getNext();
      
      ListNode next = prev.getNext();
      
      prev.setNext(ln);
      ln.setNext(next);
      
      nodeCount++;
  }

  public ListNode rotate(){
   ListNode hold = head;
   head = head.getNext();
   ListNode temp;
   for(temp = head; temp.getNext() != null; temp = temp.getNext());//freeses
   temp.setNext(hold);
   return head;
  }

  public ListNode insertInOrder(String s){
     ListNode temp = head;
   for(temp = head; s.compareTo(temp.getNext().getValue().toString()) > 0 && temp.getNext() != null; temp = temp.getNext());
     ListNode fonsert = new ListNode(s, temp.getNext());
     temp.setNext(fonsert);
     return fonsert;
  }

  // Removes the i-th element and returns its value.
  // Decrements the size of the list by one.
  public Object remove(int i)
  {
      if (i > nodeCount-1)
         return null;
      else if (i == 0)
      {
         ListNode temp = head;
         head = head.getNext();
         temp.setNext(null);
         return temp.getValue();
      }
      
      ListNode prev = head;
      
      for(int j = 0; j < i-1; j++)
         prev = prev.getNext();
      
      ListNode nodeToRemove = prev.getNext();
      prev.setNext(nodeToRemove.getNext());
      nodeToRemove.setNext(null);
      
      nodeCount--;
      return nodeToRemove.getValue();
  }

  // Returns a string representation of this list.
  public String toString()
  {
      String str = "[";//begin string with bracket
      ListNode ln;//variable to broaden scope of ln beyond the for loop
      for(ln = head; ln.getNext() != null; ln = ln.getNext())//iterate through each node, check two spaces away because of comma
      {
         str += ln.getValue().toString() + ", ";//add the toString of the node's value and a comma and space
      }
      return str + ln.getValue().toString() + "]";//add the last element and a bracket
  }

  // Returns an iterator for this collection.
  public Iterator<Object> iterator()
  {
    return new SinglyLinkedListIterator(head);
  }
  
}

