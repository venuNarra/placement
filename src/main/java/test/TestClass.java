package test;
//import java.util.*;
//class TestClass {
//    public static void main(String args[] ) throws Exception {
//         //Sample code to perform I/O:
//        // * Use either of these methods for input
//
//        //BufferedReader
//        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // String name1 = br.readLine();                // Reading input from STDIN
//        // System.out.println(name1 );    // Writing output to STDOUT
//
//        //Scanner
//        Scanner s = new Scanner(System.in);
//        int size = Integer.parseInt(s.nextLine().trim());                 // Reading input from STDIN
//    
//        String arr[]=s.nextLine().split(" ");
//  
//        System.out.println(size );
//                System.out.println(arr );
//
//
//        // Write your code here
//
//    }
//}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
////import for Scanner and other utility classes
//import java.util.*;
//
//
//// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
//
//class TestClass {
//    public static void main(String args[] ) throws Exception {
//      
//
//        // //BufferedReader
//        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // String name = br.readLine();                // Reading input from STDIN
//        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
//
//        //Scanner
//      //  Scanner s = new Scanner(System.in);
//      //  String name = s.nextLine();  
//        String name="venu78, test 89  man 8";
//        // Reading input from STDIN
//        char arr[]=name.toCharArray();
//        boolean newLine=false;
//        for(char c:arr) {
//        	
//        	if(Character.isDigit(c)){
//        		System.out.print(c);
//        		newLine=true;
//        	}else {
//        		if(newLine) {
//        			System.out.println();
//        		}
//        		newLine=false;
//        		
//        	}
//        }
//
//       
//
//        // Write your code here
//
//    }
//}
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
 */
        //Scanner
//        Scanner s = new Scanner(System.in);
//        int n1 = Integer.parseInt(s.nextLine().trim());                 // Reading input from STDIN
//       String num1[]=s.nextLine().split(" ");
//       int n2 = Integer.parseInt(s.nextLine().trim());                 // Reading input from STDIN
//       String num2[]=s.nextLine().split(" ");
//       
//       System.out.println(n1);
//       System.out.println(n2);
//       System.out.println(num1);
//       System.out.println(num2);
       
//       int intArr1[]=new int[num1.length];
//       int intArr2[]=new int[num2.length];
//       for (int i = 0; i < num1.length; i++) {
//    	   intArr1[i] = Integer.parseInt(num1[i]);
//        }
//        for (int i = 0; i < num2.length; i++) {
//    	   intArr2[i] = Integer.parseInt(num2[i]);
//        }
//        int[] result=new int[n1+n2];
       // merge(intArr1,intArr2,n1,n2,result);

//        for(int i=0;i<result.length;i++){
//            System.out.print(result[i]+" ");
//        }
        count("Hello World");
        
       

       

        // Write your code here

    }
    public static void merge(int[] arr1,int[] arr2, int n1,int n2,int[] arr3){
       
//        int i=0,j=0,k=0;
//        while(i<n1 && j<n2){
//            if(arr1[i] < arr2[j]){
//                arr3[k++]=arr1[i++];
//            }else{
//                arr3[k++]=arr2[j++];
//            }
//        }
//        while(i<n1)
//            arr3[k++]=arr1[i++];
//        while(j<n2)
//            arr3[k++]=arr1[j++];
//    

    
    
 // Iterate through all elements of ar2[] starting from
    // the last element
    for (int i=n2-1; i>=0; i--)
    {
     
        int j, last = arr1[n1-1];
        for (j=n1-2; j >= 0 && arr1[j] > arr2[i]; j--)
            arr1[j+1] = arr1[j];
 
        if (j != n1-2 || last > arr2[i])
        {
            arr1[j+1] = arr2[i];
            arr2[i] = last;
        }
    }
    }
   public static void count(String name){

        int len = name.length();
        int[] arr=new int[26];

        for (int i = 0; i < len; ++i)
        {
            char c = name.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {

            if (c-'a' > 0)
            {
                arr[c-'a']++;
            }else {
            	arr[c-'A']++;
            }
        }
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        } 

            // Write your code here
   
    }
        
    }


