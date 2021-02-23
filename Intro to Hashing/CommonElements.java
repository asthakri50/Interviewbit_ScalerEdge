public class Solution {
    public int[] solve(int[] A, int[] B) {
         // create hashsets 
        Map<Integer , Integer> map1 = new HashMap<>(); 
        Map<Integer , Integer> map2 = new HashMap<>(); 
        
        // Adding elements from array1 
        for (int i : A) { 
            if(map1.containsKey(i) )
                map1.put( i , map1.get(i) + 1);
            else
                map1.put( i , 1);
        } 
        
        
        // Adding elements from array2 
        for (int i : B) { 
            if(map2.containsKey(i) )
                map2.put( i , map2.get(i) + 1);
            else
                map2.put( i , 1);
        } 
        
        List<Integer> li = new ArrayList<>();
        for(int i : map1.keySet() ){
            if(map2.containsKey(i) ){
              int count = Math.min(map1.get(i) , map2.get(i) );
              while(count > 0){
                li.add(i);
                count-- ;
              }
            }
        }
        
        
        int[] ans = new int[li.size()];
        for(int i = 0 ;  i < li.size() ; i++)
            ans[i] = li.get(i) ;
        return ans;    
        
    }
}
