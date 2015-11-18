package zhy2002.leetcode.additional.rivercrossing;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://en.wikipedia.org/wiki/Bridge_and_torch_problem
 * Four people come to a river in the night. There is a narrow bridge, but it can only hold two people at a time.
 * They have one torch and, because it's night, the torch has to be used when crossing the bridge.
 * Person A can cross the bridge in one minute, B in two minutes, C in five minutes, and D in eight minutes.
 * When two people cross the bridge together, they must move at the slower person's pace.
 * The question is, can they all get across the bridge in 15 minutes or less?
 */

class State implements Comparable<State>{

    public List<Integer> left = new ArrayList<>();
    public List<Integer> right = new ArrayList<>();
    public int timeSoFar = 0;
    public boolean goBack = false;
    public State previousState;

    @Override
    public int compareTo(State o) {
        return this.timeSoFar - o.timeSoFar;
    }

    public State duplicate(){
        State clone = new State();
        clone.left.addAll(this.left);
        clone.right.addAll(this.right);
        clone.timeSoFar =this.timeSoFar;
        clone.goBack = this.goBack;
        clone.previousState = this;
        return clone;
    }

    @Override
    public String toString() {
        return this.left.toString() + (this.left.size() == 0 ? "  " : this.goBack ? "<-" : "->") + this.right;
    }
}
public class Solution {

    public int minTime(int[] times){
        State initialState = new State();
        for(int i=0; i<times.length; i++){
            initialState.left.add(i);
        }
        return search(initialState, times);

    }

    private int search(State state, int[] times) {
        PriorityQueue<State> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(state);
        while (!priorityQueue.isEmpty()){
            State minState = priorityQueue.poll();
            if(minState.left.size() == 0){
                printStrategy(minState);
                return minState.timeSoFar;
            } else {
                if(minState.goBack){
                  for(int i=0; i<minState.right.size(); i++){
                      State newState = minState.duplicate();
                      newState.left.add(newState.right.get(i));
                      newState.timeSoFar += times[newState.right.get(i)];
                      newState.right.remove(i);
                      newState.goBack = false;
                      priorityQueue.add(newState);
                  }
                } else {
                  for(int i=0; i<minState.left.size(); i++){
                      for(int j=i+1; j<minState.left.size(); j++){
                          int cross1 = minState.left.get(i);
                          int cross2 = minState.left.get(j);
                          State newState = minState.duplicate();
                          newState.right.add(cross1);
                          newState.right.add(cross2);
                          newState.timeSoFar += Math.max(times[cross1], times[cross2]);
                          newState.left.remove(j);
                          newState.left.remove(i);
                          newState.goBack = true;
                          priorityQueue.add(newState);
                      }
                  }
                }
            }

        }
        return -1;
    }

    private void printStrategy(State minState) {
        System.out.println("Printing solution:");
        Stack<State> stack = new Stack<>();
        while (minState != null){
            stack.push(minState);
            minState = minState.previousState;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
