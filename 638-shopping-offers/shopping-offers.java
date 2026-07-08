class Solution {
    HashMap<List<Integer> , Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> offer, List<Integer> needs) {
        return helper(price , offer , needs);
    }
    public int helper(List<Integer> price , List<List<Integer>> offer , List<Integer> needs){
        if(map.containsKey(needs)) return map.get(needs);

        int ans = 0;

        for(int i=0;i<needs.size();i++){
            ans += (price.get(i) * needs.get(i));
        }

        for(int i=0;i<offer.size();i++){
            List<Integer> curr = offer.get(i);

            List<Integer> newneed = new ArrayList<>();

            boolean flag = true;

            for(int j=0;j<needs.size();j++){
                if(needs.get(j) < curr.get(j)){
                    flag = false;
                    break;
                }
                newneed.add(needs.get(j) - curr.get(j));
            }

            if(flag){
                ans = Math.min(ans , curr.get(needs.size()) + helper(price , offer ,newneed));
            }
        }

        map.put(needs , ans);
        return ans;
    }
}