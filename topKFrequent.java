class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> notes = new HashMap<>();
        for(int i = 0;i < words.length;i++) {
                notes.put(words[i],notes.getOrDefault(words[i],0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(notes.get(o1).equals(notes.get(o2))) {
                    return o2.compareTo(o1);//因为后面需要翻转所以，按字母顺序降序排序
                }else {
                    return notes.get(o1) - notes.get(o2);//按出现频率排序
                }
            }
        });
        for(String str : notes.keySet()) {
            minHeap.offer(str);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        //此时res按照频率从小到大存放，需要翻转
        Collections.reverse(res);
        return res;
    }
}