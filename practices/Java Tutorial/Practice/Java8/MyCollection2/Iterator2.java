package Java8.MyCollection2;

/**
 * Iterator2
 */
interface Iterator {
    boolean hasNext();
    int next() throws Exception;
    void remove();
}

// interface Iterable {
//     Iterator iterator();
// }

class IteratorImpl {

    private int[] data;
    private int size;

    IteratorImpl(int[] data) {
        this.data = data;
        this.size = data.length;
    }

    public Iterator iterator(){
        return new InnerIterator2();
    }

    private class InnerIterator2 implements Iterator {
        private int index = 0;
        private int lastReturnIndex = -1;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public int next() throws Exception {
            if(hasNext())   {
                lastReturnIndex = index;
                return data[index++];
            }
            else{
                throw new Exception("no more element availiable");
            }
        }

        @Override
        public void remove() {
            if(lastReturnIndex<0){
                throw new IllegalStateException("call remove() method before next()");
            }
            for(int i = lastReturnIndex ; i<size-1;i++){
                data[i] = data[i+1];
            }
            index = lastReturnIndex;
            lastReturnIndex = -1;
        }
    }
}

public class Iterator2 {

    public static void main(String args[]) throws Exception {
        int [] data = {1,3,4,3,4,5,6};
        IteratorImpl iteratorImpl = new IteratorImpl(data);
        Iterator iterator = iteratorImpl.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
