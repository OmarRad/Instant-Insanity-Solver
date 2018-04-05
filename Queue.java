/**
 * Queue Abstract Data Type. A Queue is a linear data structure
 * following first-in-first-out protocol, i.e. the first element
 * that has been added onto the Queue, is the first one to
 * be removed.
 *
 * @author Ahmed Gawish
 */
 interface Queue<E>{
    /**
     * Enqueues an element onto the rear of the queue
     *
     * @param item the element be put onto the rear of this queue.
     */
   void enqueue(E item);

   /**
     * Removes and returns the element at the front of this queue.
     *
     * @return The front element of this queue.
     */
   E dequeue();

   /**
     * Tests if this Queue is full.
     *
     * @return true if this Queue is full; and false otherwise.
     */
   boolean isFull();

    /**
     * Tests if this Queue is empty.
     *
     * @return true if this Queue is empty; and false otherwise.
     */
   boolean isEmpty();
 }
