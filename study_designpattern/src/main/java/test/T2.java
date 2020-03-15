package test;

/**
 * 2. 缩写校验（建议时间复杂度 O(n) ）
 * 给定⼀个⾮空字符串 s 和⼀个缩写 abbr，请校验它们是否匹配。
 * 假设字符串中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。缩写中的数字
 * 表示其缩略的字符数；连续多位数字表示⼀个多位数。
 * 例如，字符串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd",
 * "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d",
 * "w3", “4"]。
 * 例 1：输⼊：s = “internationalization"，abbr = "i12iz4n"
 * 返回：true
 * 解释：abbr 中的 12 表示有⼗⼆个字符被缩略了。
 * 例 2：输⼊：s = “apple"，abbr = “a2e"
 * 返回：false
 * 需要实现的⽅法原型：boolean valid(String word, String abbr)
 */
public class T2 {
    public boolean valid(String word, String abbr) {
        if (abbr == null || abbr.isEmpty()) return false;
        int wIndex = -1;
        int ignore = 0;
        int wordLen = word.length();
        int abbrLen = abbr.length();
        for (int i = 0; i < abbrLen; i++) {
            char abbri = abbr.charAt(i);
            //当前是数字
            if (abbri >= '0' && abbri <= '9') {
                ignore = ignore * 10 + (abbri - '0');
            } else {
                // 当前不是数字,
                // 要先判断wIndex + 省略的长度 + 1 是否已经超过word的length-1
                // 再判断当前位置的字符是否相同
                wIndex = wIndex + ignore + 1;
                ignore = 0;
                if (wIndex > wordLen - 1 || abbri != word.charAt(wIndex)) {
                    return false;
                }
            }
        }
        if (ignore > 0) {
            wIndex = wIndex + ignore;
        }
        return wIndex == wordLen - 1;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        String[] test = {"word", "1ord", "w1rd", "wo1d","wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d","w3", "4"};
        for (String s : test) {
            System.out.println(t2.valid("word", s));
        }
    }
}
