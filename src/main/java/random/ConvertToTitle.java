package random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description Excel表列名称
 *  给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * @createTime 2022-06-02 18:43:00
 */
public class ConvertToTitle {


    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while(columnNumber > 0){
            int a0 = (columnNumber - 1) % 26 + 1;
            result.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return result.reverse().toString();
    }

    @Test
    public void testConvertToTitle(){
        assertEquals("A",convertToTitle(1));
        assertEquals("AB",convertToTitle(28));
        assertEquals("ZY",convertToTitle(701));
        assertEquals("FXSHRXW",convertToTitle(2147483647));
    }

}
