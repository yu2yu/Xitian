package random;

import org.junit.jupiter.api.Test;
import tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @desc 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，
 * 累计整数和，先使得累计整数和 达到或超过 100 的玩家，即为胜者。
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 *
 * 给定两个整数maxChoosableInteger（整数池中可选择的最大数）和desiredTotal（累计和），
 * 若先出手的玩家是否能稳赢则返回 true，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 *
 *
 * @desc 两方博弈
 *
 * 1. 自底向上  状态空间
 * 2. 自顶向下  递归 + 备忘录
 *
 *
 *
 * 说实话，各种解答里面 & 和 | 这种二进制操作太烦人了
 * &	与	两个位都为1时，结果才为1
 * |	或	两个位都为0时，结果才为0
 * ^	异或	两个位相同为0，相异为1
 * ~	取反	0变1，1变0
 * <<	左移	各二进位全部左移若干位，高位丢弃，低位补0
 * >>	右移	各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移）
 *
 */
public class CanIWin {

    /**
     * 不能重复数字的话
     */
    public boolean canIWinNoRepeat(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal){
            return false;
        }
        return backTrace(maxChoosableInteger,0,desiredTotal,0);
    }


    Map<Integer, Boolean> memory = new HashMap<Integer, Boolean>();
    private boolean backTrace(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
        if(memory.containsKey(usedNumbers)){
            return memory.get(usedNumbers);
        }
        boolean res = false;
        //循环遍历选择每个数的情况，如果循环完所有的情况，都赢不了，那么就输了，因此初始res是输
        for (int i = 0; i < maxChoosableInteger; i++) {
            //若这个数还没被选择，才往下做逻辑，
            // 否则进入下一轮循环(注意这里i是从0开始，所以判断的是第i+1个数的情况)
            if (((usedNumbers >> i) & 1) == 0) {
                //如果选完能直接胜利，那么结果自然为true
                if (i + 1 + currentTotal >= desiredTotal) {
                    res = true;
                    break;
                }
                //否则的话，递归判断，我选完后，对方选完是不是就输了；对方输了，我自然就赢了，有点绕
                if (!backTrace(maxChoosableInteger,
                        usedNumbers | (1 << i),
                        desiredTotal, currentTotal + i + 1)) {
                    res = true;
                    break;
                }
            }
            //把结果放入记忆化
        }
        memory.put(usedNumbers,res);
        return res;
    }


    @Test
    public void testCanIWin(){
        assertFalse(canIWinNoRepeat(10,11));
        assertTrue(canIWinNoRepeat(10,0));
        assertTrue(canIWinNoRepeat(10,1));
        assertFalse(canIWinNoRepeat(10,40));
        assertFalse(canIWinNoRepeat(4,6));
    }

}
