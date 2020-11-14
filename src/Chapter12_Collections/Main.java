package Chapter12_Collections;

import Chapter12_Collections.entity.ComparablePerson;

import java.util.*;


//1. What is a Collection ?
   /*
    - A collection is an object that contains a group of objects. A collection is also known as a container. Each object in a collection is called an element of the collection.
    - One type of collection is distinguished from another type based on the way they manage their elements
    - The Collections Framework consists of interfaces, implementation classes, and some utility classes that let you handle most types of collections that you would encounter in a Java application.
*/
//2. Need for a Collection Framework ?
   /*  - Collections are designed to work only with objects.To work with collections of primitive types, either you wrap and unwrap your primitive values in wrapper objects or you can take advantage of the built-in autoboxing features in Java that will wrap and unwrap the primitive values as needed.
    - All collection classes in Java are declared generic. That is, you can specify the type of elements that your collection deals with as the type parameter.
*/
//3. Architecture of the Collection Framework
   /*  - Interfaces: An interface represents a specific type of collection in the framework. There is one interface defined for every type of collection in the framework;
        + List, Set, Map
    - Implementation Classes: The Collections Framework provides implementations of collection interfaces, which are called implementation classes. You need to create objects of these classes that will represent a collection.
        + It is advised to write code using interfaces, rather than using their implementation classes
    - Algorithm Classes*/
//4. The Collection Interface
    /*
    - The Collection interface is the root of the collection interface hierarchy
    - It defines a generic collection
    - The Collections Framework does not provide an implementation for the Collection interface
    4.1 Methods for Basic Operations
        - int size()
        - boolean isEmpty()
        - boolean contains(Object o)
        - boolean add(E e)
        - boolean remove(Object o)
        - Iterator<E> iterator(): return an iterator that can be used to traverse elements in the collection
    4.2 Methods for Bulk Operations
        - boolean addAll(Collection<? extends E> c)
        - void clear()
        - boolean containsAll(Collection<?> c)
        - boolean removeAll(Collection<?> c)
        - boolean retainAll(Collection<?> c)
    4.3 Methods for Aggregate Operations
        - default Stream<E> stream()
        - default Stream<E> parallelStream()
    4.4 Methods for Arrays Operations
        - Object[] toArray()
        // Example 1
        - <T> T[] toArray(T[] a): return an array of the specified type T that contains all elements of the collection
            + If the passed-in arrays length is equal to or greater than the size of the collection- > all elements are copies to the
            passed-in array and the same arrays is returned. Any extra elements in the array are set to null.
            + If the passed-in arrays length is less than the size of the collection, it creates a new arrays if type T whose length is equal to the size
            of the collection, copies all elements of the collection to new arrays
    4.5 Methods for Comparison Operations*/
//5. Quick Example
//6. Traversing Collections
/*
    6.1 Using an Iterator
        - A collection provides an iterator to iterate over all its elements. Sometimes an iterator is also known as a generator or a cursor. An iterator lets you perform the following three operations on a collection:
            + Check if there are elements that have not been yet accessed using this iterator.
            + Access the next element in the collection.
            + Remove the last accessed element of the collection.
            + boolean hasNext()
            + E next()
            + default void remove()
                + removes the element of the collection that was returned last time by calling the next
            + default void forEachRemaining(Consumer<? super E> action)
    6.2 Using for-each loop
        - For-each it gets the iterator for your collection and calls the hasNext() and next() methods for you
        - For-each loop can not remove elements
        - For-each must traverse from the first element to the last element of the collection. Not start form middle
        - For-each no way to visit the previously visited elements. But iterator of some collection types such as lists

    6.3 Using forEach() method
        - Iterates over all elements and applies the action. Similar to forEachRemaining()
*/
//7. Using Different Type of Collections
/*
    7.1 Working with Sets
    - A set is mathematical concept that represents a collection of unique objects.
        + Mathematical Set
                No dup, at most one null, order is not important
                HashSet - attempt to add duplicate elements to a Set and they are ignored silently
                LinkedHashSet - return the elements in the same order the elements were inserted
        + Sorted Set
                A sorted set is a set that imposes ordering on its elements. An instance of the SortedSet interface represents a sorted set.
                Can be sorted in a natural order or using comparator
                If its elements implement the Comparable interface, it will use the compareTo() method of elements to sort them. This is called sorting in natural order.
                You cna supply a Comparator object to use a custom sorting
                TreeSet is one of the predefined implementation classes for sorted set

                subSet(E fromElement, E toElement)
                fromElement(inclusive)
                toElement(Exclusive)
                If use natural order -> NullPointerException
                If use a Comparator -> It up to use to allow a null element. if you decide whether the null element will e
                placed in the beginning or at the end of the Set
        + Navigable Set
                is a specialized type sorted set that lets you work with subsets in a variety of ways
                Let you navigate the set in reverse order - descendingSet()
                It adds another version of the three methods headSet(), tailSet(), and subSet() in SortedSet, which accept a boolean flag to include the element at the beginning or the end of the subset boundary.
                lower(): returns the greatest element in the NavigableSet that is less than the specified element.
                floor(): returns the greatest element in the NavigableSet that is less than or equal to the specified element
                higher(): method returns the least element in the NavigableSet that is greater than the specified element.
                ceiling():that is greater than or equal to a specified element.
                pollFirst() and pollLast(), that retrieve and remove the first and the last element of the NavigableSet
    7.2 Working with Lists
        - list - duplicate values , multiple null,
        - ArrayList: better get and set - slower in removing and adding
                    + Does not allow inserting an element at any arbitrary index. If the List is empty -> only 0
                    If five elements in a list -> you must use index between 0 -5 to add a new element to the List
                    -> sequence
                    + ListIterator interface adds a few more method to give you access to elements in the list from the current position in the backward direction
                        hasPrevious() - hasNext()
                        previous() - next()
                        nextIndex()- previousIndex()
        - LinkedList : better at adding and removing
    7.3 Working with Queues
    - Simple queue: insert at the tail and removal from the head
    - Priority queue: associates a priority with every element of the queue. An allows the element with the highest priority to be
      removed next from the queue
    - Delay queue: associated a delay with every element of the queue and allows for the removal of the element only when its delay has elapsed
    - Doubly ended queue: allows for the insertion and removal of its elements from the head as well as the tail
    - A blocking queue: block the thread that adds elements to it when it is full and it blocks the thread removing elements from it when it is empty
    - A transfer queue: a special type of blocking queue where a handoff of an object occurs between twi threads(a producer and a consumer)
    - A blocking doubly ended queue: is combination of doubly ended queue and blocking queue

    add() - Not okay -> throws an exception
    offer() - Not okay -> not throws an exception
    remove() - retrieves and removes the head of the queue -> throw exception if queue is empty
    poll() - same with remove but it returns null if the queue is empty
    element() - retrieves the head of the queue without without removing it from the queue - throw exception if queue is empty
    peek()  -  the same with element but not throw an exception

    Implementation class for the Queue interface:
    - LinkedList
    - PriorityQueue
    Example 2
        + Queue is never used to iterate over its elements. Rather it is used to remove one element from it, process that element and then remove another element.
        + Priority Queue does not guarantee any ordering of the elements when you an iterator
        + However, when we use the peek() or remove(), the correct element is peeked at or removed, which based on the element's priority.
    Example 3 Using Comparator

    Double Ended Queues
    - Dequeue does not mean opposite of Queue, rather it means "Double Ended Queue". It is pronounced "Deck" not "De Queue"
    - Declares additional methods to facilitate all the operations for queue at the head as well as at the tail.
    -> It can be used as a FIFO queue or LIFO queue
    addFirst(), addLast() throw an exception
    offerFirst(), offerLast() not throw an exception
    Blocking Queue
    - When you want to add an element to it when it is full
    - When you want to remove an element from it when it is empty
        + ArrayBlockingQueue
        + LinkedBlockingQueue
        + PriorityBlockingQueue
        + SynchronousQueue
        + DelayQueue
        Example 4
    7.4 Working with Maps
*/
//8. Applying Algorithms to Collections
/*
    8.1 Sorting a List
    8.2 Searching a List
    8.3 Shuffling, Revering, Swapping and Rotating a list
*/
//9. Creating Different Views of a Collection
/*
    9.1 Read-Only Views of Collections
    9.2 Synchronized Views of a Collection
    9.3 Checked Collections
*/
//10. Creating Empty Collections
//11. Creating Single Collections
//12. Understanding Hash-Bases Collections

public class Main {
    public static void main(String[] args) {
        // Test List
        List<String> list = new ArrayList<>();
        list.add("John");
        list.add("Richard");
        list.add("Donna");
        list.add("Ken");

        System.out.println("List: " + list);

        // Get the list iterator
        ListIterator<String> iterator = list.listIterator();

        System.out.println();
        System.out.println("List Iterator in forward direction:");
        while (iterator.hasNext()) {
            int index = iterator.nextIndex();
            String element = iterator.next();
            System.out.println("Index=" + index + ", Element=" + element);
        }

        System.out.println();
        System.out.println("List Iterator in backward direction:");

        // Reuse the iterator to iterate from the end to the beginning
        while (iterator.hasPrevious()) {
            int index = iterator.previousIndex();
            String element = iterator.previous();
            System.out.println("Index=" + index + ", Element=" + element);
        }

        // Example 2
        Queue<ComparablePerson> pq = new PriorityQueue<>();
        pq.add(new ComparablePerson(1, "John"));
        pq.add(new ComparablePerson(4, "Ken"));
        pq.add(new ComparablePerson(2, "Richard"));
        pq.add(new ComparablePerson(3, "Donna"));
        pq.add(new ComparablePerson(4, "Adam"));

        System.out.println("Priority queue: " + pq);
        while (pq.peek() != null) {
            System.out.println("Head Element: " + pq.peek());
            pq.remove();
            System.out.println("Removed one element from Queue");
            System.out.println("Priority queue: " + pq);
        }

        Comparator personComparator = Comparator.comparing(ComparablePerson::getName);
        Queue<ComparablePerson> nameComparablePersonQueue = new PriorityQueue<>(personComparator);




    }
}
