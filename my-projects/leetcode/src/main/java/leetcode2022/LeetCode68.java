package leetcode2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/10 10:52
 * @ Description
 */
public class LeetCode68 {

    public static void main(String[] args) {
        LeetCode68 lc = new LeetCode68();
//        lc.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).forEach(System.out::println);
//        lc.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16).forEach(System.out::println);
        lc.fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16).forEach(System.out::println);
//        lc.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20).forEach(System.out::println);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<List<String>> allRow = new ArrayList<>();
        List<Integer> spaceNum = new ArrayList<>();
        List<String> row = new ArrayList<>();
        int wordsLengthOneRow = 0;
        for (String word : words) {
            if (wordsLengthOneRow + word.length() + row.size() > maxWidth) {
                allRow.add(row);
                spaceNum.add(maxWidth - wordsLengthOneRow);
                row = new ArrayList<>();
                row.add(word);
                wordsLengthOneRow = word.length();
            } else {
                row.add(word);
                wordsLengthOneRow += word.length();
            }
        }
        allRow.add(row);
        spaceNum.add(maxWidth - wordsLengthOneRow);
        for (int i = 0; i < allRow.size(); i++) {
            StringBuilder sb = new StringBuilder();
            List<String> rowWords = allRow.get(i);
            Integer space = spaceNum.get(i);
            if (rowWords.size() == 1) {
                sb.append(rowWords.get(0));
                for (int integer = 0; integer < space; integer++) {
                    sb.append(" ");
                }
            } else if (i != allRow.size() - 1) {
                int everySpace = space / (rowWords.size() - 1);
                int spaceRemain = space % (rowWords.size() - 1);
                for (int j = 0; j < rowWords.size(); j++) {
                    sb.append(rowWords.get(j));
                    if (j != rowWords.size() - 1) {
                        for (int integer = 0; integer < everySpace; integer++) {
                            sb.append(" ");
                            if (spaceRemain != 0) {
                                sb.append(" ");
                                spaceRemain--;
                            }
                        }
                    }
                }
            } else {
                for (int j = 0; j < rowWords.size(); j++) {
                    sb.append(rowWords.get(j));
                    if(space>0){
                        sb.append(" ");
                        space--;
                    }
                    if (j == rowWords.size() - 1) {
                        for (int integer = 0; integer < space; integer++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
