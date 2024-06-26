package data_structures

data class Node<T>(var value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

class LinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty list"
        } else {
            return head.toString()
        }
    }

    // Adding a Node to the
    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }
    fun append(value:T){
        if(isEmpty()){
            push(value)
        }
        tail?.next = Node(value=value)
        tail = tail?.next
        size++
    }

    fun findNodeAt(index:Int): Node<T>? {
        var currentNode = head
        var count = 0

        while (currentNode != null && count < index){
            currentNode = currentNode.next
            count++
        }
        return currentNode
    }

    fun isPalindrome(): Boolean {
        if (isEmpty()) {
            return true // An empty list is considered a palindrome
        }

        // Use two pointers approach to find the middle of the list
        var slow = head
        var fast = head
        val stack = java.util.Stack<T>()

        while (fast != null && fast.next != null) {
            stack.push(slow!!.value)
            slow = slow!!.next
            fast = fast.next!!.next
        }

        // If the list has odd number of elements, skip the middle element
        if (fast != null) {
            slow = slow!!.next
        }

        // Compare the remaining elements with the popped elements from stack
        while (slow != null) {
            val top = stack.pop()
            if (top != slow.value) {
                return false // Not a palindrome
            }
            slow = slow.next
        }

        return true
    }
}

