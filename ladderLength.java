class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord); //字典中可能有beginWord

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //用来标记是否被使用
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while(!queue.isEmpty()) {
            int currentSize = queue.size();
            for(int i = 0;i < currentSize;i++) {
                String currentWord = queue.poll();
                if(changeWordEveryOneLetter(currentWord,endWord,queue,visited,wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }
    public boolean changeWordEveryOneLetter(String currentWord,String endWord,Queue<String> queue,
                                            Set<String> visited,Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for(int i = 0;i < endWord.length();i++) {
            char originChar = charArray[i];
            for(char k = 'a';k <= 'z';k++) { //遍历a~z替换beginWord的第i个字符
                if(k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)) { //改变一个字符后的单词是否在词典中
                    if(nextWord.equals(endWord)) {  //是否变为endWord
                        return true;
                    }
                    if(!visited.contains(nextWord)) { //未被使用则加入queue中
                        queue.add(nextWord);
                        visited.add(nextWord);  //标记为被使用过，否则会死循环
                    }
                }
            }
            charArray[i] = originChar; //变回原单词
        }
        return false;
    }
}