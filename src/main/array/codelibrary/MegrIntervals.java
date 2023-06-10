package main.array.codelibrary;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;

public class MegrIntervals {
   static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public void mergeIntervals(List<Interval> intervalList){
        Stack<Interval> stack = new Stack<>();
        stack.push(new Interval(intervalList.get(0).start,intervalList.get(0).end));

        for (int i = 1; i < intervalList.size() ; i++) {
            Interval top = stack.peek();
            int f = top.start;
            int e = top.end;
            Interval current = intervalList.get(i);
            int fc = current.start;
            int fe = current.end;

            if(e < fc){
                stack.push(current);
            }else {
                stack.pop();
                e = Math.max(e,fe);
                stack.push(new Interval(f,e));
            }
        }
        while (!stack.isEmpty()){
            System.out.println("["+stack.peek().start+","+stack.peek().end+"]");
            stack.pop();
        }
    }
}


