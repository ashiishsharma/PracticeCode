/**
 * Implement a stack with push/pop and find minimum in O(1) time
 *
 *
 *
 * Using a linked list store the current minimum value. When you add a new number it looks at the previous min and changes the current min to the current value if the current value is lower.

 E.g... Assume you have the data: 3, 6, 4, 2, 7, 1. Then this is what the list would look like

 value|min

 3|3 -> 6|3 -> 4|3 -> 2|2 -> 7|2 -> 1|1
 That'll keep track of the mins as you push/pop items. Granted you'll need to have a root node and a node designated as a "footer" so you can access the end in O(1).

 Or you could go backwards with it and add things to the front and change the root node every insert... that would work too. It would be something like this:

 1|1 -> 7|2 -> 2|2 -> 4|3 -> 6|3 -> 3|3
 Then you wouldn't need the "footer" node.

 Both of these will keep track of the current min value for when the value was pushed. That way when the actual min value is pushed, it will know what the second min value was in O(1)
 */
public class FindMinInStackInOrder1 {


}
