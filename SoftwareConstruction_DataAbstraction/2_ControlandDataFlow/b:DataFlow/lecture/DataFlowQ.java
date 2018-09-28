public class DataFlowQ {
    public static void mysteryMethod() {
        int mystery1 = 4;
        int mystery2 = 5;
        int mystery3;
    
        int a = mystery1;   // 4
        mystery1++;     // now equal -> 5
        mystery2 = a;   // 4
        
        mystery3 = mystery1 + mystery2;
        
        System.out.println("mystery1   = " + mystery1);   // 5
        System.out.println("mystery2   = " + mystery2);   // 4
        System.out.println("mystery3   = " + mystery3);   // 9
        System.out.println("mystery1++ = " + mystery1++); // 5
    }

    public static void main(String[] args) {
        mysteryMethod();
    }
}