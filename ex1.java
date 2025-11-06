class Main {
    public static void main(String[] args) {
     ex1();
     ex2();
     ex3();
     ex4();
     ex5();
     ex6();
     ex7();
     ex8();
     ex9();
     ex10();
    }   
    
    public static void ex1(){
        String str = "Test";
        System.out.println(str.contains("Testing")); //false
        System.out.println(str.contains("Tes")); //true
    }
    
    public static void ex2(){
        String str = "Test";
        var c = str.charAt(3);
        System.out.println(c);
    }
    
    public static void ex3(){
        String str1 = "Test1";
        String str2 = "Test2";
        String str3 = str1.concat(str2);
        System.out.println(str3);
    }
    
    public static void ex4(){
        String str = "         Test                            ";
        System.out.println(str.trim());
    }
        
    public static void ex5(){
        long num = 557406901;
        String str = String.valueOf(num);
        System.out.println(str + ", Type is: " + str.getClass().getName());
    }
    
    public static void ex6(){
        String str = "Test";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
    }
    
    public static void ex7(){
        String str = "test";
        System.out.println(str.indexOf("e"));
        System.out.println(str.lastIndexOf("t"));
    }

    public static void ex8(){
        String str = "Test";
        System.out.println(str.substring(1));
    }
    
    public static void ex9(){
        String str = "test";
        System.out.println(str.replace("t", "h"));
        System.out.println(str.replace("t", "a"));
    }
    
    public static void ex10(){
        StringBuffer strb = new StringBuffer("Testing Testing");
        strb.reverse();
        System.out.println(strb);
    }
}