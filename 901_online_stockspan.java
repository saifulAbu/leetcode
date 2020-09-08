import java.util.Stack;

class StockSpanner {
    class Entry {
        int index;
        int value;
        Entry (int i, int v){
            index = i;
            value = v;
        }
    }
    private Stack<Entry> stack;
    private int curIndex;

    public StockSpanner() {
        stack = new Stack<Entry>();
        curIndex = 0;
    }

    public int next(int price) {
        int span = 1;

        while(!stack.empty() && (stack.peek().value <= price)){
            stack.pop();
        }

        if(stack.empty()) {
            span = curIndex + 1;
        } else {
            span = curIndex - stack.peek().index;
        }
        stack.push(new Entry(curIndex, price));
        curIndex++;
        System.out.println(span);
        return span;
    }

    public static void main(String args[]) {
        StockSpanner ss = new StockSpanner();
        //["StockSpanner","next","next","next","next","next","next","next"]
        //[[],[100],[80],[60],[70],[60],[75],[85]]
        ss.next(100);
        ss.next(80);
        ss.next(60);
        ss.next(70);
        ss.next(60);
        ss.next(75);
        ss.next(85);
        //ss.next(100);
        //ss.next(100);

    }
}
