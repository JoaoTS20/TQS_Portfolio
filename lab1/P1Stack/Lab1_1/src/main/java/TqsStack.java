import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack <T>{
    private ArrayList<T> stack;
    private int bound =-1;

    public TqsStack(){
        this.stack = new ArrayList<>();
    }
    public TqsStack(int bound){
        this.stack = new ArrayList<>();
        this.bound=bound;
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }

    public int size(){
        return this.stack.size();
    }

    public T pop(){
        if (this.stack.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
        return this.stack.remove(stack.size()-1);
        }
    }

    public void push(T t){
        if(this.bound==-1){
            this.stack.add(t);
        }
        else{
            if(this.stack.size()< bound){
                this.stack.add(t);
            }
            else{
                throw new IllegalStateException();
            }
        }

    }

    public T peek(){
        if (this.stack.isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return this.stack.get(stack.size()-1);
        }
    }


}
