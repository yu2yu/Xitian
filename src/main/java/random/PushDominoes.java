package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description 推多米诺
 *  n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，
 * 倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * @createTime 2022-05-28 21:41:00
 */
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        // 每一张牌如果有方向则不会改变，那么我们只需要求出那些.的牌的方向
        dominoes = "L" + dominoes + "R";
        int l = 0;
        StringBuilder result = new StringBuilder();
        for (int r = 1; r < dominoes.length(); ++r) {
            // 查看左边和右边的倾斜情况
            if(dominoes.charAt(r) == '.'){
                continue;
            }
            if (l != 0) { // 虚拟的牌不放入结果
                result.append(dominoes.charAt(l));
            }
            int mid = r - l - 1;
            if(dominoes.charAt(l)  == dominoes.charAt(r) ){
                for (int i = 0; i < mid; i++) {
                    result.append(dominoes.charAt(l));
                }
            }else if(dominoes.charAt(l) == 'L' && dominoes.charAt(r) == 'R'){
                for (int i = 0; i < mid; i++) {
                    result.append('.');
                }
            }else{
                for (int i = 0; i < mid/2; i++) {
                    result.append('R');
                }

                if(mid%2 == 1){
                    result.append(".");
                }

                for (int i = 0; i < mid/2; i++) {
                    result.append('L');
                }
            }
            l = r;
        }
        return result.toString();
    }

    @Test
    public void testPushDominoes(){
        assertEquals("RR.L",pushDominoes("RR.L"));
        assertEquals("LL.RR.LLRRLL..",pushDominoes(".L.R...LR..L.."));
    }

}
