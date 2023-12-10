public class Solution {
    
    public int findRepeatDocument(int[] documents) {
        int len = documents.length;

        Map<Integer, Boolean> map = new HashMap<>();
        map.put(documents[0], true);
        for (int i = 1; i < len; i ++) {
            Boolean exist = map.get(documents[i]);
            if (exist != null && exist) {
                return documents[i];
            }
            map.put(documents[i], true);
        }
        return -1;
    }

    public int findRepeatDocument2(int[] documents) {
        int len = documents.length;

        int[] arr = new int[len];
        for (int i = 0; i < len; i ++) {
            if (arr[documents[i]] != 0) {
                return documents[i];
            }
            arr[documents[i]] ++;
        }
        return -1;
    }

}