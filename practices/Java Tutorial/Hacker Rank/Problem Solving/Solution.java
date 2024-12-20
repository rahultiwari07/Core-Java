class Solution1{
    private int y ;

    Solution1(){
        System.out.println("constructor");
    }
    private Solution1(int i){
        this.y = i;
    }

    public void display(){
        System.out.println("private constructor => " + this.y);
       }
}

class Solution {
   private static int z = 10;
   private int x;

   private Solution(int z){
    this.x = z;
   }

   public void display(){
    System.out.println("private constructor => " + this.x);
   }
    static class NestedClass{
        private static int x = 1;
        private int y = 2;
        
        public void outerDisplay(){
            System.out.println("outer display with static value : " + z);
            System.out.println("outer display with non static value : " + y);
        } 
        public static void staticOuterFun(){
            System.out.println("outer display with static value : " + z);
        }
    }

    public static void main(String[] args) {
        Solution.NestedClass solution = new Solution.NestedClass();
        //solution.display();
        //solution.outerDisplay();
        Solution.NestedClass.staticOuterFun();

        Solution1 solution2 = new Solution1();
        solution2.display();

        //Solution1 solution3 = new Solution1(9);
        //solution3.display();
        //Solution.staticOuterFun();
        
    }
}