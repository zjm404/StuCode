package cn.zjm404.stu.demo.ediary;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextToEDiary {
    private static int prefixLen = 0;
    /**
     * 将文件中的日期转为eDiary规定导入的文件名格式
     * @param str 读取的一行信息
     * @return
     */
    public static String getNewFileName(String str){
        int len = 0;
        for (int i = 10; i < str.length() && i < 14 ; i++) {
            //若正文中有'/'需要识别(比如输入http://www.haoxg.net/index.html)
            if(str.charAt(i) == '/' && str.charAt(i-1)== ' '){
                if(i < str.length()-1 && str.charAt(i+1) == '/'){
                    continue;
                }
                len = i-1;
                //对正文无用的前缀长度
                prefixLen = i < len-1 ? len+3 : len+2;
                break;
            }
        }

        //该行不包含日期信息，说明不是一篇日记的起点，返回null
        if(len == 0){
            return null;
        }
        String msg = str.substring(0,len);
        char[] newFile = msg.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {

            switch(newFile[i]){
                case '零' : sb.append('0');break;
                case '一' : sb.append('1');break;
                case '二' : sb.append('2');break;
                case '三' : sb.append('3');break;
                case '四' : sb.append('4');break;
                case '五' : sb.append('5');break;
                case '六' : sb.append('6');break;
                case '七' : sb.append('7');break;
                case '八' : sb.append('8');break;
                case '九' : sb.append('9');break;
                case '十' : {
                    if(newFile[i-1] == '-'){
                        if(newFile[i+1] == '日'){
                            sb.append("10");
                            res.append(sb);
                            return res.toString();
                        }else if(newFile[i+1] == '月') {
                            sb.append("10");
                        }else {
                            sb.append('1');
                        }
                    }else {
                        if(newFile[i+1] == '日'){
                            sb.append("0");
                            res.append(sb);
                            return res.toString();
                        }else{

                        }
                    }
                }break;
                case '年' :
                case '月' :{
                    newFile[i] = '-';
                    sb.append('-');
                    res.append(sb);
                    sb = new StringBuilder();
                }break;
                case '日':{
                    res.append(sb);
                }break;
                default:break;
            }

        }
        return res.toString();
    }
    public static void toEDiary(String path){
        try(Reader reader = new FileReader(path);BufferedReader br = new BufferedReader(reader)){
            String str;
            String preFileName = null;
            StringBuilder sb = null;
            while((str = br.readLine()) != null){
                String newFileName = getNewFileName(str);
                if(newFileName != null){
                    if(preFileName != null){
                        try(FileOutputStream fout = new FileOutputStream("E:\\文档\\作业\\demo\\"+preFileName+".txt");OutputStreamWriter out = new OutputStreamWriter(fout, StandardCharsets.UTF_16)){
                            out.write(sb.toString());

                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    preFileName = newFileName;
                    sb = new StringBuilder();
                }
                sb.append(str.substring(prefixLen)+'\n');
                prefixLen = 0;
            }
            try(FileOutputStream fout = new FileOutputStream("E:\\文档\\作业\\demo\\"+preFileName+".txt");OutputStreamWriter out = new OutputStreamWriter(fout, StandardCharsets.UTF_16)){
                out.write(sb.toString());

            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TextToEDiary.toEDiary("E:\\文档\\日记.txt");

    }
}
