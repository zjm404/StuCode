package cn.zjm404.stu.demo.ediary;

import org.junit.Test;

public class TextToEDiaryTest {


    //--------------------日期测试---------------------------------------------

    /**
     * 一位数月一位数日
     */
    @Test
    public void getNewFileNameType_1() {
        String msg = TextToEDiary.getNewFileName("二零一八年十月十日 / Demo");
        System.out.println(msg);
    }
    @Test
    public void getNewFileNameType_1_1() {
        String msg = TextToEDiary.getNewFileName("二零一八年十月一日 / Demo");
        System.out.println(msg);
    }
    /**
     * 一位数月两位数日
     */
    @Test
    public void getNewFileNameType_2() {
        System.out.println(TextToEDiary.getNewFileName("二零一八年五月十一日 / Demo"));
    }
    @Test
    public void getNewFileNameType_2_1() {
        System.out.println(TextToEDiary.getNewFileName("二零二零年一月三十日 /\n"));
    }
    /**
     * 一位数月三位日
     */
    @Test
    public void getNewFileNameType_3() {
        String msg = TextToEDiary.getNewFileName("二零一八年五月三十一日 / Demo");
        System.out.println(msg);
    }
    /**
     * 两位数月一位数日
     */
    @Test
    public void getNewFileNameType_4() {
        System.out.println(TextToEDiary.getNewFileName("二零一八年十二月十日 / Demo"));

    }
    /**
     * 两位数月两位数日
     */
    @Test
    public void getNewFileNameType_5() {
        System.out.println(TextToEDiary.getNewFileName("二零一八年十二月十一日 / Demo"));

    }
    /**
     * 两位数月三位数日
     */
    @Test
    public void getNewFileNameType_6() {
        System.out.println(TextToEDiary.getNewFileName("二零一八年十二月三十一日 / Demo"));

    }

    //-------------------正文测试----------------------------------------
    /**
     * 正文内容不包含'/'
     */
    @Test
    public void getNewFileNameType_7() {
        System.out.println(TextToEDiary.getNewFileName("Demo"));
    }

    /**
     * 正文内容，包含'/',符号‘/’前后均无空格
     */
    @Test
    public void getNewFileNameType_8() {
        System.out.println(TextToEDiary.getNewFileName("125215De的d/mo125"));

    }
    @Test
    public void getNewFileNameType_9() {
        System.out.println(TextToEDiary.getNewFileName("2020 / helloworld"));

    }
}