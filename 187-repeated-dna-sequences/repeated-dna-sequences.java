class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer>map=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<=s.length()-10;i++){
            String sub=s.substring(i,i+10);
            map.put(sub,map.getOrDefault(sub,0)+1);
            if(map.get(sub)>1){
                if(!list.contains(sub))
                     list.add(sub);
            }
        }
        return list;
    }
}